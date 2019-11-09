package problems;

class HackerRankSolutions {

    /**
     * Jumping on the Clouds
     * <p>
     * Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud.
     * Jump on any 0 cloud that is 1 or 2 ahead of your current cloud
     * 
     * @param c int array containing 0's and 1's
     * @return the minimum number of jumps required, as an integer.
     */
    int jumpingOnClouds(int[] c) {
        int len = c.length;

        if (len < 3) {
            return 1; // return one when length is less than 3
        }

        int jump = 0;
        for (int i = 0; i < len - 2; ++i, ++jump) {
            if (c[i + 2] == 0) {
                ++i; // when two ahead is 0 jump to it and increment i
            }
            if (i == len - 3) {
                ++jump; // add another jump since we need to move one more space
            }
        }
        return jump;
    }

}
