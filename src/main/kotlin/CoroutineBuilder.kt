import kotlinx.coroutines.*

/*
    Coroutine Builders -> They create the coroutines

    1. launch : It is also called "FIRE AND FORGET" meaning when launch is called a new coroutine is
        created, and it will not return anything to its caller.

        -> It returns Job object.
        -> It doesn't block the thread.

    Diff b/w launch and GlobalScope.launch ?
        ## launch -> It has a local scope which means that the coroutine will destroy as soon as the component
        (activity) of the app gets destroyed.
        -> It runs on its immediate parent thread.
        eg :- login etc.

        ## GlobalScope.launch -> It has a global scope which means it can survive to the entire life of the
        application.
        eg :- file download etc.

    2. runBlocking
        -> IT blocks the thread.

    3. async : It is more similar to launch. [async and GlobalScope.async]

        -> It returns DeferredJob<T> object.
        -> It doesn't block the thread.
*/

fun main() = runBlocking {

    println("Main program starts : ${Thread.currentThread().name}")

    val job : Job = launch {// Thread : Main
        println("Fake work starts : ${Thread.currentThread().name}") // Thread : Main
        delay(1000) // Coroutine is suspended and main thread is free (not blocked)
        println("Fake work ends : ${Thread.currentThread().name}") // Thread : Main or different thread

    }

    job.join() // wait for the coroutine to complete the task.
    //delay(2000)
    println("Main program ends: ${Thread.currentThread().name}") // Thread : Main

    //-----------------------------------------------------------------------------------------

    println("Main program starts : ${Thread.currentThread().name}")

    val defferedJob : Deferred<Unit> = async {// Thread : Main
        println("Fake work starts : ${Thread.currentThread().name}") // Thread : Main
        delay(1000) // Coroutine is suspended and main thread is free (not blocked)
        println("Fake work ends : ${Thread.currentThread().name}") // Thread : Main or different thread

    }

    defferedJob.join() // wait for the coroutine to complete the task.
    //delay(2000)
    println("Main program ends: ${Thread.currentThread().name}") // Thread : Main
}