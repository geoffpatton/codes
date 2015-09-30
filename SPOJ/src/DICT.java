import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by geoffpatton on 9/30/2015.
 */
public class DICT {
    public static void main(String[] args) {
        new DICT().run();
    }
    private void run() {
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        int caseNumber = 1;

        while(caseNumber<=2){

            int wordCount = in.nextInt();

            String[] words = new String[wordCount];

            for(int i = 0; i<wordCount; i++){
                words[i] = in.next();
            }
            List<String> output = new ArrayList<>();

            String prefix = words[0];
            int len =prefix.length();

            for(int j = 1; j<wordCount; j++){
                if(len>words[j].length()){
                    continue;
                }

                if((!prefix.equals(words[j])) && prefix.equals(words[j].substring(0, len))){
                    output.add(words[j]);
                }
            }

            System.out.println("Case #" + caseNumber + ":");

            if(output.isEmpty()){
                System.out.println("No match.");
            }else{
                for(String s : output){
                    System.out.println(s);
                }
            }

            caseNumber++;
        }
    }
}
