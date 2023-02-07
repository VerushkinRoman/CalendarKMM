import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual class CoroutinesDispatchersImpl : CoroutinesDispatchers {
    actual override val main: CoroutineDispatcher = Dispatchers.Main
    actual override val io: CoroutineDispatcher = Dispatchers.Default
    actual override val default: CoroutineDispatcher = Dispatchers.Default
    actual override val unconfined: CoroutineDispatcher = Dispatchers.Unconfined
}