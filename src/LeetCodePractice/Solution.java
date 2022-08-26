package LeetCodePractice;

import java.util.*;
public class Solution {

    public boolean  canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer,LinkedList<Integer>> map= new HashMap<>();
        
                for(int i=0;i<numCourses;i++){
                    map.put(i,new LinkedList<Integer>());
                }
        
        for(int[] temp : prerequisites){
            LinkedList<Integer> list=map.get(temp[0]);
                list.add(temp[1]);
            }

        
        boolean[] visited = new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(map.get(i).size()>0 && !canFinish(i,map,visited)){
                return false;
            }
        }
        
      return true;
    }
    
    public boolean canFinish(Integer course, HashMap<Integer,LinkedList<Integer>> map,boolean[] visited){
        if(visited[course]){
            return false;
        }
        visited[course]=true;
        for(Integer j: map.get(course)){
            if(canFinish(j,map,visited)){
                return true;
            }
        }
        
        return true;
    }
}