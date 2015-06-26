import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
/**
 * Created by geoffpatton on 6/26/2015.
 * GSS1 - Can you answer these queries I
 */
public class Queries {
    Parser in = new Parser(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new Queries().run();
    }
    private int sequenceAmount;
    private int[] sequenceArray;
    private int[] sumOfSequence;
    private int[] max;
    private int[] maxPrefix;
    private int[] maxSuffix;
    void run() throws IOException {
        sequenceAmount = in.nextInt();
        sequenceArray = new int[sequenceAmount+1];
        sumOfSequence = new int[sequenceAmount+1];
        for(int i = 1; i<=sequenceAmount; i++){
            sequenceArray[i]=in.nextInt();
            sumOfSequence[i] = sumOfSequence[i-1] + sequenceArray[i];
        }
        maxPrefix = new int[sequenceAmount<<2];
        maxSuffix = new int[sequenceAmount<<2];
        max = new int[sequenceAmount<<2];
        segmentTree(1, sequenceAmount, 1);
        int queries = in.nextInt();
        while (queries-- > 0) {
            out.println(findMaxConsecutive(in.nextInt(), in.nextInt(), 1, sequenceAmount, 1, new int[3]));
        }
        out.flush();
    }

    void segmentTree(int rangeLeft, int rangeRight, int index) {
        if (rangeLeft == rangeRight) {
            maxPrefix[index] = maxSuffix[index] = max[index] = sequenceArray[rangeLeft];
            return;
        }
        int middle = (rangeLeft+rangeRight) >> 1;
        int leftChild = index<<1, rightChild = leftChild+1;
        // Recursively build the segment tree
        segmentTree(rangeLeft, middle, leftChild);
        segmentTree(middle + 1, rangeRight, rightChild);
        // Update max, maxPrefix, and maxSuffix
        max[index] = (max[leftChild] > max[rightChild]) ? max[leftChild] : max[rightChild];
        max[index] = (max[index] > maxSuffix[leftChild]+maxPrefix[rightChild]) ? max[index] :
                maxSuffix[leftChild]+maxPrefix[rightChild];

        maxPrefix[index] = (maxPrefix[leftChild] > sumOfSequence[middle]-sumOfSequence[rangeLeft-1]+maxPrefix[rightChild])
                ? maxPrefix[leftChild] : sumOfSequence[middle]-sumOfSequence[rangeLeft-1]+maxPrefix[rightChild];

        maxSuffix[index] = (maxSuffix[rightChild] > maxSuffix[leftChild]+sumOfSequence[rangeRight]-sumOfSequence[middle])
                ? maxSuffix[rightChild] : maxSuffix[leftChild]+sumOfSequence[rangeRight]-sumOfSequence[middle];
    }

    int findMaxConsecutive(int queryLeft, int queryRight, int rangeLeft, int rangeRight, int index,
              int[] info) {
        // The current interval is within the queried interval
        if (queryLeft <= rangeLeft && queryRight >= rangeRight) {
            info[0] = maxPrefix[index];
            info[1] = maxSuffix[index];
            info[2] = sumOfSequence[rangeRight] - sumOfSequence[rangeLeft-1];
            return max[index];
        }

        int middle = (rangeLeft+rangeRight) >> 1;
        int leftChild = index << 1, rightChild = leftChild+1;
        if (queryRight <= middle)
            return findMaxConsecutive(queryLeft, queryRight, rangeLeft, middle, leftChild, info);
        if (queryLeft > middle)
            return findMaxConsecutive(queryLeft, queryRight, middle + 1, rangeRight, rightChild, info);

        int[] infoLeft = new int[3], infoRight = new int[3];
        int maxLeft = findMaxConsecutive(queryLeft, queryRight, rangeLeft, middle, leftChild, infoLeft);
        int maxRight = findMaxConsecutive(queryLeft, queryRight, middle+1, rangeRight, rightChild, infoRight);

        // Below is similar to what we did when building the tree
        int max = (maxLeft > maxRight) ? maxLeft : maxRight;
        max = (max > infoLeft[1]+infoRight[0]) ? max : infoLeft[1]+infoRight[0];
        info[0] = (infoLeft[0] > infoLeft[2]+infoRight[0]) ? infoLeft[0] : infoLeft[2]+infoRight[0];
        info[1] = (infoRight[1] > infoRight[2]+infoLeft[1]) ? infoRight[1] : infoRight[2]+infoLeft[1];
        info[2] = infoLeft[2] + infoRight[2];
        return max;
    }

    static class Parser {
        final private int BUFFER_SIZE = 65536;
        private InputStream din;
        private byte[] buffer;
        private int bufferPointer;
        private int bytesRead;

        public Parser(InputStream in) {
            din = in;
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            while (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
                c = read();
            }
            if (neg) return -result;
            return result;
        }

        public byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
    }
}
