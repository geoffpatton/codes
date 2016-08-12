package problems;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * SPOJ - BUGLIFE - A Bug’s Life
 * 
 * @author geoffpatton
 * 
 *         Input
 * 
 *         The first line of the input contains the number of scenarios. Each
 *         scenario starts with one line giving the number of bugs (at least
 *         one, and up to 2000) and the number of interactions (up to 1000000)
 *         separated by a single space. In the following lines, each interaction
 *         is given in the form of two distinct bug numbers separated by a
 *         single space. Bugs are numbered consecutively starting from one.
 * 
 *         Output
 * 
 *         The output for every scenario is a line containing “Scenario #i:”,
 *         where i is the number of the scenario starting at 1, followed by one
 *         line saying either “No suspicious bugs found!” if the experiment is
 *         consistent with his assumption about the bugs’ sexual behavior, or
 *         “Suspicious bugs found!” if Professor Hopper’s assumption is
 *         definitely wrong.
 * 
 */

public class BUGLIFE {
	
	Parser parserIn = new Parser(System.in);
	PrintWriter writer = new PrintWriter(System.out);
	private static final String SCENARIO_NUMBER = "Scenario #%d:\n";
	private static final String SUSPICIOUS = "Suspicious bugs found!";
	private static final String NO_SUSPICIOUS = "No suspicious bugs found!";

	public static void main(String[] args) throws IOException {
		new BUGLIFE().run();
	}

	void run() throws IOException {
		int testcases = parserIn.nextInt();
		for (int i = 1; i <= testcases; i++)
			solve(i);
		writer.flush();
	}

	private static int alphaBugs, betaBugs;
	private static boolean[][] graph = new boolean[2001][2001];
	private static byte[] sexType = new byte[2001];

	/**
	 * solves problem
	 * @param testcase
	 * @throws IOException
	 */
	void solve(int testcase) throws IOException {
		constructGraph();
		writer.printf(SCENARIO_NUMBER, testcase);

		// true if no same sex interaction is found
		boolean status = true; 
		
		//loop when status status = true
		for (int i = 1; status && i <= alphaBugs; i++) {
			if (sexType[i] == 0) {
				sexType[i] = 1;
				status = dfs(i);
			}
		}

		if (status)
			writer.println(NO_SUSPICIOUS);
		else
			writer.println(SUSPICIOUS);
	}

	/**
	 * build a graph based on input
	 * @throws IOException
	 */
	void constructGraph() throws IOException {
		alphaBugs = parserIn.nextInt();
		betaBugs = parserIn.nextInt();

		// Initialize graph[][] and sex[]
		for (int i = 1; i <= alphaBugs; i++)
			Arrays.fill(graph[i], 1, alphaBugs + 1, false);
		Arrays.fill(sexType, 1, alphaBugs + 1, (byte) 0);

		// Read edges
		int u, v;
		for (int j = 0; j < betaBugs; j++) {
			u = parserIn.nextInt();
			v = parserIn.nextInt();
			graph[u][v] = graph[v][u] = true;
		}
	}
 

	/**
	 * DFS traversal that returns whether a cycle of odd length
	 * @param u
	 * @return
	 */
	boolean dfs(int u) {
		for (int v = 1; v <= alphaBugs; v++) {
			
			//continue if not adjacent vertices
			if (!graph[u][v]) 
				continue;
			
			// new vertex
			if (sexType[v] == 0) {
				
				// Assigned the opposite sex as u's
				sexType[v] = (byte) -sexType[u]; 
				
				// return false when same sex interaction
				if (!dfs(v)) 
					return false;
			} else if (sexType[v] + sexType[u] != 0) { 
				return false;
			}
		}
		return true;
	}

	/**
	 *  Parser that takes in an InputStream
	 */
	static class Parser {
		/**
		 * Size of buffer
		 */
		private final int BUFFER_SIZE = 65536; // 2^16
		/**
		 *   input stream
		 */
		private InputStream stream; 
		/**
		 *    Byte buffer
		 */
		private byte[] byteBuffer;
		/**
		 * Current read position in the buffer
		 */
		private int bufPosition;
		/**
		 * Effective bytes in the buffer read from the
		 */
		private int numOfBytesRead; 
						

		public Parser(InputStream in) {
			stream = in;
			byteBuffer = new byte[BUFFER_SIZE];
			bufPosition = numOfBytesRead = 0;
		}

		/**
		 * Read the next integer from the input stream.
		 */
		public int nextInt() throws IOException {
			int result = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			while (c >= '0' && c <= '9') {
				result = result * 10 + c - '0';
				c = read();
			}
			if (neg)
				return -result;
			return result;
		}

		/**
		 * Read a line of data from the input stream.
		 */
		public String readLine() throws IOException {
			StringBuilder line = new StringBuilder();
			char c;
			while ((c = (char) (read())) != '\n') {
				line.append(c);
			}
			return line.toString();
		}

		/**
		 *  reads the the next byte 
		 */
		public byte read() throws IOException {
			if (bufPosition == numOfBytesRead)
				fillBuffer();
			return byteBuffer[bufPosition++];
		}

		/**
		 * fills buffer with data from the input stream
		 */
		private void fillBuffer() throws IOException {
			numOfBytesRead = stream.read(byteBuffer, bufPosition = 0, BUFFER_SIZE);
			if (numOfBytesRead == -1)
				byteBuffer[0] = -1;
		}
	}
}