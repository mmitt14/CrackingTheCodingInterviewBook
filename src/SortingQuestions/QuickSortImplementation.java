package SortingQuestions;

import java.util.Arrays;

public class QuickSortImplementation {
    public static void main(String[] args) {
//        int[] arr={9,4,7,6,3,1,5};
        int[] arr={1, 3, 4, 5, 6, 7, 9};

        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int pivot=arr[(left+right)/2];
        int index=partition(arr,left,right,pivot);
        quickSort(arr,left,index-1);
        quickSort(arr,index,right);

    }

    private static int partition(int[] arr, int left, int right, int pivot) {

        while (left<=right){

            while (arr[left]<pivot){
                left++;
            }
            while (arr[right]>pivot){
                right--;
            }
            if(left<=right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
