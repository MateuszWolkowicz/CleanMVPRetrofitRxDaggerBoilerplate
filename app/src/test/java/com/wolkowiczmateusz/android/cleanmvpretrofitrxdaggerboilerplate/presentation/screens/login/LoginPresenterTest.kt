package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login

import android.content.res.Resources
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.TestData
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.Impl.TryToLoginUseCaseImpl
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.exception.CustomExceptions
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.wrappers.EmailMatcherWrapper
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.rxjavatest.TestSchedulerProvider
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.TestScheduler
import org.junit.Ignore
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class LoginPresenterTest {

    @MockK
    lateinit var tryToLoginUseCase: TryToLoginUseCaseImpl
    @RelaxedMockK
    lateinit var mvpView: LoginContract.View
    @RelaxedMockK
    lateinit var resources: Resources
    @MockK
    lateinit var emailMatcherWrapper: EmailMatcherWrapper
    @RelaxedMockK
    lateinit var customExceptions: CustomExceptions

    private var testScheduler: TestScheduler = TestScheduler()
    private var threadExecutor: Executor = TestSchedulerProvider(testScheduler)
    private var mainThread: MainThread = TestSchedulerProvider(testScheduler)
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    @InjectMockKs
    lateinit var loginPresenter: LoginPresenter<LoginContract.View>

    @BeforeEach
    fun setUp() {
        loginPresenter = LoginPresenter(threadExecutor, mainThread, compositeDisposable)
        MockKAnnotations.init(this)
        clearAllMocks()
        loginPresenter.onAttach(mvpView)
    }

    @AfterEach
    fun tearDown() {
        loginPresenter.onDetach()
    }

    @Test
    fun `password and email empty won't run useCase and show errors for email and password`() {
        // given
        val email = ""
        val password = ""
        every { resources.getString(any()) } returns TestData.ERROR_MESSAGE
        // when
        loginPresenter.loginClick(email, password)
        // then
        verify { mvpView.showErrors(TestData.ERROR_MESSAGE, TestData.ERROR_MESSAGE) }
        verify(exactly = 1) { mvpView.showErrors(TestData.ERROR_MESSAGE, TestData.ERROR_MESSAGE) }
        verify { tryToLoginUseCase.runUseCase(any()) wasNot Called }
    }

    // MockK issue i think
    @Ignore
    fun `valid password and email will run useCase and show no errors`() {
        // given
        val email = "ok@ok.pl"
        val password = "123456"
        every { resources.getString(any()) } returns TestData.ERROR_MESSAGE
        every { emailMatcherWrapper.isEmailValid(any()) } returns true
        // when
        loginPresenter.loginClick(email, password)
        // then
        verify { mvpView.showErrors(TestData.ERROR_MESSAGE, TestData.ERROR_MESSAGE) }
        verify(exactly = 0) { mvpView.showErrors(TestData.ERROR_MESSAGE, TestData.ERROR_MESSAGE) }
        verify(exactly = 1) { tryToLoginUseCase.runUseCase(any()) }
    }

    @Test
    fun `password valid and email empty won't run useCase and show error only for email`() {
        // given
        val email = ""
        val password = "123456"
        every { resources.getString(any()) } returns TestData.ERROR_MESSAGE
        // when
        loginPresenter.loginClick(email, password)
        // then
        verify { mvpView.showErrors(TestData.ERROR_MESSAGE, null) }
        verify(exactly = 1) { mvpView.showErrors(TestData.ERROR_MESSAGE, null) }
        verify { tryToLoginUseCase.runUseCase(any()) wasNot Called }
    }

    @Test
    fun `repository response success - view valid login action`() {
        // given
        val email = "ok@ok.pl"
        val password = "123456"
        val user = User("1", "", "", "", "", "")
        every {
            tryToLoginUseCase.runUseCase(
                email,
                password
            )
        } returns Observable.create { subscriber -> subscriber.onNext(user) }
        // when
        loginPresenter.tryLogin(email, password)
        // then
        verify(exactly = 1) { tryToLoginUseCase.runUseCase(email, password) }
        assertNotNull(mvpView)
        testScheduler.triggerActions()
        verify(exactly = 1) { mvpView.login() }
    }
}