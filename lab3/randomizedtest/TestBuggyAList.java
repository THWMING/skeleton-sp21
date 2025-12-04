package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */

public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> Trusted = new AListNoResizing<>();
        BuggyAList<Integer> Buggy = new BuggyAList<>();

        Trusted.addLast(4);
        Trusted.addLast(5);
        Trusted.addLast(6);
        Buggy.addLast(4);
        Buggy.addLast(5);
        Buggy.addLast(6);

        assertEquals(Trusted.size(), Buggy.size());

        assertEquals(Trusted.removeLast(), Buggy.removeLast());
        assertEquals(Trusted.removeLast(), Buggy.removeLast());
        assertEquals(Trusted.removeLast(), Buggy.removeLast());
    }

    @Test
    public void randomizedTest(){


        AListNoResizing<Integer> L1 = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L1.addLast(randVal);
                L2.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L1.size();
                System.out.println("size: " + size);
                assertEquals(L1.size(), L2.size());
            } else if (operationNumber == 2) {
                if (L1.size() == 0){
                    continue;
                }
                int x = L1.getLast();
                int y = L2.getLast();
                System.out.println("L1getLast(" + x + ")");
                System.out.println("L2getLast(" + y + ")");
                assertEquals(x, y);
            } else if (operationNumber == 3) {
                if (L1.size() == 0){
                    continue;
                }
                int x = L1.removeLast();
                int y = L2.removeLast();
                System.out.println("L1removeLast(" + x + ")");
                System.out.println("L2removeLast(" + y + ")");
                assertEquals(x, y);
            }
        }
    }
}
