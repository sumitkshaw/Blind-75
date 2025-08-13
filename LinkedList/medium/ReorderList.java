
import java.util.Scanner;



public class ReorderList {
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
        for(int i=0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        Node head = arrtoLL(arr);
        Node result = reorder(head);
        while(result!=null){
            System.out.print(result.data + " ");
            result = result.next;
        }

    }
    public static Node arrtoLL(int []arr){
        if(arr.length == 0){
            return null;
        }
        int n = arr.length;
        Node newNode = new Node(arr[0]);
        Node temp = newNode;
        for(int i=1;i<n;i++){
            Node newN = new Node(arr[i]);
            temp.next = newN;
            temp = temp.next;
        }
        return newNode;
    }
    public static Node reorder(Node head){
        if(head == null){
            return null;
        }
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node curr = slow;
        Node prev = null;
        Node nextCurr = slow;
        while(curr!=null){
            nextCurr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextCurr;
        }
        Node first = head;
        Node second = prev;
        while(second.next!=null){
            Node temp1 = first.next;
            Node temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
        return head;
    }
    
}
