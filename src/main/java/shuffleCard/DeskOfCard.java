package shuffleCard;

import java.util.Random;

/**
 * Created by yaodongluo on 2018/7/12.
 */
public class DeskOfCard {
    Card card[];
    public void initCard(){
        String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] suit = {"方块","梅花","红桃","黑桃"};
        card = new Card[52];
        for(int i=0;i<52;i++)
        {
            card[i] = new Card(num[i%13],suit[i/13]);
        }
    }
        public void shuffleCard(){
            Random random = new Random();
            for(int i=0;i<52;i++){
                int j = random.nextInt(52);
                Card temp = card[i];
                card[i] = card[j];
                card[j] = temp;
            }
    }
    public void dealCard()//发牌
    {
        for(int i=0;i<52;i++)
        {
            if(i%4==0) System.out.println("\n");
            System.out.print(card[i]);
        }
    }

}
