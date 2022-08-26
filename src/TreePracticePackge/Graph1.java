package TreePracticePackge;

import java.util.*;

public class Graph1 {

    public HashMap<Integer,Node> nodeLookup = new HashMap<>();
    public static class Node{
        private int id;
        LinkedList<Node> adjacent=new LinkedList<>();

        private Node(int id){
            this.id=id;
        }

    }

    private Node getNode(int id){
        if(nodeLookup.containsKey(id)){
            return nodeLookup.get(id);
        }
        Node node= new Node(id);
        nodeLookup.put(id,node);
        return node;
    }

    public void addEdge(int source, int destination){
        Node s =getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
        d.adjacent.add(s);
    }

    public void addEdgeDirected(int source, int destination){
        Node s =getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }



    public boolean hasPathDFS(int source, int destination){
        Node s =getNode(source);
        Node d = getNode(destination);
        HashSet<Node> visited = new HashSet<>();
//        return hasPathDFS(s,d,visited);
//
        return hasPathDFSRecursive1(s,d,visited);
    }
    private boolean hasPathDFSRecursive1(Node source, Node destination, HashSet<Node> visited) {
        if(visited.contains(source)){
            return false;
        }
        System.out.print(source.id+", ");
        visited.add(source);
        if(source==destination){
            return true;
        }
        for(Node neighbour: source.adjacent){
            if(!visited.contains(neighbour) && hasPathDFSRecursive1(neighbour,destination,visited)){
                return true;
            }
        }
        return false;
    }



        // Recursive Approach
    private boolean hasPathDFS(Node source, Node destination, HashSet<Node> visited) {
        if(visited.contains(source)){
            return false;
        }
        visited.add(source);
        if(source==destination){
            System.out.println(source.id);
            return true;
        }
        System.out.print(source.id+"->");

        for(Node child: source.adjacent){
            if(!visited.contains(child) && hasPathDFS(child,destination,visited)){
                return true;
            }
        }
        return false;
    }

//    Iterative Approach
    private boolean hasPathDFSIterative(Node source, Node destination) {
        Stack<Node> nextToVisitStack = new Stack<>();
        HashSet<Node> visited=new HashSet<>();
        nextToVisitStack.add(source);
        while (!nextToVisitStack.isEmpty()){
            Node node=nextToVisitStack.pop();
            if(node==destination){
                System.out.println(node.id);
                return true;
            }
            if(visited.contains(node)){
                continue;
            }
            System.out.print(node.id+"->");
            visited.add(node);
            for(Node child: node.adjacent){
                if(!visited.contains(child)) {
                    nextToVisitStack.add(child);
                }
            }
        }
        return false;
    }
    public boolean hasPathBFS(int source, int destination){
        Node s =getNode(source);
        Node d = getNode(destination);
        HashSet<Node> visited = new HashSet<>();
        return hasPathBFS1(s,d);
    }

    public boolean hasPathBFS1(Node source, Node destination){
        Queue<Node> queue=new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        HashMap<Node,Node> parent = new HashMap<>();
        boolean hasPath = false;
        queue.add(source);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            visited.add(cur);
            System.out.print(cur.id+", ");
            if(cur==destination){
                System.out.println();
                hasPath=true;
                break;
            }
            for(Node neighbour: cur.adjacent){
                if(!visited.contains(neighbour)) {
                    parent.putIfAbsent(neighbour, cur);
                    queue.add(neighbour);
                }
            }

        }
        int distance=0;
        Node cur =destination;
        while (parent.get(cur)!=null){
            distance++;
            cur=parent.get(cur);
        }
        System.out.println("Shortest path "+distance);
        return hasPath;
    }

    public boolean hasPathBFS(Node source, Node destination){
        Queue<Node> nextToVisitQueue = new LinkedList<>();
        HashSet<Node> visited=new HashSet<>();

        nextToVisitQueue.add(source);
        while (!nextToVisitQueue.isEmpty()){
            Node node=nextToVisitQueue.poll();
            if(node==destination){
                System.out.println(node.id);
                return true;
            }
            if(visited.contains(node)){
                continue;
            }
            System.out.print(node.id+"->");
            visited.add(node);
            for(Node child: node.adjacent){
                if(!visited.contains(child)) {
                    nextToVisitQueue.add(child);
                }
            }
        }
        return false;
    }

    public void printAdjancyList(){
        for(Node node:nodeLookup.values()){
            System.out.print(node.id+"->");
            for (Node n: node.adjacent){
                System.out.print(n.id+" ");
            }
            System.out.println();
        }
    }
}

    class Graph1Runner{
        public static void main(String[] args) {
//            Graph1 graph= new Graph1();
//            graph.addEdge(1,2);
//            graph.addEdge(1,3);
//            graph.addEdge(3,5);
//            graph.addEdge(3,4);
//            graph.addEdge(4,7);
//            graph.addEdge(4,8);
//            graph.addEdge(8,9);
//            graph.addEdge(9,10);
//            graph.addEdge(8,11);
//            System.out.println(graph.hasPathDFS(1,11));

            Graph1 graph1 = new Graph1();
            graph1.addEdgeDirected(1,2);
            graph1.addEdgeDirected(1,3);
            graph1.addEdgeDirected(3,4);
            graph1.addEdgeDirected(3,5);
            graph1.addEdgeDirected(4,8);
            graph1.addEdgeDirected(4,6);
            graph1.addEdgeDirected(6,5);
            graph1.addEdgeDirected(8,9);
            graph1.addEdgeDirected(9,10);


            System.out.println(graph1.hasPathBFS(1,10));
//            graph1.printAdjancyList();

        }

    }
