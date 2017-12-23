package problems;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * HOTELS - Hotels Along the Croatian Coast Needs Parser Class to not get TLE
 * Created by geoffpatton on 6/30/2015.
 */
class Hotels
{
    public static void main(String[] args) throws IOException
    {
        new Hotels().run();
    }

    public void run() throws IOException
    {
        Parser in = new Parser(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        // get number of Hotels and Max Value
        int numberOfHotels = in.nextInt();
        int maxValue = in.nextInt();

        // populate hotel values in array
        int[] hotelArray = new int[numberOfHotels];
        for (int i = 0; i < numberOfHotels; i++)
        {
            hotelArray[i] = in.nextInt();
        }

        int currentMax = 0, bestMax = 0, start = 0, end = 0;

        while (start < numberOfHotels && end < numberOfHotels)
        {
            if (hotelArray[end] > maxValue)
            {
                start = end + 1;
                end++;
                break;
            }
            currentMax += hotelArray[end];
            while (currentMax > maxValue && start < numberOfHotels)
            {
                currentMax -= hotelArray[start];
                start++;
            }
            if (currentMax > bestMax && currentMax <= maxValue)
            {
                bestMax = currentMax;
                if (bestMax == maxValue)
                {
                    break;
                }
            }
            end++;
        }
        out.print(bestMax);
        out.flush();
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
