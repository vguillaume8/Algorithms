import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickBest{

    public static int count = 0;

    public static void main(String[] args){
        // int[] array2 = new int[16];
        // for(int i = 0; i < 50000; i++){
        //     for(int j = 0; j < array2.length; j++){
        //         array2[j] = ThreadLocalRandom.current().nextInt(0, 10);
        //     }
        //     System.out.println(Arrays.toString(array2));
        //     QuickSort(array2, 0, array2.length-1);
        //     if(count == 38){
        //         System.out.println("STOP");
        //         break;
        //     }
        //     System.out.println(count);
        //     count = 0;
        
        // }
        int[] array = new int[] {4,1,3,5,6,7,2,4};
        int[] array2 = new int[] {1, 3, 0, 6, 0, 3, 4, 6, 5, 7, 2, 5, 7, 8, 5, 4};
        QuickSort(array, 0, array.length-1);
        System.out.println("The best scenario using the equtation: (n+1)log2(n) + 2(1 - n) for n = 8 is 13 ");
        System.out.println("The count for: [4,1,3,5,6,7,2]" + " is: " + count);
        count = 0;
        QuickSort(array2, 0, array2.length-1);
        System.out.println("The best scenario using the equtation: (n+1)log2(n) + 2(1 - n) for n = 16 is 38 ");
        System.out.println("The count for: {1, 3, 0, 6, 0, 3, 4, 6, 5, 7, 2, 5, 7, 8, 5, 4}" + " is: " + count);


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



   
}