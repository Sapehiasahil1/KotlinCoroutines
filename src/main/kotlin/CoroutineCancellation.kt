import kotlinx.coroutines.*

/*
 To cancel a coroutine, it should be cooperative.

    Two ways to make Coroutine Cooperative

    1. Periodically invoke a suspending function that checks for cancellation.

    -> Only those suspending functions that belong to "Kotlinx.coroutines" are cooperative
        eg:- delay(), withContext() etc.

    2. Explicitly check the cancellation status within the coroutine

    -> CoroutineScope.isActive boolean flag
 */

fun main() = runBlocking {

    println("Main program starts :${Thread.currentThread().name}")

    val job : Job = launch {

        for(i in 0..500) {
            print("$i.")

            //Thread.sleep(50)  as this does not belong to Kotlinx.coroutines package,
            // so it will not get cancelled.
            delay(50) // As this is a suspending func that belongs to Kotlinx.coroutines package,
            // so it will get cancel.

        }
    }
    delay(500)
    job.cancel()
    job.join()

    //job.cancelAndJoin() Instead of using cancel and join separately we can use them together, this
    // statement means that if the coroutine is not cancelable so we should wait for the coroutine to
    // finish

    println("Program ends : ${Thread.currentThread().name}")
}