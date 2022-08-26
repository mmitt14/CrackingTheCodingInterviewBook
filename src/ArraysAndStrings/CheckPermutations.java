package ArraysAndStrings;

import java.util.Arrays;

public class CheckPermutations {
    public static void main(String[] args) {
        String s1= "abcdefg";
        String s2= "cdeflba";
        System.out.println(checkPermutationNormal(s1,s2));


    }


    public static boolean checkPermutationASCII(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }

        if(s1.length()>256){
            return false;
        }
        int[] count=new int[256];

        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for(int i:count){
            if (i!=0){
                return false;
            }
        }

        return true;
    }

    public static boolean checkPermutationNormal(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }

        return sort(s1).equals(sort(s2));
    }

    public static String sort(String s){
        char[] c=s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
