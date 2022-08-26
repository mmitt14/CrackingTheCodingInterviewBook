package TreePracticePackge;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public int size=1;


    TreeNode(int data){
        this.data=data;
    }

    public TreeNode insert(int value){
        size++;
        if(value<=data){
            if(left==null){
                left=new TreeNode(value);
                return left;
            }
            else return left.insert(value);
        }

        else{
            if(right==null){
                right= new TreeNode(value);
                return right;
            }

            else return right.insert(value);
        }


    }

    public boolean contains(int value){
        if(value==data){
            return true;
        }
        else if(value<data){
            if(left==null){
                return false;
            }
            else {
                return left.contains(value);
            }
        }
        else{
            if(right==null){
                return false;
            }
            else {
                return right.contains(value);
            }
        }

    }

    public void inOrderTraversal(){
        if(left!=null){
            left.inOrderTraversal();
        }
        System.out.print(this.data+" ");
        if(right!=null){
            right.inOrderTraversal();
        }
    }

    public void preOrderTraversal(){
        System.out.print(this.data+" ");
        if(left!=null){
            left.inOrderTraversal();
        }
        if(right!=null){
            right.inOrderTraversal();
        }
    }
}

    class TreeNodeRunner{

        public static void main(String[] args) {
            TreeNode treeNode = new TreeNode(10);
            treeNode.insert(4);
            treeNode.insert(15);
            treeNode.insert(20);
            treeNode.insert(7);
            treeNode.insert(2);
            treeNode.inOrderTraversal();
            System.out.println();
            treeNode.preOrderTraversal();
            System.out.println(treeNode.contains(25));
        }



}
