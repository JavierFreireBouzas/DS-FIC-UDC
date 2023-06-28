package e2;

import java.util.*;

public class TaskManager {

    private List<Task> taskList;
    private ExecutionOrder order;

    public TaskManager(List<Task> taskList) {
        Collections.sort(taskList);
        this.taskList = taskList;
    }

    private void resetUsed(){
        for (Task task : taskList) {
            task.used = false;
            task.first = task.copyFirst;
        }
    }

    public void executeOrder(){
       Collections.sort(taskList);
       order.orderTasks(this);
       resetUsed();
    }

    public int sizeTaskList(){
       return taskList.size();
    }

    public Task getValue(int pos) {
       return taskList.get(pos);
   }

    public List<Task> getTaskList() {
        return taskList;
    }

    @Override
    public String toString(){
        StringBuilder rtn = new StringBuilder();
        int i;
        for(i = 0; i < taskList.size() -1 ; i++){
            rtn.append(taskList.get(i).taskName).append(" - ");
        }
        rtn.append(taskList.get(i).taskName);
        return rtn.toString();
    }

    public void setOrder(ExecutionOrder order) {
        this.order = order;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
