package LeetCodePractice;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph1 {
    public HashMap<Integer,Node> adjList=new HashMap<>();

    private class Node {
        private int id;
        LinkedList<Node> adj = new LinkedList();
        private Node(int id){
            this.id=id;
        }
    }

    public Node getNode(int id){
        if(adjList.containsKey(id)){
            return adjList.get(id);
        }
        else {
            Node temp=new Node(id);
           adjList.put(id, temp);
           return temp;
        }
    }

    public void addEdge(int source,int destination){
        Node s=getNode(source);
        Node d=getNode(destination);
        s.adj.add(d);
        d.adj.add(s);
    }

    public boolean hasPathDFS(int source, int destination){
        Node s=getNode(source);
        Node d=getNode(destination);
        HashSet<Node> visited= new HashSet<>();
        return hasPathDFS(s,d,visited);
    }

    private boolean hasPathDFS(Node source, Node destination, HashSet<Node> visited) {
        if(visited.contains(source)){
            return false;
        }
        visited.add(source);
        System.out.print(source.id+",");
        if(source==destination){
            return true;
        }

        for(Node neighbor: source.adj){
            if(!visited.contains(neighbor) && hasPathDFS(neighbor,destination,visited)){
                return true;
            }
        }

        return false;
    }

    public boolean hasPathBFS(int source, int destination){
        Node s=getNode(source);
        Node d=getNode(destination);
        Queue<Node> queue= new LinkedList<>();
        HashSet<Node> visited= new HashSet<>();
        HashMap<Node,Node> parent=new HashMap<>();
        boolean hasPath=false;
        queue.add(s);
        while (!queue.isEmpty()){
            Node cur= queue.poll();
            if(visited.contains(cur)){
                continue;
            }
            visited.add(cur);
            System.out.print(cur.id+",");
            if(cur==d){
                hasPath=true;
                break;
            }
            for (Node neighbor: cur.adj){
                if(!visited.contains(neighbor)) {
                    parent.put(neighbor,cur);
                    queue.add(neighbor);
                }
            }
        }
        Node c=d;
        int distance=-1;
        while (c !=null){
            distance++;
            c=parent.get(c);
        }
        System.out.println("\nShortest Distance is = "+distance);
        return hasPath;
    }

    public void printAdjancenyList(){
        for(int i:adjList.keySet()){
            System.out.print(i+"->");
            for (Node node: adjList.get(i).adj){
                System.out.print(node.id+",");
            }
            System.out.println();
        }
    }


}

    class GraphRunner1{
        public static void main(String[] args) {
            Graph1 graph1 = new Graph1();
            graph1.addEdge(1,2);
            graph1.addEdge(1,3);
            graph1.addEdge(3,5);
            graph1.addEdge(3,4);
            graph1.addEdge(4,6);
            graph1.addEdge(4,7);
            graph1.addEdge(5,8);
            graph1.addEdge(5,9);
            graph1.addEdge(9,10);

            System.out.println(graph1.hasPathBFS(1,8));

        }
    }
