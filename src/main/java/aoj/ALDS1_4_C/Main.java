package aoj.ALDS1_4_C;

import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2/17/20
 */
public class Main {

    private final int M = 1046527;
    private int N;
    private Scanner sc;

    private String[] hashTable = new String[M];

    private int getCharInt(char c) {
        if (c == 'A') {
            return 1;
        } else if (c == 'C') {
            return 2;
        } else if (c == 'G') {
            return 3;
        } else if (c == 'T') {
            return 4;
        } else {
            return 0;
        }
    }

    private long getKey(String str) {
        long sum = 0, p = 1;
        for (int i = 0; i < str.length(); i++) {
            sum += p * getCharInt(str.charAt(i));
            p *= 5;
        }
        return sum;
    }

    private int h1(long key) {
        return (int) key % M;
    }

    private int h2(long key) {
        return (int)(1 + (key % (M - 1)));
    }

    public Main(Scanner sc) {
        this.sc = sc;
    }

    private boolean insert(String str) {
        long key = getKey(str);
        for (int i = 0; i < M; i++) {
            int h = (h1(key) + i * h2(key)) % M;
            if (hashTable[h] == null) {
                hashTable[h] = str;
                return true;
            } else if (hashTable[h] != null && hashTable[h].equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean find(String str) {
        long key = getKey(str);
        for (int i = 0; i < M; i++) {
            int h = (h1(key) + i * h2(key)) % M;
            if (hashTable[h] == null) {
                return false;
            } else if (hashTable[h] != null && hashTable[h].equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void hashTableProcess() {
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String order = sc.next();
            String str = sc.next();
            if (order.equals("insert")) {
                insert(str);
            } else if (order.equals("find")) {
                boolean res = find(str);
                if (res) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
        m.hashTableProcess();
    }
}
