package shuffleCard;

/**
 * Created by yaodongluo on 2018/7/12.
 */
public class Card {

    public String num;
    public String suit;

    Card(String num, String suit){
        this.num = num;
        this.suit = suit;
    }
    public String toString()
    {
        String ss=suit+":"+num+"  ";
        return ss;
    }

}
