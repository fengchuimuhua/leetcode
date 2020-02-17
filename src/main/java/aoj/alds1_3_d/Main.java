package aoj.alds1_3_d;

/**
 * Created by zhangrunfeng on 2/17/20
 */
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;

// Areas on the Cross-Section Diagram
public class Main {

    class Pair {
        public int startPos;
        public int volume;

        public Pair(int startPos, int volume) {
            this.startPos = startPos;
            this.volume = volume;
        }
    }

    private String str;

    public Main (Scanner sc) {
        str = sc.next();
    }

    public void compute() {
        int sum = 0;

        Deque<Integer> st = new LinkedList<>();
        Deque<Pair> pairSt = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\\') {
                st.push(i);
            } else if (str.charAt(i) == '/') {
                if (!st.isEmpty()) {
                    int leftIx = st.pop();
                    int currVol = i - leftIx;

                    sum += currVol;

                    Pair currPair = new Pair(leftIx, currVol);
                    while (!pairSt.isEmpty()) {
                        Pair pair = pairSt.peek();
                        if (currPair.startPos < pair.startPos) {
                            currPair.volume += pair.volume;
                            pairSt.pop();
                        } else {
                            break;
                        }
                    }
                    pairSt.push(currPair);
                }
            }
        }

        List<Integer> resList = new ArrayList<>();
        while (!pairSt.isEmpty()) {
            resList.add(pairSt.pop().volume);
        }
        Collections.reverse(resList);

        // Print Results
        System.out.println(sum);
        System.out.print(resList.size());
        for (int val : resList) {
            System.out.print(" " + val);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
        m.compute();
    }
}
