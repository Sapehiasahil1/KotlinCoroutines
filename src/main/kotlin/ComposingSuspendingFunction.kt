import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/*

    Composing Suspending Function

    1. Sequential Execution (Default)
    2. Concurrent Execution (Achieve concurrent execution using async{})  we cannot use launch because it
        does not return anything.
    3. Lazy Execution
 */
/*
Sequential Execution - It is the default mode of execution in which code executes from top to bottom.

fun main() = runBlocking {

    println("Main program starts:${Thread.currentThread().name}")

    val time = measureTimeMillis {

        val msgOne = getMessageOne()
        val msgTwo = getMessageTwo()

        println("The message is :${msgOne + msgTwo}")
    }

    println("Time taken :${time}")

    println("Main program ends : ${Thread.currentThread().name}")
}
*/

/*
 Concurrent Execution
fun main() = runBlocking{

    println("Main program starts:${Thread.currentThread().name}")

    val time = measureTimeMillis {

        val msgOne : Deferred<String> = async { getMessageOne() }
        val msgTwo : Deferred<String> = async {getMessageTwo()}

        println("The message is :${msgOne.await() + msgTwo.await()}")
    }

    println("Complete time taken : ${time}")
    println("Main program ends :${Thread.currentThread().name}")
}
*/

// Lazy Execution
fun abc() = runBlocking {

    println("Main program starts:${Thread.currentThread().name}")

    val time = measureTimeMillis {

//        async(start = CoroutineStart.LAZY)-- This function makes the coroutine only execute if it is
        // providing any result to the code otherwise it doesnot work.

        val msgOne: Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageOne() }
        val msgTwo: Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageTwo() }

        println("The message is :${msgOne.await() + msgTwo.await()}")
    }

    println("Complete time taken : ${time}")
    println("Main program ends :${Thread.currentThread().name}")

}
suspend fun getMessageOne() : String {

    delay(1000)
    return "Hello"
}

suspend fun getMessageTwo() : String {

    delay(1000)
    return "World"
}


