package e2;

import java.util.ArrayList;
import java.util.List;

public class WeakDependency implements ExecutionOrder{

    @Override
    public void orderTasks(TaskManager tasks) {
        List<Task> rtnList = new ArrayList<>();
        int i, j, k, t;
        t = 0;
        while (t != tasks.sizeTaskList()) {
            for (i = 0; i < tasks.sizeTaskList(); i++) {
                if (!tasks.getValue(i).used && tasks.getValue(i).first) {
                    rtnList.add(tasks.getValue(i));
                    tasks.getValue(i).used = true;
                    for (j = 0; j < tasks.getValue(i).children.size(); j++) {
                        for (k = 0; k < tasks.sizeTaskList(); k++) {
                            if (tasks.getValue(i).children.get(j) == tasks.getValue(k).taskName) {
                                tasks.getValue(k).first = true;
                            }
                        }
                    }
                    break;
                }
            }
            t++;
        }
        tasks.setTaskList(rtnList);
    }
}