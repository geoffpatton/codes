package problems;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * SPOJ - LCMSUM - LCM Sum --TLE Need to refactor
 * 
 * Given n, calculate the sum LCM(1,n) + LCM(2,n) + .. + LCM(n,n), where
 * LCM(i,n) denotes the Least Common Multiple of the integers i and n.
 * 
 * @author Geoff Jan 6, 2018
 *
 */
class LCMSum
{
    public static void main(String[] args) throws NumberFormatException, IOException
    {
        new LCMSum().solve();
    }

    void solve() throws NumberFormatException, IOException
    {
        Parser in = new Parser(System.in);
        PrintWriter out = new PrintWriter(System.out, true);
        int testCases = in.nextInt();

        while (testCases-- > 0)
        {
            int n = in.nextInt();
            int answer = 0;
            // loop through values from 1 to n. adding up each result
            for (int i = 1; i <= n; i++)
            {
                answer += lcm(i, n);
            }

            // print result
            out.println(answer);
        }
    }

    /**
     * get the LCM of two numbers
     * 
     * @param a
     * @param b
     * @return
     */
    int lcm(int a, int b)
    {
        return (a * b) / gcd(a, b);
    }

    /**
     * recursive method to get the gcd of two values
     * 
     * @param a
     * @param b
     * @return
     */
    int gcd(int a, int b)
    {
        int retval = 0;
        // Everything divides 0
        if (a == 0 || b == 0)
        {
            retval = 0;
        }
        // base case
        else if (a == b)
        {
            retval = a;
        }
        // a is greater
        else if (a > b)
        {
            retval = gcd(a - b, b);
        }
        else
        {
            retval = gcd(a, b - a);
        }
        return retval;
    }

    /**
     * fast parser taking in an InputStream, with self-maintained buffer
     */
    static class Parser
    {
        final private int BUFFER_SIZE = 65536; // 2^16, a good compromise for some problems
        private InputStream din; // Underlying input stream
        private byte[] buffer; // Self-maintained buffer
        private int bufferPointer; // Current read position in the buffer
        private int bytesRead; // Effective bytes in the buffer read from the input stream

        public Parser(InputStream in)
        {
            din = in;
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        /**
         * Read the next integer from the input stream.
         * 
         * @return The next integer.
         * @throws java.io.IOException
         */
        public int nextInt() throws IOException
        {
            int result = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            while (c >= '0' && c <= '9')
            {
                result = result * 10 + c - '0';
                c = read();
            }
            if (neg)
                return -result;
            return result;
        }

        /**
         * Read a line of data from the input stream.
         * 
         * @return the next line of data.
         * @throws IOException
         *             if an I/O error occurs.
         */
        public String readLine() throws IOException
        {
            StringBuilder line = new StringBuilder();
            char c;
            while ((c = (char) (read())) != '\n')
            {
                line.append(c);
            }
            return line.toString();
        }

        /**
         * Read the next byte of data from the input stream.
         * 
         * @return the next byte of data, or -1 if the end of the stream is reached.
         * @throws IOException
         *             if an I/O error occurs.
         */
        public byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        /**
         * Read data from the input stream into the buffer
         * 
         * @throws IOException
         *             if an I/O error occurs.
         */
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
    }
}