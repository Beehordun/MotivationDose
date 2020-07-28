package com.biodun.mindvalley.core

sealed class ViewState <T> {
    class Loading<T> : ViewState<T>()
    class Success<T>(val data: T) : ViewState<T>()
    class Error<T> : ViewState<T>()
}
