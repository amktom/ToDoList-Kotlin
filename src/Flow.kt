class Flow(val task: Task? = null) {

    private val taskMap: MutableMap<String, Task> = HashMap()

    fun addToMap(task: Task) {
       taskMap.put(task.title, task)
        print("Task success created\n")
    }

    fun findTask(tittle: String) {
        if (taskMap.containsKey(tittle)) {
            printTask(taskMap.get(tittle)!!)
            print("Change status ${TaskState.IN_PROGRESS}/ ${TaskState.CLOSE}?\n")
            val status = readLine()
            when (status) {
                TaskState.IN_PROGRESS.toString() -> taskMap.get(tittle)?.status = TaskState.IN_PROGRESS
                TaskState.CLOSE.toString() -> taskMap.get(tittle)?.status = TaskState.CLOSE
                "No" -> return
            }
            print("Status changed\n")
        } else { print("No task with $tittle\n")}
    }

    fun printTask(task: Task) {
        print("*************************************\n")
        print("Task: ${task.title}\n Status: ${taskMap.get(task.title)?.status}\n")
        print("*************************************\n")
    }

    fun showAllTask() {
        for ((key, value) in taskMap)
            printTask(value)
    }
}