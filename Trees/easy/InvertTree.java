
import java.util.*;

public class InvertTree {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val = x;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int [n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        TreeNode root = buildTree(arr);
        TreeNode result = inversion(root);


        // PRINT THE TREE

        Queue<TreeNode> queue = new LinkedList<>();
        if(result != null){
            queue.offer(result);
        }
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            
            for(int i=0;i< levelSize;i++){
                TreeNode curr = queue.poll();
                System.out.print(curr.val + " ");

                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                }
            }
        }
        
    }
    public static TreeNode buildTree(int [] arr){
        if(arr.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i=1;

        while(i<arr.length){
            TreeNode curr = queue.poll();

            if(i<arr.length){
                curr.left = new TreeNode(arr[i++]);
                queue.offer(curr.left);
            }
            if(i<arr.length){
                curr.right = new TreeNode(arr[i++]);
                queue.offer(curr.right);

            }
        }
        return root;
    }
    public static TreeNode inversion(TreeNode root){
        if(root == null){
            return null;
        }
        inversion(root.left);
        inversion(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
