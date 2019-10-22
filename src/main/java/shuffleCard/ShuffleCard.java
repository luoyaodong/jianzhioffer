package shuffleCard;

import java.util.*;

/**
 * Created by yaodongluo on 2018/7/12.
 */
public class ShuffleCard {
    List<String> listCards = new ArrayList<String>();
    Card cards[] = new Card[52];
    public void initCard(){
        String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] suit = {"方块","梅花","红桃","黑桃"};
        for(int i=0;i<52;i++){
            cards[i] = new Card(num[i%13],suit[i/13]);
        }
    }

    public void shuffleCard(){
        for (Card c:cards
             ) {
            listCards.add(c.toString());
        }
        Collections.shuffle(listCards);
    }

    public void diliverCard(){
        Iterator<String> iterable = listCards.iterator();
        while (iterable.hasNext()){
            System.out.print(iterable.next());
        }
        for(int i=0;i<52;i++)
        {
            if(i%4==0) System.out.println("\n");
            System.out.print(listCards.get(i));
        }
    }

}
