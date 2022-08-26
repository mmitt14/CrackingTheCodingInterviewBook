package LeetCodePractice;

import java.util.*;

public class BSTNode {
    BSTNode left,right;
    int data;
    BSTNode(int data){
        this.data=data;
    }

    public void insert(int val){
        if(val<=data){
            if(left==null){
                left=new BSTNode(val);
            }
            else{
                left.insert(val);
            }
        }
        else {
            if(right==null){
                right=new BSTNode(val);
            }
            else {
                right.insert(val);
            }
        }
    }

    @Override
    public String toString() {
        return  ""+this.data;
    }

    public boolean contains(int val){
        if(val==data){
            return true;
        }
        if(val<data){
            if(left==null){
                return false;
            }
            else {
                return left.contains(val);
            }
        }
        else {
            if(right==null){
                return false;
            }
            else {
                return right.contains(val);
            }
        }

    }

    public void printInOrder(){
        if(left!=null){
            left.printInOrder();
        }
        System.out.println(data);
        if(right!=null){
            right.printInOrder();
        }
    }

}

    class BSTRunner{
        public static void main(String[] args) {
            BSTNode node=new BSTNode(10);
            node.insert(15);
            node.insert(20);
            node.insert(4);
            node.insert(7);
            node.insert(2);
            node.insert(12);

            System.out.println(node.contains(20));
//            node.printInOrder();
//            ArrayList<LinkedList<BSTNode>> res= listOfDepths1(node);
//            for(LinkedList<BSTNode> list:res){
//                System.out.println(list);
//            }

            System.out.println("Height of given tree is = "+heightOfBinaryTree(node));
            System.out.println("Min element is = "+minElement(node));
            System.out.println("Max element is = "+maxElement(node));

            System.out.println();
            verticalOrder(node);

//            levelOrderTraversal(node);
        }
        // We will use breadth first search here
        public static ArrayList<LinkedList<BSTNode>> listOfDepths(BSTNode root){
            ArrayList<LinkedList<BSTNode>> result = new ArrayList<>();

            LinkedList<BSTNode> cur= new LinkedList<>();
            if(root!=null){
                cur.add(root);
            }

            while (cur.size()>0){
                result.add(cur);
                LinkedList<BSTNode> parents=cur;
                cur=new LinkedList<BSTNode>();
                for(BSTNode parent:parents){
                    if(parent.left!=null){
                        cur.add(parent.left);
                    }
                    if(parent.right!=null){
                        cur.add(parent.right);
                    }
                }
            }
            return result;
        }

        public static void levelOrderTraversal(BSTNode root){
            if(root==null){
                return;
            }
            Queue<BSTNode> queue= new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while (!queue.isEmpty()){
                BSTNode cur=queue.poll();
                if(cur==null){
                    if(queue.isEmpty()) return;

                    queue.add(null);
                    System.out.println();
                    continue;
                }
                System.out.print(cur.data+" ");
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
        }

        public static ArrayList<LinkedList<BSTNode>> listOfDepths1(BSTNode root){
            HashMap<Integer,LinkedList<BSTNode>> result = new HashMap<>();

            listOfDepths1(root,result,0);
            return null;
        }

        private static void listOfDepths1(BSTNode root, HashMap<Integer,LinkedList<BSTNode>> result, int level) {
            if(root==null){
                return;
            }
            listOfDepths1(root.left,result,level-1);
            LinkedList<BSTNode> list=null;
            if(!result.containsKey(level)){
                list=new LinkedList<>();
                result.put(level,list);
            }
            else {
                list=result.get(level);
            }
            list.add(root);

            listOfDepths1(root.right,result,level+1);

        }

        public static int heightOfBinaryTree(BSTNode root){
            if(root==null){
                return -1;
            }
            return Math.max(heightOfBinaryTree(root.left),heightOfBinaryTree(root.right)) +1;
        }

        public static int minElement(BSTNode root){
            if(root==null){
                return Integer.MAX_VALUE;
            }

            return Math.min(root.data,Math.min(minElement(root.left),minElement(root.right)));
        }

        public static int maxElement(BSTNode root){
            if(root==null){
                return Integer.MIN_VALUE;
            }

            return Math.max(root.data,Math.max(maxElement(root.left),maxElement(root.right)));
        }

        // Level order traversal - BFS
        public static ArrayList<LinkedList<BSTNode>> listOfDepthsIterative(BSTNode root){
            ArrayList<LinkedList<BSTNode>> result = new ArrayList<>();

            LinkedList<BSTNode> cur= new LinkedList<>();
            if(root!=null){
                cur.add(root);
            }
            while (cur.size()>0){
                result.add(cur);
                LinkedList<BSTNode> parents=cur;
                cur=new LinkedList<BSTNode>();
                for(BSTNode parent:parents){
                    if(parent.left!=null){
                        cur.add(parent.left);
                    }
                    if(parent.right!=null){
                        cur.add(parent.right);
                    }
                }
            }
            return result;
        }

        public static void verticalOrder(BSTNode root) {
            Queue<Pair> queue= new ArrayDeque();
            Map<Integer, Integer> map= new TreeMap<>();

            queue.add(new Pair(0,root));
            while(!queue.isEmpty()){
                Pair cur= queue.poll();
//                if(!map.containsKey(cur.hd)){
                    map.put(cur.hd,cur.node.data);
//                }
                if(cur.node.left!=null){
                    queue.add(new Pair(cur.hd-1,cur.node.left));
                }
                if(cur.node.right!=null){
                    queue.add(new Pair(cur.hd+1,cur.node.right));
                }
            }

            for(Integer i:map.values()){
                System.out.println(i);
            }

        }

        public static  class Pair{
            int hd;
            BSTNode node;
            Pair(int hd,BSTNode node){
                this.hd=hd;
                this.node=node;
            }
        }




    }
