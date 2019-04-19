fun main() {
    val CREATE_TASK = "create"
    val FIND_TASK = "find"
    val SHOW_TASKS = "show all tasks"

    val flow = Flow()
    flow.addToMap(Task("I go sleep"))
    flow.addToMap(Task("lets work"))

    while (true) {
        print("Create or find Todo task, print: create, find, show all tasks ")
        val stringInput = readLine()
        when (stringInput) {
            CREATE_TASK -> createTask(flow)
            FIND_TASK -> findTask(flow)
            SHOW_TASKS -> flow.showAllTask()
        }
    }
}

fun createTask(flow: Flow) {
    print("Enter your task name ")
    val tittle = readLine()
    val task = Task(tittle!!)
    flow.addToMap(task)
    print("Do you want to assign an author-s to this task? Print yes/not ")
    val answer = readLine()
    when (answer) {
        "yes" -> changeTaskAuthor(task, flow)
    }
    print("Task success created\n")
}

fun findTask(flow: Flow) {
    val CHANGE_AUTHOR = "CHANGE_AUTHOR"
    print("Enter the name of your task you want to find ")
    val tittle = readLine()
    if (tittle != null) {
        flow.findTask(tittle)
         print("Print $CHANGE_AUTHOR if you want to change author")
        val answer = readLine()
        when (answer) {
            CHANGE_AUTHOR -> changeTaskAuthor(flow.getTask(tittle), flow)
        }
    }
}

fun changeTaskAuthor(task: Task, flow: Flow) {
    print("Please print author-s of this task ")
    val author = readLine()
    val authors = Author(author!!.split(","))
    flow.assignAuthorToTask(task, authors)
}
