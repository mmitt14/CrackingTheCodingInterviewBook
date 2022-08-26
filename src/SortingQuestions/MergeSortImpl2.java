package SortingQuestions;

import java.util.Arrays;

public class MergeSortImpl2 {

    public static void main(String[] args) {

        int[] arr={9,4,7,6,3,1,5};
        int[] temp=new int[arr.length];
        System.out.println(Arrays.toString(arr));
        mergeSort1(arr,temp,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    private static void mergeSort1(int[] arr, int[] temp, int start, int end) {
        if(start>=end){
            return;
        }
        int mid = (start+end)/2;
        mergeSort1(arr,temp,start,mid);
        mergeSort1(arr,temp,mid+1,end);
        merge(arr,temp,start,end,mid);
    }

    private static void merge(int[] arr, int[] temp, int start, int end, int mid) {
        int i=start;
        int j=mid+1;
        int k=i;
        while (i<=mid && j<=end){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        //copy the remain elements
        while(i<=mid) temp[k++]=arr[i++];
        while(j<=end) temp[k++]=arr[j++];

        for (k = start; k <=end ; k++) {
            arr[k]=temp[k];
        }

    }
}
