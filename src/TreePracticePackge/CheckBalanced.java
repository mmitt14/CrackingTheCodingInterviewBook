package TreePracticePackge;

public class CheckBalanced {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(20);
        treeNode.insert(25);
        treeNode.insert(15);
        treeNode.insert(10);
        treeNode.insert(18);
//        treeNode.insert(5);
        System.out.println(isBalancedBinaryTree(treeNode));

    }

    public static boolean isBalancedBinaryTree(TreeNode root){

        return checkHeight(root)!=Integer.MIN_VALUE;
    }

    public static int checkHeight(TreeNode root){
        if(root==null){
            return -1;
        }
        int left = checkHeight(root.left);
        if(left==Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int right= checkHeight(root.right);
        if(right==Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int diff = left-right;
        if(Math.abs(diff)>1){
            return Integer.MIN_VALUE;
        }
        else {
            return Math.max(left,right) +1;
        }


    }
}
