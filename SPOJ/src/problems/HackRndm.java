package problems;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Spoj - HACKRNDM - Hacking the random number generator
 * 
 * @author Geoff Jul 6, 2018
 */
class HackRndm {
    public static void main(String[] args) throws Exception {
        // had to use parser for faster input
        Parser in = new Parser(System.in);

        // get n and k values from first line
        int n = in.nextInt();
        int k = in.nextInt();
        int pairCount = 0;

        int[] numbersArray = new int[n];

        // populate numbers array from 2nd line
        for (int i = 0; i < n; i++) {
            numbersArray[i] = in.nextInt();
        }

        // sort array, must be sorted for binarySearch
        Arrays.sort(numbersArray);

        // iterate over the array
        for (int y = 0; y < n; ++y) {
            // uses binary search to find if a entry exists equal to the value + k
            if (Arrays.binarySearch(numbersArray, numbersArray[y] + k) >= 0) {
                ++pairCount;
            }
        }
        // print the pair count
        System.out.print(pairCount);
    }
}

/**
 * Parser for fast input
 */
class Parser {
    final private int BUFFER_SIZE = 1 << 16;

    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Parser(InputStream in) {
        din = new DataInputStream(in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public long nextLong() throws Exception {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = c == '-';
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
            c = read();
        } while (c > ' ');
        if (neg)
            return -ret;
        return ret;
    }

    // reads in the next string
    public String next() throws Exception {
        StringBuilder ret = new StringBuilder();
        byte c = read();
        while (c <= ' ')
            c = read();
        do {
            ret = ret.append((char) c);
            c = read();
        } while (c > ' ');
        return ret.toString();
    }

    public int nextInt() throws Exception {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = c == '-';
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
            c = read();
        } while (c > ' ');
        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws Exception {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws Exception {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }
}