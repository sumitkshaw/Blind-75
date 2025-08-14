
import java.util.*;

public class sameTree {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val= x;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int [] arr1 = new int[n1];
        for(int i=0;i<arr1.length;i++){
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int [] arr2 = new int[n2];
        for(int i=0;i<arr2.length;i++){
            arr2[i] = sc.nextInt();
        }
        TreeNode root1 = buildTree(arr1);
        TreeNode root2 = buildTree(arr2);
        boolean result = same(root1 , root2);
        System.out.println(result);

    }
    public static TreeNode buildTree(int [] arr){
        if(arr.length==0){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        
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
    public static boolean same(TreeNode root1, TreeNode root2){
        if(root1 == null && root2==null){
            return true;
        }

        if(root1!=null && root2!=null && root1.val == root2.val){
            return same(root1.left, root2.left) && same(root1.right, root2.right);
        }
        return false;
    }
}
