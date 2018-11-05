import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class BSTRuntime{

    public static void main(String[] args){
        System.out.println("n       E(n)            E(n)/n^2        E(n)/nlog(n)");
        System.out.println();
        



        for(int n = 50; n < 5001; n = n + 50){
            BST tree = new BST();
            int[] array = new int[n];
            for(int j = 0; j < array.length; j++){
                array[j] = j;
            }
            //System.out.println(Arrays.toString(array));
            int[] permArray = permutateList(array);
            for(int i = 0; i < permArray.length; i++){
                tree.insert(permArray[i]);
            }
            int count = tree.getCounter();
            double runtime = count/(n*log2(n));
            System.out.format("%d\t%d\t\t%f\t%f\n", 
                n, 
                count, 
                count/(Math.pow(n,2)),
                runtime 
                
            );
            count = 0;

            
        }


    }
//---------------------------------------------------------------------------------------------------------
    public static int[] permutateList(int[] arr){
        int length = arr.length - 1;
        for(int i = length; i >= 0; i--){
            int rand = ThreadLocalRandom.current().nextInt(0, i +1);
            int temp = arr[rand];
            arr[rand] = arr[i];
            arr[i] = temp;

        }
        return arr;
    }
//---------------------------------------------------------------------------------------------------------
    public static double log2(double num){
        return (Math.log(num)/Math.log(2));
    }
}