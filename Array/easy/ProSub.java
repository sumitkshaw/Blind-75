import java.util.*;

public class ProSub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for(int i=0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        int result = Subpro(arr);
        System.out.println(result);
        sc.close();
    }
    public static int Subpro(int [] nums){
        int left = 1;
        int right = 1;
        int maxPro = nums[0];
        int n = nums.length;

        for(int i=0; i<nums.length;i++){
            left *= nums[i];
            right *= nums[n-i-1];

            maxPro = Math.max(maxPro, (Math.max(left, right)));
        }
        if(left ==0){
            left = 1;
        }
        if(right == 0){
            right =1;
        }

        return maxPro;
    }
}
