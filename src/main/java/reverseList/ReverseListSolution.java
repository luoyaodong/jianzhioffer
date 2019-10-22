package reverseList;

import beans.ListNode;

/**
 * Created by yaodongluo on 2018/7/10.
 */
public class ReverseListSolution {
    public ListNode ReverseList(ListNode head){
//带头结点的链表翻转
//        ListNode tail = head.next;
//        ListNode r = null;
//        head.next =null;
//        while (tail!=null){
//            r = tail.next;
//            tail.next = head.next;
//            head.next = tail;
//            tail = r;
//        }
//        return head;
//        不带头结点的链表翻转
//
        if(head==null){
            return null;
        }

        ListNode r = head.next;
        head.next =null;

        while (r!=null){
            ListNode temp = r.next;
            r.next = head;
            head = r;
            r=temp;
        }
        return head;

    }
    public static void main(String args[]){
        int[] array = {1,2,3,4,5};
        ListNode head = new ListNode();
        head = head.constructFromArray(array);
        head.printList();
        ReverseListSolution solution = new ReverseListSolution();
        head = solution.ReverseList(head);
        head.printList();

    }
}
