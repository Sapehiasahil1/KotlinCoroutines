import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

/*

    Similarly to launch and async functions
    --> withTimeout and withTimeoutOrNull functions are also coroutine builders

    The difference between withTimeout and withTimeoutOrNull is
    withTimeout -> returns the exception
    withTimeoutOrNull -> doesn't return the exception
 */

fun main() = runBlocking{

    println("Main Program starts :${Thread.currentThread().name}")

    withTimeout(2000) {

        for(i in 1..500) {
            print("$i.")
            delay(200)
        }
    }

    println("Main Program ends :${Thread.currentThread().name}")
}