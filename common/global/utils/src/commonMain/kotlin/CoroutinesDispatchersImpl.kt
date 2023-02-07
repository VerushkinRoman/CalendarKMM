import kotlinx.coroutines.CoroutineDispatcher

expect class CoroutinesDispatchersImpl() : CoroutinesDispatchers {
    override val main: CoroutineDispatcher
    override val io: CoroutineDispatcher
    override val default: CoroutineDispatcher
    override val unconfined: CoroutineDispatcher
}