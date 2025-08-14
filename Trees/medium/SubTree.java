
import java.util.*;


public class SubTree {
    static class TreeNode{
        int val;
        TreeNode right;
        TreeNode left;
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
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        int n1 = sc.nextInt();
        int [] arr1 = new int[n1];
        for(int i=0;i<n1;i++){
            arr1[i]= sc.nextInt();
        }
        TreeNode root = buildTree(arr);
        TreeNode subroot = buildTree(arr1);

        boolean result = issub(root, subroot);
        System.out.println(result);
    }
    public static TreeNode buildTree(int []arr){
        if(arr.length==0){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i =1;

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
    public static boolean issub(TreeNode root, TreeNode subroot){
        if(root == null) return false;
        if(root.val == subroot.val){
            if(ifsub(root, subroot)){
                return true;
            }
        }
        return issub(root.right, subroot)|| issub(root.left, subroot);
    }
    public static boolean ifsub(TreeNode root, TreeNode subroot){
        if(root == null  && subroot==null){
            return true;
        }
        if(root==null || subroot==null || root.val!=subroot.val){
            return false;
        }
        if(!ifsub(root.left, subroot.left)){
            return false;
        }
        if(!ifsub(root.right, subroot.right)){
            return false;
        }
        return true;
    }
    
}
