package TreePracticePackge;

import java.util.*;
class Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {



        int start=0;
        int maxLength= 0;
        ArrayList<Character> set= new ArrayList<>();

        for(int end=0;end<s.length();end++){
            while(set.contains(s.charAt(end))){
                set.remove(start);

            }
            set.add(s.charAt(end));
            maxLength = Math.max(maxLength,set.size());
        }

        return maxLength;

    }

    public static int lengthOfLongestSubstring1(String s) {

        int[] count=new int[128];
        int start=0;
        int end= 0;
        int res=0;
      while(end<s.length()){
          char c= s.charAt(end);
          count[c]++;
          while (count[c]>1){
              count[start]--;
              start++;
          }
          res=Math.max(res,end-start+1);
          end++;

      }

      return res;
    }

}