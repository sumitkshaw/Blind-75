import java.util.*;
class Sum2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int [] nums = sum2(arr, target);
        System.out.println(Arrays.toString(nums));
        sc.close();
    }
    public static int[] sum2(int [] arr, int target){
        HashMap<Integer,Integer> hp = new HashMap<>();
        int n = arr.length;
        for(int i=0; i<n;i++){
            int complement = target - arr[i];
            if(hp.containsKey(complement)){
                return new int[]{hp.get(complement),i};
            }
            else{
                hp.put(arr[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}