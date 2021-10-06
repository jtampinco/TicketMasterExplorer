package com.jtampinco.ticketmasterexplorer.data.base

/**
 * Generic class to handle repository responses
 */
sealed class RepoResponse<T> {
    /**
     * Response received on a successful call. Returns an object with [data] property.
     * @property data The data returned by the call
     */
    class Success<T>(val data: T) : RepoResponse<T>()

    /**
     * Response received when the API returns an error. Returns the following properties:
     * [error], [message], [data]
     * @property error The error returned by the API
     * @property message Optional message parsed from the API response
     * @property data Optional data returned, typically this is null
     */
    class Failed<T>(
        val error: Throwable,
        val message: String? = null,
        val code: Int?,
        val data: T? = null,
    ) : RepoResponse<T>()

    /**
     * Response received when network returns an error. Typically used for
     * returning error when internet is offline, unavailable network or timeouts.
     * Returns the following properties:
     * [error], [data]
     * @property error The error returned by the API
     * @property data Optional data returned, typically this is null
     */
    class Error<T>(
        val error: Throwable,
        val data: T? = null,
    ) : RepoResponse<T>()
}