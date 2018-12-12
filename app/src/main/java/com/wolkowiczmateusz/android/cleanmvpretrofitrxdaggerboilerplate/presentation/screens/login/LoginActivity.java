package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.ContentViewEvent;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.App;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.R;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base.BaseActivity;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.fabric.sdk.android.Fabric;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.emailEditText)
    EditText emailEditText;
    @BindView(R.id.passwordEditText)
    EditText passwordEditText;
    @BindView(R.id.loginButton)
    TextView loginButton;
    @BindView(R.id.registerButton)
    TextView registerButton;
    @BindView(R.id.emailTextInputLayout)
    TextInputLayout emailTextInputLayout;
    @BindView(R.id.passwordTextInputLayout)
    TextInputLayout passwordTextInputLayout;
    @Inject
    LoginContract.Presenter<LoginContract.View> loginPresenter;
    private String Tag = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ((App) getApplication()).getAppComponent()
                .inject(this);
        loginPresenter.onAttach(this);

        // TODO: Use your own attributes to track content views in your app
        Answers.getInstance().logContentView(new ContentViewEvent()
                .putContentName("Tweet")
                .putContentType("Video")
                .putContentId("1234")
                .putCustomAttribute("Favorites Count", 20)
                .putCustomAttribute("Screen Orientation", "Landscape"));


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @OnClick({R.id.loginButton, R.id.registerButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.loginButton:
                loginPresenter.LoginClick(emailEditText.getText()
                        .toString(), passwordEditText.getText().toString());
                break;
            case R.id.registerButton:
                forceCrash();
                //  Crashlytics.getInstance().crash();
                loginPresenter.RegisterClick();
                break;
        }
    }

    public void forceCrash() {
        Crashlytics.setUserIdentifier("idCrash");
        Crashlytics.setUserEmail("useremailCrash");
        Crashlytics.setUserName("usernameCrash");
        throw new RuntimeException("This is a crash");
    }


    @Override
    public void disableLoginButton(boolean state) {
        loginButton.setEnabled(!state);
    }

    @Override
    public void showErrors(String errorEmail, String errorPassword) {
        passwordTextInputLayout.setError(errorPassword);
        emailTextInputLayout.setError(errorEmail);
    }

    @Override
    public void showRegister() {
    }

    @Override
    public void Login() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
