package SlidingWindow;

public class Main {
    public static void main(String[] args) {
        int [] arr = {4,2,1,7,8,1,2,8,10,0};
        int k=18;
        System.out.println(smallestSubArraySum(arr,k));
    }

    public static int maxSubArraySize(int [] arr, int k){
        int curSum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            curSum+=arr[i];
            if(i>=k-1){
                max=Math.max(max,curSum);
                curSum=curSum-arr[i-k+1];
            }
        }
        return max;
    }

    public static int smallestSubArraySum(int [] arr, int k){
        int windowStart=0;
        int curSum=0;
        int minSize=Integer.MAX_VALUE;
        for(int windowEnd=0;windowEnd<arr.length;windowEnd++){
            curSum+=arr[windowEnd];

            while (curSum>=k){
                minSize=Math.min(minSize,windowEnd-windowStart+1);
                curSum-=arr[windowStart];
                windowStart++;
            }
        }
        return minSize;
    }
}
