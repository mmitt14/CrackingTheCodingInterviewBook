package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class UniqueString {
    public static void main(String[] args) {
        String str= "abcdefg";

        System.out.println(isUniqueNormal(str));
    }
    public static boolean isUniqueASCII(String str){

        if(str.length()>256){
            return false;
        }

        boolean[] check = new boolean[256];

        for(int i=0;i<str.length();i++){
            int temp = str.charAt(i);
            if(check[temp]){
                return false;
            }
            check[temp]=true;
        }

        return true;
    }

    public static boolean isUniqueNormal(String str){
        List<Character> arraylist = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(arraylist.contains(str.charAt(i))){
                return false;
            }
            arraylist.add(str.charAt(i));
        }

        return true;
    }
}
