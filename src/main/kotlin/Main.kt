import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() { // Executes main thread

    println("Main Program starts : ${Thread.currentThread().name}")

    GlobalScope.launch { // creates a background thread T1

        println("Fake work starts : ${Thread.currentThread().name}")

        delay(1000) // Coroutine is suspended and Thread T1 is freed (not blocked)
        Thread.sleep(1000) // Thread T1 is blocked for 1 second.

        println("Fake work ends : ${Thread.currentThread().name}")
    }

    // Blocks the main thread and wait for the coroutine to finish the task.
    Thread.sleep(1000)
    println("Main Program ends : ${Thread.currentThread().name}")
}