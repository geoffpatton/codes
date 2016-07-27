package problems;
//G
//This program takes an random input of small integers of one or two digits. It prints out the input but stops processing at 42

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LIFE_UNIVERSE
{
  public static void main (String[] args) throws java.lang.Exception
  {
      
      try{
          //read input
          BufferedReader input_buf = new BufferedReader( new InputStreamReader( System.in ));
          String in;
          
          while(  (in = input_buf.readLine()) != null ){ //sets in to input data stream
              if(!in.equals("42")){  //if not equal to 42 print, else break out of loop
              
                  System.out.println(in);
              
              }else{
                  
                  break;
              }
          }
      }catch(IOException e){
          System.out.println(e.toString());
      }

  }


}
