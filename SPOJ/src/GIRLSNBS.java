import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by geoffpatton on 8/3/15.
 */
public class GIRLSNBS {

    public static void main(String[] args) throws IOException{
        new GIRLSNBS().run();
    }

    private void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(br.readLine());

        int g, b=0;

        g= Integer.parseInt(in.nextToken());
        b = Integer.parseInt(in.nextToken());

        while ((g!=-1) && b!=-1){
            if(g==0&&b==0){
                System.out.println(0);
            }else if(g==b){
                System.out.println(1);
            }else{
                System.out.println(calculate(g,b));
            }
            in = new StringTokenizer(br.readLine());
            g= Integer.parseInt(in.nextToken());
            b = Integer.parseInt(in.nextToken());
        }



    }

    private int calculate(int g, int b){
        int ans =0;
        if(g>b){
            ans= (g+b)/(b+1);
        }else{
            ans = (b+g)/(g+1);
        }
        return ans;
    }


}
