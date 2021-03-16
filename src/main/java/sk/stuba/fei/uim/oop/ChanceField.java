package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Collections;

public class ChanceField extends Field{
    private ArrayList <ChanceCard> cards;
    private ArrayList <ChanceCard> usedCards;
    //private int cardIndex=0;

    public ChanceField(int type, ArrayList <ChanceCard> cards, ArrayList <ChanceCard> usedCards) { //pridat used cards
        this.cards=cards;
        this.usedCards=usedCards;
    }

    public void action(Player player){
        if(cards.isEmpty()){
            cards.addAll(usedCards);
            usedCards.clear();
        }
        System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"-SANCA! Karta:"+(6-cards.size()));
        if(cards.get(0).getPrisonDays()>0){
            System.out.println("-Ides do vazenia na pocet dni: "+cards.get(0).getPrisonDays());
            player.goPrison(cards.get(0).getPrisonDays());
        }
        if(cards.get(0).getBack()>0){
            System.out.println("-Vracias sa spat o "+cards.get(0).getBack());
            player.positionUpdate(-cards.get(0).getBack());
        }
        if(cards.get(0).getCredit()>0){
            System.out.println("-Ziskavas kredit "+cards.get(0).getCredit());
            player.receiveCredit(cards.get(0).getCredit());
        }
        if(cards.get(0).getFee()>0){
            System.out.println("-Musis zaplatit "+cards.get(0).getFee());
            player.payFromBalance(cards.get(0).getFee());
        }
        System.out.println(ConsoleColors.RESET);
        usedCards.add(cards.get(0));
        cards.remove(0);

    }
}
