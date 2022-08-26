package TreePracticePackge;

import java.util.Optional;
import java.util.Stack;

class Index{
    public static int value;
}

public class ValidateBST {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(20);
        treeNode.insert(25);
       treeNode.insert(15);
        treeNode.insert(10);
        treeNode.insert(18);
        treeNode.insert(5);
        treeNode.insert(12);
        treeNode.insert(16);
        treeNode.insert(19);
        treeNode.insert(30);
        TreeNode n=treeNode.insert(35);
        treeNode.insert(27);


        System.out.println((successorBST(n,treeNode)));

    }

    // only use root node for finding parent
    public static TreeNode successorBST(TreeNode n, TreeNode root){
        if(n==null){
            return null;
        }

        if(n.right !=null){
            return leftMostChild(n.right);
        }

        TreeNode child= n;
        TreeNode parent = getParent(root,n);
        while (parent!=null && parent.left!=child){
            child=parent;
            parent=getParent(root,parent);
        }


        return parent;
    }

    private static TreeNode getParent(TreeNode root, TreeNode n) {
        if(n==null || root==null){
            return null;
        }
        TreeNode cur = root;
        TreeNode parent=null;
        while (cur!=null){
            if(n.data<cur.data){
                parent=cur;
                cur=cur.left;
            }else if(n.data>cur.data){
                parent=cur;
                cur=cur.right;
            }
            else {
                break;
            }
        }
        return parent;
    }

    private static TreeNode leftMostChild(TreeNode n) {
        if(n==null){
            return null;
        }
        while (n.left!=null){
            n=n.left;
        }
        return n;
    }

    public static boolean checkBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int leftchild= Integer.MIN_VALUE;
        while (!stack.empty() || root !=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(root.data<=leftchild){
                return false;
            }
            leftchild=root.data;
            root=root.right;
        }
        return true;
    }
}
