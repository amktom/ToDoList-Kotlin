class Flow(val task: Task? = null) {

    val UP_BORDER = "*************************************\n"
    val BOTTOM_BORDER = "*************************************\n"
    private val taskMap: MutableMap<String, Task> = HashMap()
    private val taskHolder: MutableMap<Task, Author> = HashMap()

    fun addToMap(task: Task) {
        taskMap.put(task.title, task)
    }

    fun findTask(tittle: String) {
        if (taskMap.containsKey(tittle)) {
            printTask(taskMap.get(tittle)!!)
            print("Change status ${TaskState.IN_PROGRESS}/ ${TaskState.CLOSE}/ or your status?\n")
            print("Print exit if you will not changing status ")
            val status = readLine()
            when (status) {
                TaskState.IN_PROGRESS.toString() -> {
                    if (taskHolder.contains(taskMap.get(tittle)!!)) {
                        val authors = taskHolder.get(taskMap.get(tittle)!!)
                        taskHolder.remove(taskMap.get(tittle)!!)
                        taskMap.remove(tittle)
                        addToMap(Task(tittle, TaskState.CLOSE.toString()))
                        assignAuthorToTask(Task(tittle, TaskState.IN_PROGRESS.toString()), authors!!)
                    } else {
                        taskMap.remove(tittle)
                        addToMap(Task(tittle, TaskState.IN_PROGRESS.toString()))
                    }
                }
                TaskState.CLOSE.toString() -> {
                    if (taskHolder.contains(taskMap.get(tittle)!!)) {
                        val authors = taskHolder.get(taskMap.get(tittle)!!)
                        taskHolder.remove(taskMap.get(tittle)!!)
                        taskMap.remove(tittle)
                        addToMap(Task(tittle, TaskState.CLOSE.toString()))
                        assignAuthorToTask(Task(tittle, TaskState.CLOSE.toString()), authors!!)
                    } else {
                        taskMap.remove(tittle)
                        addToMap(Task(tittle, TaskState.CLOSE.toString()))
                    }
                }
                "exit" -> return
                else -> userStatus(status!!, tittle)
            }
            print("Status changed\n")
        } else { print("No task with $tittle\n")}
    }

    fun assignAuthorToTask(task: Task, author: Author) {
        taskHolder.put(task, author)
    }

    private fun printTask(task: Task) {
        print(UP_BORDER)
        print(" Task: ${task.title}\n Status: ${taskMap.get(task.title)?.status}\n Author: ${taskHolder.get(task)?.author}\n")
        print(BOTTOM_BORDER)
    }

    fun showAllTask() {
        for ((key, value) in taskMap)
            printTask(value)
    }

    fun getTask(tittle: String): Task {
        return taskMap.get(tittle)!!
    }

    fun userStatus(status: String, taskTittle: String) {
        if (taskHolder.contains(taskMap.get(taskTittle)!!)) {
            val authors = taskHolder.get(taskMap.get(taskTittle)!!)
            taskHolder.remove(taskMap.get(taskTittle)!!)
            taskMap.remove(taskTittle)
            addToMap(Task(taskTittle, status))
            assignAuthorToTask(Task(taskTittle, status), authors!!)
        } else {
            taskMap.remove(taskTittle)
            addToMap(Task(taskTittle, status))
        }
    }
}