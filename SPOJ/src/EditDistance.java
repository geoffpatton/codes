import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by geoffpatton on 6/26/2015.
 * EDIST - Edit distance
 */
public class EditDistance {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        new EditDistance().run();
    }

    void run() throws IOException{

        int numCases = Integer.parseInt(in.readLine());

        for (int i = 0; i < numCases; i++) {
            editDistance();
        }

    }

    void editDistance() throws IOException{
        String s1 = in.readLine();
        String s2 = in.readLine();

        int len1 = s1.length();
        int len2 = s2.length();


        List<Integer> operations = new ArrayList<>();
        operations.add(0);

        for(int x = 1; x<=len2;x++) {
            operations.add(x);
        }

        for(int z = 1; z<=len1;z++) {
            operations.set(0, z);
            int temp1 = z - 1;
            int temp2;

            for (int y = 1; y <= len2; y++) {

                int deleteOperation = operations.get(y) + 1;
                int InsertOperation = operations.get(y - 1) + 1;
                int ReplaceOperation;
                if (s1.charAt(z - 1) == s2.charAt(y - 1)) {
                    ReplaceOperation = temp1;
                } else {
                    ReplaceOperation = temp1 + 1;
                }
                temp2 = operations.get(y);
                operations.set(y, getMin(deleteOperation, InsertOperation, ReplaceOperation));
                temp1 = temp2;

            }
        }
        System.out.println(operations.get(len2));
    }

    int getMin(int del, int insert, int replace){
        if(del <= insert){
            if(del <= replace){
                return del;
            }
            return  replace;
        }else{
            if (insert <= replace){
                return insert;
            }
            return replace;
        }

    }
}
