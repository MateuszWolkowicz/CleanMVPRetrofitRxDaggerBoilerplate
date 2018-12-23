package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login.mvvm

data class Resource<out T> constructor(
        val state: ResourceState,
        val data: T? = null,
        val message: String? = null
)