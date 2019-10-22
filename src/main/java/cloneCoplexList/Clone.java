package cloneCoplexList;

import beans.RandomListNode;

import javax.management.relation.RelationNotFoundException;

/**
 * Created by yaodongluo on 2018/7/24.
 */
public class Clone {
    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode tempHead = pHead;


        RandomListNode copyList = new RandomListNode(0);

        RandomListNode copyHead = copyList;

        while (tempHead!=null){
            copyHead.next = new RandomListNode(tempHead.label);
            copyHead = copyHead.next;
            tempHead = tempHead.next;
        }

        RandomListNode tempHead2 = pHead;
        RandomListNode copyHead2 = copyList;
        copyHead2 = copyHead2.next;

        while (tempHead2!=null){
            if(tempHead2.random!=null){
                RandomListNode tempHead3 = pHead;
                RandomListNode copyHead3 = copyList;
                copyHead3 = copyHead3.next;
                while (tempHead3!=null){
                    tempHead3 = tempHead3.next;
                    copyHead3 = copyHead3.next;
                    if(tempHead3==tempHead2.random){
                        copyHead2.random = copyHead3;
                    }
                }
            }
            tempHead2=tempHead2.next;
            copyHead2=copyHead2.next;
        }
        return copyList.next;
    }
}
