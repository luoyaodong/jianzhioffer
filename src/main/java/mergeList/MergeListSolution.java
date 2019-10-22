package mergeList;

import beans.ListNode;

/**
 * Created by yaodongluo on 2018/7/11.
 */
public class MergeListSolution {
    public ListNode Merge(ListNode list1, ListNode list2) {
//        这是段有问题的代码，在某些情况下不能够正确输出结果
        ListNode head = new ListNode();
        if(list1==null&&list2==null){
            return null;
        }
        if(list1==null&&list2!=null){
            head = list2;
            return head;
        }
        if(list1!=null&&list2==null){
            head = list1;
            return head;
        }
        ListNode dummy = head;
//        while ((list1.next!=null)||list2.next!=null){
//
//            ListNode post1 = list1.next;
//            ListNode post2 = list2.next;
//            if(list1.val<=list2.val){
//                if(list2.val<=post1.val){
//                    list1.next = list2;
//                    list1 = post1;
//                }else{
//                    list1 = post1;
//                }
//            }else {
//                if(list1.val<=post2.val){
//                    list2.next = list1;
//                    list2 = post2;
//                }else {
//                    list2 = post2;
//                }
//            }
//        }
//        if((list1.next==null)&&list2!=null){list1.next = list2;return head;}
//        else if ((list2.next==null)&&list1!=null){list2.next = list1;return head;}
//        else return head;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                head.next= list1;
                head = head.next;
                list1 = list1.next;

            }else {
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }
        }
        if(list1!=null&&list2==null){
            head.next = list1;
        }
        if(list2!=null&&list1==null){
            head.next = list2;
        }
        return dummy.next;
    }

    public static void main(String args[]) {
        int[] array = {1, 2, 3};
        ListNode list1 = new ListNode();
        list1 = list1.constructFromArray(array);
        list1.printList();
        int[] array2 = {2, 2, 3};
        ListNode list2 = new ListNode();
        list2 = list2.constructFromArray(array2);
        list2.printList();
        MergeListSolution solution = new MergeListSolution();
        ListNode node = solution.Merge(list1, list2);
        node.printList();
    }
}
