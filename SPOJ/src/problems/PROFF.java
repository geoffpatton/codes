package problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by geoffpatton on 9/16/2015.
 */
public class PROFF {
    public static void main(String[] args) throws IOException{
        new PROFF().run();
    }
    private void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in;

        StringBuilder sb = new StringBuilder();


        while(true){

            in = new StringTokenizer(br.readLine());
            String firstString = in.nextToken();
            String secondString = in.nextToken();

            if(firstString.equals("0") && secondString.equals("0")){
                break;
            }
           // int firstNum = Integer.parseInt(firstString);
          //  int secondNum = Integer.parseInt(secondString);

            int len1 = firstString.length();
            int len2 = secondString.length();

            int len = 0;

            if(len != len2){
                if(len1>=len2){
                    len = len1;
                }else{
                    len = len2;
                }
            }

            int totalCarry =0;
            int carry = 0;
            String firstDigit = "";
            String secondDigit = "";

            int firstDigInt = 0;
            int secondDigInt = 0;

            for(int i = len; i>0; i--,len1--,len2--){

                if(len1 ==0 && len2==0){
                    break;
                }

                if(len1 <= 0){
                    firstDigInt = 0;
                }else{
                    firstDigit = firstString.substring(len1 - 1, len1);
                    firstDigInt = Integer.parseInt(firstDigit);
                }

                if(len2 <= 0){
                    secondDigInt = 0;
                }else{
                    secondDigit = secondString.substring(len2 - 1, len2);
                    secondDigInt = Integer.parseInt(secondDigit);
                }

                int add = firstDigInt + secondDigInt + carry;

                if(add>=10){
                    totalCarry++;
                    carry = 1;
                }else{
                    carry = 0;
                }
            }

            if(totalCarry == 0){
                sb.append("No carry operation.\n");
            }else if(totalCarry == 1){
                sb.append("1 carry operation.\n");
            }else{
                sb.append(totalCarry+" carry operations.\n");
            }
        }

        System.out.print(sb);
    }
}
