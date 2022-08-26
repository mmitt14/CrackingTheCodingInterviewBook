package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicateInArrayExample{
public static int removeDuplicateElements(int arr[]){

        int j = 1;
        for (int i=0; i<arr.length-1; i++){
            if (arr[i] != arr[i+1]){
                arr[j++] = arr[i+1];
            }
         }

        return j;
    }  
       
    public static void main (String[] args) {  
        int arr[] = {10,20,20,30,30,40,50};
        int l=removeDuplicateElements(arr);


        //printing array elements  
        for (int i=0; i<l; i++)
           System.out.print(arr[i]+" ");
    }
}  