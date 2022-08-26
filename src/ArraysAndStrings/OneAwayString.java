package ArraysAndStrings;

public class OneAwayString {
    public static void main(String[] args) {
        String s1 = "pae";
        String s2="pale";
        System.out.println(oneAway(s1,s2));

    }

    public static boolean oneAway(String s1, String s2){

        if(s1.length()==s2.length()){
            return oneReplaceAway(s1,s2);
        }
        else if(s1.length()==s2.length()+1){
            return oneEditAway(s1,s2);
        }
        else if(s2.length()==s1.length()+1){
            return oneEditAway(s2,s1);
        }
        else{
            return false;
        }
    }


    public static boolean oneReplaceAway(String s1, String s2){
        boolean check= false;

        for (int i = 0; i <s1.length() ; i++) {

            if(s1.charAt(i)!= s2.charAt(i)){
                if(check){
                    return false;
                }
                check=true;
            }
        }

        return true;
    }

    public static boolean oneEditAway(String s1, String s2){
        boolean check=false;
        int i=0;
        int j=0;
        while(j<s2.length()){
            if(s1.charAt(i)!= s2.charAt(j)){
                if(check){
                    return false;
                }
                check=true;
                i++;

            }
            else{
                i++;
                j++;
            }
        }
        return true;
    }


}
