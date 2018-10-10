import java.util.Random;
import java.util.Stack;

public class Euclid{

  // runtime counter
  public static int counter = 0;

  public static void main(String[] args){

    System.out.println("n                eav                    eav/log2  ");
    System.out.println();
    Random rm = new Random();

    // Stack to hold random integers
    Stack<Integer> stack = new Stack<Integer>();

    for(int n = 50; n < 5001; n = n + 50){

      for(int i = 0; i < 20; i++){

        stack.push(rm.nextInt(n));
      }
      emptyStack(n, stack);
      double avg = counter / 20.0;
      double runtime = avg /(log2(n));
      System.out.printf("%-15s %-15s %10s %n", n, avg, runtime);
      counter = 0;
    }
  }


  // Calculates the log of base 2
  public static double log2(double num){
    return (Math.log(num)/Math.log(2));
  }

  // empties that stack of integers
  public static void emptyStack(int n, Stack<Integer> stack){
    while(!stack.isEmpty()){
      int m = stack.pop();
      gcd(n, m);
    }
  }

  // gcd methos
  public static int gcd(int n, int m){
    counter++;
    if ((m == 0) || (n == m)) return n;
    else return gcd(m, n % m);
  }

}
