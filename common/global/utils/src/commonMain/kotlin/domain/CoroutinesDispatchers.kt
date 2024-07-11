package domain

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutinesDispatchers {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
    val default: CoroutineDispatcher
}