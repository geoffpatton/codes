package problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by geoffpatton on 8/5/2015.
 */
public class BEHAPPY {
    int count=0;

    public static void main(String[] args) throws IOException{
        new BEHAPPY().run();
    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(br.readLine());

        while (true) {
            count=0;

            while(in.hasMoreTokens()==false){  //go to next line if no tokens exist
                in = new StringTokenizer(br.readLine());
            }

            int M = Integer.parseInt(in.nextToken());
            int N = Integer.parseInt(in.nextToken());

            if(M == 0 && N == 0){
                break;
            }
            List<List<Integer>> res = new ArrayList<>();

            int Ai[] = new int[M];
            int Bi[] = new int[M];

            for (int i = 0; i < M; i++) {
                while(in.hasMoreTokens()==false){
                    in = new StringTokenizer(br.readLine());
                }
                Ai[i] = Integer.parseInt(in.nextToken());
                Bi[i] = Integer.parseInt(in.nextToken());
            }

            for(int i = 0; i<M; i++){
                List<Integer> temp1 = new ArrayList<>();
                for(int y = 0; y<=Bi[i]-Ai[i]; y++){
                    temp1.add(Ai[i] +y);
                }
                res.add(temp1);
            }
            calculate(res, M, N);
            System.out.println(count);
        }
    }

    private List<List<Integer>> calculate(List<List<Integer>> input, int M, int N) {

        List<List<Integer>> res = new ArrayList<>();
        if (input.isEmpty()) { // if no more elements to process
            res.add(new ArrayList<>()); // then add empty list and return
            return res;
        } else {
            process(input, res, M, N); // we need to calculate the cartesian product of input and store it in res variable
        }
        return res; // method completes , return result
        //return count;
    }

    private void process(List<List<Integer>> lists, List<List<Integer>> res, int M, int N) {
        List<Integer> head = lists.get(0); //take first element of the list
        List<List<Integer>> tail = calculate(lists.subList(1, lists.size()), M, N); //invoke calculate on remaining element, here is recursion

        for (Integer h : head) { // for each head
            for (List<Integer> t : tail) { //iterate over the tail
                List<java.lang.Integer> tmp = new ArrayList<>(t.size());
                tmp.add(h); // add the head
                tmp.addAll(t); // and current tail element
                res.add(tmp);

                if(tmp.size() == M){
                    int sum = tmp.stream().mapToInt(value -> value).sum();
                    if(sum == N){
                        count++;
                    }
                }
            }
        }
    }
}
