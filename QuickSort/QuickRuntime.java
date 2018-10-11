import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;


public class QuickRuntime{
    public static int count = 0;

    public static void main(String[] args){
        System.out.println("n       E(n)            E(n)/n^2        E(n)/nlog(n)");
        System.out.println();
        for(int n = 50; n < 5001; n = n + 50){
            int[] array = new int[n];
            for(int j = 0; j < array.length; j++){
                array[j] = j;
            }
            //System.out.println(Arrays.toString(array));
            int[] permArray = permutateList(array);
            QuickSort(permArray, 0, permArray.length - 1);
            //System.out.println("Counter: " + count);
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

        public static int partition(int data[], int low, int high){
        
            int pivot = data[high]; 
            int i = (low-1); 
            for (int j=low; j<high; j++){
                
                count++;
                if (data[j] <= pivot){
                    
                    i++;

                    
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }

            int temp = data[i+1];
            data[i+1] = data[high];
            data[high] = temp;
    
            return i+1;
        
    }
//---------------------------------------------------------------------------------------------------------
 
    public static String QuickSort(int data[], int low, int high){
        
        if (low < high){
            
            int pi = partition(data, low, high);
 
            
            QuickSort(data, low, pi-1);
            QuickSort(data, pi+1, high);
        }
            return Arrays.toString(data);
    }

    public static double log2(double num){
        return (Math.log(num)/Math.log(2));
    }
}