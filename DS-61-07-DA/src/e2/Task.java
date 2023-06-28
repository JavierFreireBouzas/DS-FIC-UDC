package e2;

import java.util.List;

public class Task implements Comparable<Task>{
    public List<Character> parents;
    public Character taskName;
    public List<Character> children;
    public boolean first;
    public boolean copyFirst;
    public boolean used;


    public Task(List<Character> parents, Character taskName, List<Character> children) {
        this.parents = parents;
        this.taskName = taskName;
        this.children = children;
        this.first = parents.isEmpty();
        this.copyFirst = parents.isEmpty();
        this.used = false;
    }

    @Override
    public String toString() {
        return taskName.toString();
    }

    @Override
    public int compareTo(Task o) {
        return Character.compare(this.taskName, o.taskName);
    }
}