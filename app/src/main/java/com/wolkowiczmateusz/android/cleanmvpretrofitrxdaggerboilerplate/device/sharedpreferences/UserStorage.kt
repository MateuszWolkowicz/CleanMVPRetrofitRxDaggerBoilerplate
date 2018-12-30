package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.device.sharedpreferences

import android.content.SharedPreferences
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single

class UserStorage(private val preferences: SharedPreferences) {

    val user: User
        get() {
            return User(
                preferences.getString(USER_ID, "")
                , preferences.getString(SESSION_TOKEN, "")
                , preferences.getString(USERNAME, "")
                , preferences.getString(EMAIL, "")
                , preferences.getString(FIRST_NAME, "")
                , preferences.getString(LAST_NAME, "")
            )
        }

    val isUserLogin: Single<Boolean>
        get() = Single.defer { Single.just(!preferences.getString(SESSION_TOKEN, "")!!.isEmpty()) }

    val email: String?
        get() = preferences.getString(EMAIL, "")

    val userId: String?
        get() = preferences.getString(USER_ID, "")

    val token: String?
        get() = preferences.getString(SESSION_TOKEN, "")

    fun saveUser(user: User) {
        val editor = preferences.edit()
        editor.putString(SESSION_TOKEN, user.sessionToken)
        editor.putString(USERNAME, user.username)
        editor.putString(EMAIL, user.email)
        editor.putString(FIRST_NAME, user.firstName)
        editor.putString(LAST_NAME, user.lastName)
        editor.putString(USER_ID, user.userId)
        editor.apply()
    }

    fun logout(): Completable {
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
        return Completable.complete()
    }

    companion object {
        private const val SESSION_TOKEN = "sessionToken"
        private const val USERNAME = "username"
        private const val EMAIL = "email"
        private const val FIRST_NAME = "firstName"
        private const val LAST_NAME = "lastName"
        private const val USER_ID = "userId"
    }
}
