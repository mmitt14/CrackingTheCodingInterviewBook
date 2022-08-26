package TreePracticePackge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ListOfDepths {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(10);
        treeNode.insert(4);
        treeNode.insert(15);
        treeNode.insert(20);
        treeNode.insert(7);
        treeNode.insert(2);
        ArrayList<LinkedList<TreeNode>> lists = listOfDepths(treeNode);
//        ArrayList<LinkedList<TreeNode>> lists = listOfDepthsIterative(treeNode);
        for(LinkedList<TreeNode> l:lists){
            for(TreeNode n:l){
                System.out.print(n.data+"->");
            }
            System.out.println();
        }


    }
    // For Binary Trees
    private static ArrayList<LinkedList<TreeNode>> listOfDepths(TreeNode root){
        ArrayList<LinkedList<TreeNode>> lists= new ArrayList<>();
        listOfDepthsRecursive(root,lists,0);
        return lists;
    }

    private static void listOfDepthsRecursive(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if(root==null){
            return;
        }
        LinkedList<TreeNode> linkedList = null;
        if(lists.size()==level){
            linkedList= new LinkedList<>();
            lists.add(linkedList);
        }
        else {
            linkedList=lists.get(level);
        }

        linkedList.add(root);
        listOfDepthsRecursive(root.left,lists,level+1);
        listOfDepthsRecursive(root.right,lists,level+1);

    }

    private static ArrayList<LinkedList<TreeNode>> listOfDepthsIterative(TreeNode root){
        ArrayList<LinkedList<TreeNode>> lists= new ArrayList<>();

        LinkedList<TreeNode> current = new LinkedList<>();

        if(root !=null){
            current.add(root);
        }

        while (current.size()>0){
            lists.add(current);
            LinkedList<TreeNode> parents = current;
            current=new LinkedList<>();
            for (TreeNode parent:parents){
                if(parent.left!=null){
                    current.add(parent.left);
                }
                if(parent.right!=null){
                    current.add(parent.right);
                }
            }
        }



        return lists ;
    }

}
