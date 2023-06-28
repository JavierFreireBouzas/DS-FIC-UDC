package e2;

import java.util.ArrayList;
import java.util.List;

public class HierarchicalOrder implements ExecutionOrder{

    private void enableNextLevel(List<Character> nextLevel, List<Task> tasks){
        int i, j;
        for(i = 0; i < nextLevel.size(); i++){
            for(j = 0; j < tasks.size(); j++){
                if(nextLevel.get(i) == tasks.get(j).taskName)
                    tasks.get(j).first = true;
            }
        }
    }

    @Override
    public void orderTasks(TaskManager tasks) {
        List<Task> rtnList = new ArrayList<>();
        List<Character> nextLevel = new ArrayList<>();
        int i, j, t;
        t = 0;
        while (t != tasks.sizeTaskList()) {
            for (i = 0; i < tasks.sizeTaskList(); i++) {
                if (!tasks.getValue(i).used && tasks.getValue(i).first) {
                    rtnList.add(tasks.getValue(i));
                    tasks.getValue(i).used = true;
                    for (j = 0; j < tasks.getValue(i).children.size(); j++) {
                        nextLevel.add(tasks.getValue(i).children.get(j));
                    }
                }

            }
            enableNextLevel(nextLevel, tasks.getTaskList());
            nextLevel.clear();
            t++;
        }
        tasks.setTaskList(rtnList);
    }
}
