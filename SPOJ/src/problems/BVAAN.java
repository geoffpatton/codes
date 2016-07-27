package problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by geoffpatton on 7/28/2015.
 * This one doesn't work
 */
public class BVAAN {
    public static void main(String[] args) throws IOException{
        new BVAAN().run();
    }
    public void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(br.readLine());

        int testCases = Integer.parseInt(in.nextToken());

        for(int i=0;i<testCases;i++) {

            in = new StringTokenizer(br.readLine());

            String s1 = in.nextToken();
            in = new StringTokenizer(br.readLine());
            String s2 = in.nextToken();
            in = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(in.nextToken());
            int loopLen = s1.length() - len+1;
            int sum = 0;
            int charLocation = 0;

            for(int y=0; y<loopLen; y++){
                int loopSum =0;
                for(int l=y; l<len+y;l++){
                    loopSum += s1.charAt(l);
                    //System.out.println(l);
                }
                //s1.charAt(y) + s1.charAt(y+1) + s1.charAt(y+2);
                if(y==0){
                    sum =loopSum;
                }else if(loopSum>sum){
                    sum=loopSum;
                    charLocation = y;
                }
            }

            CharSequence sumSeq = s1.subSequence(charLocation,charLocation+len);
            //System.out.println(sumSeq);
            String sub1 = sumSeq.toString();

            sub1 = sub1.replace("", ".*");
            if(s2.matches(sub1)){
                System.out.println(sum);
            }else{
                System.out.println(0);
            }
        }
    }
}
