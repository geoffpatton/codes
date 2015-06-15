/**
 * Created by tua26762 on 6/9/2015.
 */
public class Clothing {
    int shirt = 0;
    int pants = 0;
    int shoes = 0;
    int socks = 0;


    public Clothing(int a, int b, int c, int d){
        shirt = a;
        pants = b;
        shoes = c;
        socks = d;
    }

    public int increaseShoes(int a){
        shoes += a;
        return shoes;
    }

    public void print(){
        System.out.println(shirt);
        System.out.println(pants);
        System.out.println(shoes);
        System.out.println(socks);
    }











}
