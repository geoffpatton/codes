package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NextPalindrome implements Runnable {

    public void solve() throws IOException {
        StringBuffer sb = new StringBuffer("");
        int testCases = nextInt();
        for (int test = 0; test < testCases; test++) {
            StringBuffer outputString = getNext(nextToken());
            sb.append(outputString);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public StringBuffer getNext(String n) {
        char[] arr = n.toCharArray();
        int size = arr.length;
        boolean allNine = true;
        for (int i = 0; i < size; i++) {
            if (n.charAt(i) != '9') {
                allNine = false;
            }
        }
        if (allNine) {
            StringBuffer res = new StringBuffer("1");
            for (int i = 1; i < size; i++) {
                res.append("0");
            }
            res.append("1");
            return res;
        }
        // copy
        for (int i = size / 2; i < size; i++) {
            arr[i] = arr[size - i - 1];
        }
        // for (int i = 0; i < size; i++) {
        // System.err.print(arr[i]);
        // }
        // System.out.println();

        if (compare(arr, n.toCharArray()) == 1) {
            // System.out.println("check1");
            return toStringBuffer(arr);
        } else {
            // System.out.println("check2");
            int left, right;
            if (size % 2 == 0) {
                left = (size - 1) / 2;
                right = (size) / 2;
            } else {
                left = size / 2;
                right = size / 2;
            }
            // System.out.println(n + " " + left + " " + right);
            while (left >= 0) {

                if (arr[left] >= '0' && arr[left] <= '8') {
                    arr[left] = (char) (arr[left] + 1);
                    arr[right] = arr[left];
                    break;
                } else {
                    arr[left] = '0';
                    arr[right] = '0';
                }
                left--;
                right++;
            }
        }

        return toStringBuffer(arr);
    }

    StringBuffer toStringBuffer(char[] a) {
        StringBuffer ret = new StringBuffer("");
        for (int i = 0; i < a.length; i++) {
            ret.append(a[i]);
        }
        return ret;
    }

    int compare(char[] a, char[] b) {
        if (a.length > b.length) {
            return 1;
        }
        if (a.length < b.length) {
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) {
                return -1;
            }
            if (a[i] > b[i]) {
                return 1;
            }
        }
        return 0;
    }

    void print(Object... obj) {
        for (Object o : obj) {
            System.out.println(o);
        }
    }

    void print(int[] a) {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    void print(int[][] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    void print(boolean[][] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // -----------------------------------------------------------
    public static void main(String[] args) {
        new NextPalindrome().run();
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            tok = null;
            solve();
            in.close();
        } catch (IOException e) {
            System.exit(0);
        }
    }

    public String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    BufferedReader in;
    StringTokenizer tok;
}