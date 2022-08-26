package TreePracticePackge;

public class MinimalTree {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        TreeNode treeNode1 = createMinimalTree(arr);
        treeNode1.inOrderTraversal();
    }


    public static TreeNode createMinimalTree(int [] array){
        return createMinimalTree(array,0,array.length-1);
    }

    public static TreeNode createMinimalTree(int [] array, int start,int end){
        if(start>end){
            return null;
        }
        int m = (start+end)/2;
        TreeNode n= new TreeNode(array[m]);
        n.left = createMinimalTree(array,start,m-1);
        n.right=createMinimalTree(array,m+1,end);
        return n;
    }

}
