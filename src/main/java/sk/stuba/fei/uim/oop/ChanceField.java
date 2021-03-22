package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

//used cards su karty ktore uz boli v hre, ak sa cards minu used cards sa do nich presunu a vymazu
public class ChanceField extends Field{
    private final ArrayList <ChanceCard> cards;
    private final ArrayList <ChanceCard> usedCards;

    public ChanceField(ArrayList <ChanceCard> cards, ArrayList <ChanceCard> usedCards) {
        this.cards=cards;
        this.usedCards=usedCards;
    }
    //uskutocni kombinaciu akcii podla atributov karty
    @Override
    public void action(Player player){
        if(cards.isEmpty()){
            cards.addAll(usedCards);
            usedCards.clear();
        }
        System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"-SANCA! Karta:"+(6-cards.size()));
        cards.get(0).chanceAction(player);
        System.out.println(ConsoleColors.RESET);
        usedCards.add(cards.get(0));
        cards.remove(0);

    }
}
