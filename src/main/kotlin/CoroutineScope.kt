import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*

        Every coroutine irrespective of being a parent or child has its own coroutine scope.

fun main() = runBlocking {

    println("runBlocking :${this}")

    launch {
        println("launch : ${this}")

        launch {
        println("child launch : ${this})
        }
    }

    async {
        println("async : ${this}")
    }
}
 */