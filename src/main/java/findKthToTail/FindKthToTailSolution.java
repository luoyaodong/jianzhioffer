package findKthToTail;

import beans.ListNode;

/**
 * Created by yaodongluo on 2018/7/9.
 */
public class FindKthToTailSolution {
    public ListNode FindKthToTail(ListNode head, int k){
        if(head == null) return head;
        ListNode node = head;
        int length = 0;
        while (node!=null){
            node = node.next;
            length++;
        }
        if(length<k) return null;
        node = head;
        for(int i = 0;i<length-k;i++){
            node = node.next;
        }
        return node;
//        ListNode tail = head.next;
//        head.next = null;
//        while (tail!=null){
//            ListNode r = tail.next;
//            tail.next = head.next;
//            head.next = tail;
//            tail = r;
//        }
//        for(int i=0;i<k;i++){
//            head=head.next;
//        }
//        return head;
    }
    public static void main(String args[]){

        int[] array = {1,2,3,4,5};
        ListNode head = new ListNode();
        head = head.constructFromArray(array);
        //head.printList(head);

        FindKthToTailSolution solution = new FindKthToTailSolution();
        System.out.println(solution.FindKthToTail(head,1).val);

    }
}
