import kotlinx.coroutines.*

/*
        HANDLING EXCEPTION

        1. Cancellable suspending functions such as yield(), delay() etc. throw CancellationException
        on the coroutine cancellation.

        2. you cannot execute a suspending function from the final block because the coroutine running
        this code is already cancelled.

        3. If you want to execute a suspending function from a final block then wrap the code within
        withContext(NonCancellable) function.
 */

fun main() = runBlocking {
     println("Main program starts: ${Thread.currentThread().name}")

    val job: Job = launch(Dispatchers.IO) {
        try{
            for(i in 0..500) {
                print("$i.")
                delay(5)
            }
        } catch (ex : CancellationException) {
            print("Exceptoin caught safely")
        } finally {

            delay(1000)
            print("Close resources finally")
        }
    }

    println("Main program ends: ${Thread.currentThread().name}")
}