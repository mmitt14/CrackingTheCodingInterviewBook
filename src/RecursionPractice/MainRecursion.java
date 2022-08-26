package RecursionPractice;

import java.util.Arrays;

public class MainRecursion {

    public static void main(String[] args) {

//        System.out.println(fibIterative(25));
//        System.out.println(fib(5));

        int [] arr = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025};
        System.out.println(binarySearch(arr,0,arr.length-1,55));

    }

    private static int fact(int n){
        if(n<2){
            return 1;
        }
        return n*fact(n-1);
    }

    private static int fib(int n){
        if(n <2){
            return n;
        }
        return fib(n-1)+fib(n-2);

    }

    private static int fibIterative(int n){
        if(n<2){
            return n;
        }
        int f0=0;
        int f1= 1;
        int f2=0;
        for(int i=2;i<=n;i++){
            f2=f0+f1;
            f0=f1;
            f1=f2;
        }
        return f2;
    }

    private static int fibIterativeOptimized(int n){
        if(n<2){
            return n;
        }
        int[] arr= new int[n+1];
         arr[0]=0;
        arr[1]= 1;
        int f2=0;
        for(int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];

        }
        System.out.println(Arrays.toString(arr));
        return arr[n];
    }

    private static int binarySearch(int [] arr,int start,int end,int target){
        if(start>end){
            return -1;
        }
        int m= start + (end-start)/2;
        if(target==arr[m]){
            return m;
        }
        if(target<arr[m]){
            return binarySearch(arr,start,m-1,target);
        }
        return binarySearch(arr,m+1,end,target);
    }

    public static int binarySearchIterative(int [] arr,int start,int end,int target){


        while (start<=end){
            int m= start + (end-start)/2;
            if(target==arr[m]){
                return m;
            }
            if(target<arr[m]){
                end=m-1;
            }
            else {
                start=m+1;
            }
        }

        return -1;
    }

    public static int sumOfDigitsRecursive(int n){
        return -1;
    }


}
