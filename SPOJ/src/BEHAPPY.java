import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by geoffpatton on 8/5/2015.
 */
public class BEHAPPY {

    public static void main(String[] args) throws IOException{
        new BEHAPPY().run();
    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            StringTokenizer in = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(in.nextToken());
            int N = Integer.parseInt(in.nextToken());

            if(M == 0 && N == 0){
                break;
            }
            List<Integer[]> list = new ArrayList<>();

            int Ai[] = new int[M];
            int Bi[] = new int[M];



            for (int i = 0; i < M; i++) {
                in = new StringTokenizer(br.readLine());
                Ai[i] = Integer.parseInt(in.nextToken());
                Bi[i] = Integer.parseInt(in.nextToken());
            }

            for(int i = 0; i<M; i++){
                Integer[] temp = new Integer[Bi[i]-Ai[i]+1];
                for(int y = 0; y<=Bi[i]-Ai[i]; y++){
                    temp[y] = Ai[i] +y;
                }
                list.add(temp);
            }


            for (int i = 0; i < list.size(); i++) {

                System.out.println(Arrays.deepToString(list.get(i)));

            }
            Integer ans = list.get(0)[1];

            System.out.println(ans.toString());
            int size = list.size();
            System.out.println(size);

            System.out.println(list.get(0).length);


/*
            3 5
            0 1
            1 3
            1 4
            0 0*/



        }

    }




}
