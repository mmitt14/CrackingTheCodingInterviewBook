package TreePracticePackge;

import java.util.*;

public class Graph2 {

//    public LinkedList<Integer> [] adj;
    public HashMap<Integer,LinkedList<Integer>> adj;

    public Graph2(){
        adj=new HashMap<>();
    }

    public void addEdge(int source, int destination){
        if(adj.containsKey(source)){
            adj.get(source).add(destination);
        }
        else{
            LinkedList<Integer> temp = new LinkedList<>();
            temp.add(destination);
            adj.put(source,temp);
        }

        if(adj.containsKey(destination)){
            adj.get(destination).add(source);
        }
        else{
            LinkedList<Integer> temp = new LinkedList<>();
            temp.add(source);
            adj.put(destination,temp);
        }


    }

    public int BFS(int source, int destination){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer,Integer> parent=new HashMap<>();
        q.add(source);
        visited.add(source);
        while (!q.isEmpty()){
            int cur= q.poll();
            if(cur==destination){
                break;
            }
            for(int child:adj.get(cur)){
                if(!visited.contains(child)){
                    visited.add(child);
                    parent.put(child,cur);
                    q.add(child);
                }
            }
        }

        int distance =-1;
        Integer cur= destination;
        while (cur!=null){
            cur=parent.get(cur);
            distance++;
        }
        return distance;

    }

    public boolean DFS(int source, int destination){
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        stack.add(source);
        visited.add(source);
        while (!stack.isEmpty()){
            int cur= stack.pop();
            if(cur==destination){
                System.out.println(cur);
                return true;
            }
            System.out.print(cur+" -> ");
            for(int child:adj.get(cur)){
                if(!visited.contains(child)){
                    visited.add(child);
                    stack.add(child);
                }
            }
        }
        return false;

    }

//    public boolean DFSRecursive(int source, int destination){
//
//    }
}

    class Graph2Runner{
        public static void main(String[] args) {
            Graph2 graph = new Graph2();
            graph.addEdge(1,2);
            graph.addEdge(1,3);
            graph.addEdge(3,5);
            graph.addEdge(3,4);
            graph.addEdge(4,7);
            graph.addEdge(4,8);
            graph.addEdge(8,9);
            graph.addEdge(8,11);
            graph.addEdge(9,10);
            graph.addEdge(5,10);
            System.out.println(graph.DFS(1,9));
        }
    }
