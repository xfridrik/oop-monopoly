package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
//inicializacia balika kariet a hracich policok
public class PlayingBoard {
    private final Field[] board;

    public PlayingBoard() {

        ArrayList<ChanceCard> cards = new ArrayList<>();
        ArrayList<ChanceCard> usedCards = new ArrayList<>();
        cards.add(new ChanceCard(3,0,0,0));
        cards.add(new ChanceCard(1,10000,0,0));
        cards.add(new ChanceCard(0,0,3,0));
        cards.add(new ChanceCard(0,40000,0,0));
        cards.add(new ChanceCard(0,0,0,30000));
        cards.add(new ChanceCard(0,0,0,15000));

        board = new Field[24];
        board[0]=new CornerField(CornerTypes.START);
        board[6]=new CornerField(CornerTypes.PRISON);
        board[12]=new CornerField(CornerTypes.PAYOUT);
        board[18]=new CornerField(CornerTypes.POLICE);

        board[1]=new PropertyField(5000,500);
        board[2]=new PropertyField(15000,1000);
        board[3]=new PropertyField(15000,1000);
        board[5]=new PropertyField(25000,4500);
        board[8]=new PropertyField(16000,1100);
        board[9]=new PropertyField(35000,5000);
        board[10]=new PropertyField(30000,4900);
        board[11]=new PropertyField(25000,4500);
        board[13]=new PropertyField(50000,7500);
        board[14]=new PropertyField(40000,8500);
        board[16]=new PropertyField(70000,10000);
        board[17]=new PropertyField(39000,8000);
        board[19]=new PropertyField(100000,15000);
        board[20]=new PropertyField(200000,33000);
        board[21]=new PropertyField(90000,11000);
        board[23]=new PropertyField(300000,40000);

        board[4]=new ChanceField(cards, usedCards);
        board[7]=new ChanceField(cards, usedCards);
        board[15]=new ChanceField(cards, usedCards);
        board[22]=new ChanceField(cards, usedCards);
    }

    public Field[] getBoard() {
        return board;
    }
    public void getBoardPositions(){
        System.out.println("ROZLOZENIE HRACEJ PLOCHY:");
        int pos=0;
        for (Field field:board){
            if (field instanceof CornerField){
                System.out.println("pozicia "+ConsoleColors.CYAN_BRIGHT+pos+ConsoleColors.RESET+" policko "+ConsoleColors.YELLOW_BRIGHT+((CornerField) field).getType()+ConsoleColors.RESET);
            }
            if (field instanceof ChanceField){
                System.out.println("pozicia "+ConsoleColors.CYAN_BRIGHT+pos+ConsoleColors.RESET+" policko"+ConsoleColors.RED+" SANCA"+ConsoleColors.RESET);
            }
            if (field instanceof PropertyField){
                System.out.println("pozicia "+ConsoleColors.CYAN_BRIGHT+pos+ConsoleColors.RESET+" policko"+ConsoleColors.BLUE_BOLD+" PROPERTY"+ConsoleColors.RESET);
            }
            pos++;
        }
        System.out.println("____________________");
    }
}
