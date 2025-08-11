
import java.util.HashMap;
import java.util.Scanner;

class ContainsDupli{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        boolean result = duplicate(arr);
        System.out.println(result);
        sc.close();
    }
    public static boolean duplicate(int arr[]){
        HashMap<Integer,Integer> hp = new HashMap<>();
        int n = arr.length;
        for(int i=0; i<n;i++){
            if(hp.containsKey(arr[i])){
                return true;
            }
            else{
                hp.put(arr[i], i);
            }
        }
        return false;
    }
}