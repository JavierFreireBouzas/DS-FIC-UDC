package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    List<Character> emptyList = new ArrayList<>();
    //Test1 (PDF)
    List<Character> childC = new ArrayList<>();
    List<Character> parentA = new ArrayList<>();
    List<Character> childA = new ArrayList<>();
    List<Character> parentD = new ArrayList<>();
    List<Character> childD = new ArrayList<>();
    List<Character> parentE = new ArrayList<>();
    List<Character> childG = new ArrayList<>();
    List<Character> parentH = new ArrayList<>();
    List<Character> childH = new ArrayList<>();
    List<Character> parentJ = new ArrayList<>();
    List<Character> parentB = new ArrayList<>();
    List<Character> childB = new ArrayList<>();
    List<Character> parentF = new ArrayList<>();
    List<Character> childF = new ArrayList<>();

    Task c;
    Task a;
    Task b;
    Task d;
    Task e;
    Task f;
    Task g;
    Task h;
    Task j;


    //Test2
    List<Character> childT = new ArrayList<>();
    List<Character> childW = new ArrayList<>();
    List<Character> childY = new ArrayList<>();
    List<Character> parentV = new ArrayList<>();
    List<Character> childV = new ArrayList<>();
    List<Character> parentN = new ArrayList<>();
    List<Character> childN = new ArrayList<>();
    List<Character> parentQ = new ArrayList<>();
    List<Character> childQ = new ArrayList<>();
    List<Character> parentM = new ArrayList<>();
    List<Character> childM = new ArrayList<>();
    List<Character> parentS = new ArrayList<>();
    List<Character> childS = new ArrayList<>();
    List<Character> parentU = new ArrayList<>();
    List<Character> parentZ = new ArrayList<>();
    List<Character> childZ = new ArrayList<>();
    List<Character> parentR = new ArrayList<>();

    Task v;
    Task z;
    Task q;
    Task m;
    Task t;
    Task w;
    Task r;
    Task y;
    Task u;
    Task s;
    Task n;

    @Test
    void Test1(){
        List<Task> tasks = new ArrayList<>();
        childC.add('A');
        childC.add('F');
        c = new Task(emptyList, 'C', childC);

        parentA.add('C');
        childA.add('B');
        childA.add('D');
        a  = new Task(parentA, 'A', childA);

        parentB.add('A');
        childB.add('E');
        b = new Task(parentB,'B', childB);

        parentD.add('A');
        childD.add('E');
        d = new Task(parentD, 'D',childD);

        parentE.add('B');
        parentE.add('D');
        parentE.add('F');
        e = new Task(parentE,'E', emptyList);

        parentF.add('C');
        parentF.add('G');
        childF.add('E');
        childF.add('J');
        f = new Task(parentF,'F', childF);

        childG.add('F');
        childG.add('H');
        g = new Task(emptyList,'G', childG);

        parentH.add('G');
        childH.add('J');
        h = new Task(parentH,'H', childH);

        parentJ.add('F');
        parentJ.add('H');
        j = new Task(parentJ,'J', emptyList);

        tasks.add(a);
        tasks.add(b);
        tasks.add(c);
        tasks.add(d);
        tasks.add(e);
        tasks.add(f);
        tasks.add(g);
        tasks.add(h);
        tasks.add(j);
        TaskManager graph = new TaskManager(tasks);

        graph.setOrder(new StrongDependency());
        graph.executeOrder();
        assertEquals("C - A - B - D - G - F - E - H - J", graph.toString());

        graph.setOrder(new WeakDependency());
        graph.executeOrder();
        assertEquals("C - A - B - D - E - F - G - H - J", graph.toString());

        graph.setOrder(new HierarchicalOrder());
        graph.executeOrder();
        assertEquals("C - G - A - F - H - B - D - E - J", graph.toString());
    }

    @Test
    void Test2(){
        List<Task> tasks = new ArrayList<>();
        parentU.add('V');
        parentU.add('N');
        parentU.add('Q');
        u = new Task(parentU, 'U', emptyList);

        parentM.add('Y');
        childM.add('Z');
        m  = new Task(parentM, 'M', childM);

        childW.add('N');
        w = new Task(emptyList,'W', childW);

        parentZ.add('Q');
        parentZ.add('M');
        childZ.add('R');
        z = new Task(parentZ, 'Z',childZ);

        parentR.add('S');
        parentR.add('Z');
        r = new Task(parentR,'R', emptyList);

        parentQ.add('Y');
        childQ.add('Z');
        childQ.add('U');
        q = new Task(parentQ,'Q', childQ);

        childY.add('Q');
        childY.add('M');
        y = new Task(emptyList,'Y', childY);

        childT.add('V');
        childT.add('N');
        t = new Task(emptyList,'T', childT);

        parentV.add('T');
        childV.add('S');
        childV.add('U');
        v = new Task(parentV,'V', childV);

        parentS.add('V');
        childS.add('R');
        s = new Task(parentS,'S', childS);

        parentN.add('T');
        parentN.add('W');
        childN.add('U');
        n = new Task(parentN,'N', childN);

        tasks.add(u);
        tasks.add(m);
        tasks.add(w);
        tasks.add(z);
        tasks.add(r);
        tasks.add(q);
        tasks.add(y);
        tasks.add(t);
        tasks.add(v);
        tasks.add(s);
        tasks.add(n);
        TaskManager graph = new TaskManager(tasks);

        graph.setOrder(new StrongDependency());
        graph.executeOrder();
        assertEquals("T - V - S - W - N - Y - M - Q - U - Z - R", graph.toString());

        graph.setOrder(new WeakDependency());
        graph.executeOrder();
        assertEquals("T - N - U - V - S - R - W - Y - M - Q - Z", graph.toString());

        graph.setOrder(new HierarchicalOrder());
        graph.executeOrder();
        assertEquals("T - W - Y - M - N - Q - V - S - U - Z - R", graph.toString());
    }



}