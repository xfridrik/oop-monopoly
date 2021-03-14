package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class PlayingBoard {
    Field[] board;

    public PlayingBoard() {

        ArrayList<ChanceCard> cards = new ArrayList<>();
        ArrayList<ChanceCard> usedCards = new ArrayList<>();
        cards.add(new ChanceCard(3,25000,0,0));
        cards.add(new ChanceCard(1,2000,0,0));
        cards.add(new ChanceCard(0,0,3,0));
        cards.add(new ChanceCard(0,5000,0,0));
        cards.add(new ChanceCard(0,0,0,3000));
        cards.add(new ChanceCard(0,0,0,150));
        //System.out.println(cards.length);
        board = new Field[24];
        board[0]=new Field(0,0);
        board[6]=new Field(6,1);
        board[12]=new Field(12,2);
        board[18]=new Field(18,3);

        board[1]=new PropertyField(5000,50,1);
        board[2]=new PropertyField(15000,450,2);
        board[3]=new PropertyField(15000,450,3);
        board[5]=new PropertyField(15000,450,5);
        board[8]=new PropertyField(15000,450,8);
        board[9]=new PropertyField(15000,450,15);
        board[10]=new PropertyField(15000,450,10);
        board[11]=new PropertyField(15000,450,11);
        board[13]=new PropertyField(15000,450,13);
        board[14]=new PropertyField(15000,450,14);
        board[16]=new PropertyField(15000,450,16);
        board[17]=new PropertyField(15000,450,17);
        board[19]=new PropertyField(15000,450,19);
        board[20]=new PropertyField(15000,450,20);
        board[21]=new PropertyField(15000,450,21);
        board[23]=new PropertyField(15000,450,23);

        board[4]=new ChanceField(4,5,cards, usedCards);
        board[7]=new ChanceField(7,5,cards, usedCards);
        board[15]=new ChanceField(15,5,cards, usedCards);
        board[22]=new ChanceField(22,5,cards, usedCards);
    }

    public Field[] getBoard() {
        return board;
    }
}
