package problems;
import java.io.IOException;
import java.util.*;

/**
 * Created by geoffpatton on 6/26/2015.
 * AGGRCOW - Aggressive cows
 */
class AggressiveCows {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        new AggressiveCows().run();
    }

    void run() throws IOException {

        int numCases = in.nextInt();

        for (int i = 0; i < numCases; i++) {
            findMinimum();
        }
    }

    void findMinimum(){

        int numStalls = in.nextInt();
        int numCows = in.nextInt();
        List<Integer> openStalls = new ArrayList<>();

        for (int i =0;i<numStalls;i++){
            openStalls.add(in.nextInt());
        }
        Collections.sort(openStalls);

        System.out.println(binarySearch(numCows, openStalls));

    }

    int binarySearch(int numCows, List<Integer> stalls){
        int left = 0;
        int right = stalls.get(stalls.size()-1) - stalls.get(0);

        while(left<=right) {
            int middle = (left + right) / 2;
            if (minDistanceCheck(middle, numCows, stalls)) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return right;
    }

    boolean minDistanceCheck(int distance, int numCows, List<Integer> stalls){
        int cowInStalls = 1;
        int lastStall = stalls.get(0);
        for(int i=1;i<stalls.size(); i++){
            if(stalls.get(i) - lastStall < distance){
                continue;
            }
            if(++cowInStalls == numCows){
                return true;
            }
            lastStall = stalls.get(i);
        }
        return false;

    }
}
