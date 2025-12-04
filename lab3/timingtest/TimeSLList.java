package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Nums = new AList<>();
        Nums.addLast(1000);
        Nums.addLast(2000);
        Nums.addLast(4000);
        Nums.addLast(8000);
        Nums.addLast(16000);
        Nums.addLast(32000);
        Nums.addLast(64000);
        Nums.addLast(128000);
        SLList<Integer> Ns = new SLList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        for (int i = 0; i < Nums.size(); i += 1) {
            opCounts.addLast(10000);
        }
        for (int i = 0; i < Nums.size(); i += 1) {
            for (int j = 0; j < Nums.get(i); j += 1) {
                Ns.addLast(1);
            }
            Stopwatch sw = new Stopwatch();
            for (int k = 0; k < opCounts.get(i); k += 1) {
                Ns.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        printTimingTable(Nums, times, opCounts);
    }

}
