
import java.util.Scanner;

public class nthRemove {
    static class Node{
        int data;
        Node next;
        Node(int x){
            data = x;
            next = null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        int pos = sc.nextInt();

        for(int i=0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        Node head = arrtoLL(arr);
        Node result = remove(head, pos);
        while(result!=null){
            System.out.print(result.data + " ");
            result = result.next;
        }


    }
    public static Node arrtoLL(int [] arr){
        if(arr.length == 0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i=1;i<arr.length;i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = temp.next;
        }
        return head;
    }
    public static Node remove(Node head, int pos){
        Node fast = head;
        Node slow = head;
        for(int i=0;i<pos;i++){
            fast = fast.next;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    } 
}
