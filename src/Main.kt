fun main() {
    val flow = Flow()
    flow.addToMap(Task("I go sleep"))
    flow.addToMap(Task("lets work"))
    while (true) {
        print("Create or find Todo task: 1 - create, 2 - find, 3 - show all tasks ")
        val stringInput = readLine()
        when (stringInput) {
            "1" -> createTask(flow)
            "2" -> findTask(flow)
            "3" -> flow.showAllTask()
        }
    }
}

fun createTask(flow: Flow) {
    print("Enter your task name ")
    val tittle = readLine()
    val task = Task(tittle!!)
    flow.addToMap(task)
}

fun findTask(flow: Flow) {
    print("Enter the name of your task you want to find ")
    val tittle = readLine()
    if (tittle != null) {
        flow.findTask(tittle)
    }
}