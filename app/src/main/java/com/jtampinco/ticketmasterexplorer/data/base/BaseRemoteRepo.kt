package com.jtampinco.ticketmasterexplorer.data.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRemoteRepo {
    protected suspend fun <T> callApi(
        apiCall: suspend () -> T,
    ): RepoResponse<T> = try {
        val response = apiCall()
        RepoResponse.Success(response)
    } catch (e: HttpException) {
        val message = withContext(Dispatchers.IO) {
            e.response()?.errorBody()?.string()
                ?: let { e.message ?: e.javaClass.simpleName }
        }
        RepoResponse.Failed(e, message, e.code())
    } catch (e: Exception) {
        RepoResponse.Error(e)
    }
}
