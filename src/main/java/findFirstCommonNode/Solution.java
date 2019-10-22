package findFirstCommonNode;

import beans.ListNode;

/**
 * Created by yaodongluo on 2018/9/18.
 */
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        while (pHead1!=null){
            ListNode tempHead2 = pHead2;
            while(tempHead2!=null){
                if(tempHead2 == pHead1){
                    return pHead1;
                }
                tempHead2 = tempHead2.next;
            }
            pHead1 = pHead1.next;
        }
        return null;
    }


}
