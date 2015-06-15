/**
 * Created by tua26762 on 6/8/2015.
 */
public class PassPrimitiveByValue {

    public PassPrimitiveByValue(){

    }



    public static void main (String[] args){

        double payment  = computePayment(1000, .025, 1010, 100);

        System.out.print(payment);

        int x = 3;

        // invoke passMethod() with
        // x as argument
        x = passMethod(x);

        // print x to see if its
        // value has changed
        System.out.println("After invoking passMethod, x = " + x);


    }

    // change parameter in passMethod()
    public static int passMethod(int p) {
        p = 10;
        return p;
    }


    public static double computePayment(
            double loanAmt,
            double rate,
            double futureValue,
            int numPeriods) {
        double interest = rate / 100.0;
        double partial1 = Math.pow((1 + interest),
                - numPeriods);
        double denominator = (1 - partial1) / interest;
        double answer = (-loanAmt / denominator)
                - ((futureValue * partial1) / denominator);
        return answer;
    }


}
