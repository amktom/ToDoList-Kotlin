data class Task(val title: String, var status: TaskState = TaskState.OPEN) {

    fun changeStatus(status: TaskState) {
        this.status = status
    }
}