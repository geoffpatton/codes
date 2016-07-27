package problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by tua26762 on 12/21/2015.
 */
public class BITPLAY {
    int c;
    public static void main(String[] args)  throws IOException{
        new BITPLAY().run();
    }
    private void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(in.nextToken());

        while (t-->0){
            in = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(in.nextToken());
            int k = Integer.parseInt(in.nextToken());

            if(k==0) {
                System.out.println("-1");
            }else if(k==1){
                System.out.println("1");
            }else{
                String a=binaryNum(n);
                int len=a.length();
                String ans="";
                k=k-1;

                for(int i=0;i<len-1;i++){
                    if(a.charAt(i)=='1'){
                        if(k>0 && c!=1){ ans+='1';k--;}
                        else ans+='0';
                        c--;
                    }
                    else{
                        if(c>0) ans+='0';
                        else{
                            if(k>0){ans+='1';k--;}
                            else ans+='0';
                        }
                    }
                }
                ans+="1";
                System.out.println(dn(ans));
            }
        }
        return;
    }

    private String binaryNum(int n){
        c=0;
        String ans ="";
        while(n>0){
            if(n%2==0){
                ans="0"+ans;
            }else{
                ans = "1" + ans;
                c++;
            }
            n=n/2;
        }
        return ans;
    }

    private int dn(String s){
        int n=0;
        int k=1;
        int sz=s.length();
        for(int i=sz-1; i>=0; i--){
            if(s.charAt(i)=='1'){
                n+=k;
            }
            k=k*2;
        }
        return n;
    }
}
