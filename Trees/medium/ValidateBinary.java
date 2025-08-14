
import java.util.*;


public class ValidateBinary {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            left = null;
            right = null;
            val = x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        TreeNode root = buildTree(arr);
        boolean result = val(root);
        System.out.println(result);
    }
    public static TreeNode buildTree(int [] arr){
        if(arr.length ==0){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i=1;
        
        while(!queue.isEmpty() && i<arr.length){
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
    public static boolean val(TreeNode root){
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static boolean validate(TreeNode root, long left, long right){
        if(root == null){
            return true;
        }
        if(root.val>=right || root.val<=left){
            return false;
        }
        return validate(root.left, left, root.val) && validate(root.right, root.val, right);
    }
}
