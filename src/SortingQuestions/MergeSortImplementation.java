package SortingQuestions;

import java.util.Arrays;

public class MergeSortImplementation {
    public static void main(String[] args) {

        int[] arr={9,4,7,6,3,1,5};
        int[] temp=new int[arr.length];
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,temp,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr,int[] temp,int left,int right){
        if(left>=right){
            return;
        }
        int mid= (left+right)/2;
        mergeSort(arr,temp,left,mid);
        mergeSort(arr,temp,mid+1,right);
        merge(arr,temp,left,mid,right);
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i=left;
        int j= mid+1;
        int k=left;

        while (i<=mid && j<=right){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }
            else {
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        if(i>mid){
            while (j<=right){
                temp[k]=arr[j];
                k++;
                j++;
            }
        }
        else {
            while (i<=mid){
                temp[k]=arr[i];
                k++;
                i++;
            }
        }

        for (k=left;k<=right;k++){
            arr[k]=temp[k];
        }
    }
}
