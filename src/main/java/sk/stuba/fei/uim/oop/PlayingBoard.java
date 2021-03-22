package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
//inicializacia balika kariet a hracich policok
public class PlayingBoard {
    private final Field[] board;

    public PlayingBoard() {

        ArrayList<ChanceCard> cards = new ArrayList<>();
        ArrayList<ChanceCard> usedCards = new ArrayList<>();
        cards.add(new PrisonCard(3,15000));
        cards.add(new FeeCard(40000));
        cards.add(new CreditCard(10000));
        cards.add(new BackCard(3));
        cards.add(new PrisonCard(2,10000));
        cards.add(new FeeCard(15000));

        board = new Field[24];
        board[0]=new StartField();
        board[6]=new PrisonField();
        board[12]=new PayoutField();
        board[18]=new PoliceField();

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
    public void printBoardPositions(){
        System.out.println("ROZLOZENIE HRACEJ PLOCHY:");
        int pos=0;
        for (Field field:board){
            if (field instanceof PropertyField){
                System.out.println("pozicia "+ConsoleColors.CYAN_BRIGHT+pos+ConsoleColors.RESET+" policko"+ConsoleColors.RED+" MAJETOK"+ConsoleColors.RESET);
            }
            else if (field instanceof ChanceField){
                System.out.println("pozicia "+ConsoleColors.CYAN_BRIGHT+pos+ConsoleColors.RESET+" policko"+ConsoleColors.BLUE_BOLD+" SANCA"+ConsoleColors.RESET);
            }
            else if (field instanceof StartField){
                System.out.println("pozicia "+ConsoleColors.CYAN_BRIGHT+pos+ConsoleColors.RESET+" policko"+ConsoleColors.YELLOW_BRIGHT+" START"+ConsoleColors.RESET);
            }
            else if (field instanceof PoliceField){
                System.out.println("pozicia "+ConsoleColors.CYAN_BRIGHT+pos+ConsoleColors.RESET+" policko"+ConsoleColors.YELLOW_BRIGHT+" POLICIA"+ConsoleColors.RESET);
            }
            else if (field instanceof PrisonField){
                System.out.println("pozicia "+ConsoleColors.CYAN_BRIGHT+pos+ConsoleColors.RESET+" policko"+ConsoleColors.YELLOW_BRIGHT+" VAZENIE"+ConsoleColors.RESET);
            }
            else if (field instanceof PayoutField){
                System.out.println("pozicia "+ConsoleColors.CYAN_BRIGHT+pos+ConsoleColors.RESET+" policko"+ConsoleColors.YELLOW_BRIGHT+" PLTABA DANI"+ConsoleColors.RESET);
            }
            pos++;
        }
        System.out.println("____________________");
    }
}
