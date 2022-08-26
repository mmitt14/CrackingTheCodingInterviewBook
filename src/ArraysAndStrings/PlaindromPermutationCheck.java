package ArraysAndStrings;

import java.util.HashMap;

public class PlaindromPermutationCheck {
    public static void main(String[] args) {
        String s = "tactcoallraar";
        System.out.println(isPlaindromPermNormal(s));


    }

    public static boolean isPalindromPermASCII(String s){
        int[] count = new int[256];
        boolean check= false;
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)]++;
        }
        for(int i:count){
            if(i%2==1){
                if(check){
                    return false;
                }
                check=true;
            }
        }
        return true;
    }

    public static boolean isPlaindromPermNormal(String s){
        HashMap<Character,Integer> hs= new HashMap<>();
        boolean check= false;
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            if(hs.containsKey(c)){
                Integer v=hs.get(c);
                hs.put(c,v+1);
            }
            else {
                hs.put(c,1);
            }
        }

        for(int i:hs.values()){
            if(i%2==1){
                if(check){
                    return false;
                }
                check=true;
            }
        }
        return true;
    }
}
