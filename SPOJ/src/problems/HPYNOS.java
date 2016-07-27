package problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by geoffpatton on 8/4/2015.
 */
public class HPYNOS {
    public static void main(String[] args) throws IOException{
        new HPYNOS().run();
    }
    public void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(br.readLine());
        Set<Long> set = new HashSet<>();
        int count = 0;
        while(!set.contains(n) && n!=1) {
            count++;
            set.add(n);
            long sum = 0;
            while (n > 0) {
                long remainder = (n % 10);
                sum += remainder * remainder;
                n /= 10;
            }
            n = sum;
        }
        if(n == 1){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }
    }
}
