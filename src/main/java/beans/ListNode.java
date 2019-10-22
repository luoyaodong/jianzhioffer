package beans;

import java.util.List;

/**
 * Created by yaodongluo on 2018/7/9.
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
    public ListNode(){
    }

    public ListNode constructFromArray(int val[]){
        if(val.length == 0){
            return null;
        }
        ListNode head = new ListNode(val[0]);
        ListNode node = head;
        for(int i=1;i<val.length;i++){
            head.next = new ListNode(val[i]);
            head = head.next;

        }
        return node;
    }
    public void printList(){
        ListNode oldhead = this;
        ListNode head = oldhead;
        while (head.next!=null){
            System.out.println(head.val);
            head = head.next;
        }
        if(head.next==null){
            System.out.println(head.val);
        }
        head = oldhead;
    }

}
