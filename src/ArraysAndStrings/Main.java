package ArraysAndStrings;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        System.out.println(stringRotation("waterbottle","erbottlewat"));
//        printAllSubString("abcbaaab");

        System.out.println(Integer.parseInt("00"));

    }




    public static boolean stringRotation(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        String s3=s1+s1;

        return s3.contains(s2);
    }

    public static void printAllSubString(String s){

        for (int i = 0; i <s.length() ; i++) {
            for (int j = i; j <s.length() ; j++) {
                System.out.println(s.substring(i,j+1));
            }
        }
    }






}
