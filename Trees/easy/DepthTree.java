
import java.util.*;

public class DepthTree {
    static class TreeNode{
        TreeNode right;
        TreeNode left;
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
        int [] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        TreeNode root = buildTree(arr);
        int result = depth(root);
        System.out.println(result);
    }
    public static TreeNode buildTree(int [] arr){
        if(arr.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while(i<arr.length){
            TreeNode current = queue.poll();

            if(i<arr.length){
                current.left = new TreeNode(arr[i++]);
                queue.offer(current.left);
            }

            if(i<arr.length){
                current.right = new TreeNode(arr[i++]);
                queue.offer(current.right);
            }
        }
        return root;
    }
    public static int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = depth(root.left)+1;
        int r = depth(root.right)+1;

        return Math.max(l, r);
    }
}
