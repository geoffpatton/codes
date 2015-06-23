/**
 * Created by tua26762 on 6/23/2015.
 */
public class SubstringCheck {

    public static void main (String[] args){

        String a = "1010110010";
        String b = "10110";

        int result = SubStringCheck(a,b);
        System.out.println("result= "+result);

    }

    public static int SubStringCheck(String a, String b){

        for (int y = 0; y<5; y++) {
            if (a.substring(y, y + 5).equals(b)) {
                return 1;
            }

        }
        return 0;
    }

}
