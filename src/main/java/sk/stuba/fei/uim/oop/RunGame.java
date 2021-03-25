package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class RunGame {
    private int activePlayers;
    private ArrayList<Player> players;
    private int lap;
    private int numOfPlayers;
    private final PlayingBoard board;
    private Player winner;

    //Nacita pocet hracov vacsi ako 1 a inicializuje hracov a hraciu plochu
    public RunGame() {
        System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"Vitaj v hre MonopolyLite!"+ConsoleColors.RESET);
        while (numOfPlayers<2 || numOfPlayers>6){
            numOfPlayers=Zklavesnice.readInt("Zadaj pocet hracov [2-6]");
        }
        activePlayers =numOfPlayers;
        playerInitialize();
        board=new PlayingBoard();
        board.printBoardPositions();
        play();
    }

    //Vytvori objekty pre hracov a umozni zadat meno
    private void playerInitialize(){
        players =new ArrayList<>();
        for (int i=0;i<numOfPlayers;i++){
            String name=Zklavesnice.readString(ConsoleColors.YELLOW_BRIGHT+"Zadaj meno hraca "+i+ConsoleColors.RESET);
            players.add(new Player(name,i));
        }
        winner= players.get(0);
    }

    //kontroluje podmienky - viac aktivnych hracov ako 1, ci hrac neprehral alebo nie je vo vazeni - potom aktualizuje poziciu a vykona action na danom policku
    private void play(){
        while(activePlayers >1){
            lap++;
            for(Player player: players){ //prechadzanie cez hracov
                if(player.getPlayerStatus()){ //kontrola prehry
                    if(player.newMove()){ //kontrola vazenia

                        int throwNum=player.diceThrow();
                        player.positionUpdate(throwNum);

                        System.out.println(ConsoleColors.BLUE_BOLD+"Tah "+lap+". Hrac "+player.getName()+" hodil "+throwNum+" a je na pozicii "+player.getPosition()+ConsoleColors.RESET);
                        board.getBoard()[player.getPosition()].action(player);
                        System.out.println(ConsoleColors.BLUE_BOLD+"Hrac "+player.getName()+" skoncil tah, zostatok na ucte: $"+player.getAccountBalance()+ConsoleColors.RESET);

                        activePlayers = 0;
                        for(Player inGamePlayer: players){
                            if(inGamePlayer.getPlayerStatus()){
                                activePlayers++;
                                winner=inGamePlayer;
                            }
                        }
                        if(activePlayers<=1){
                            break;
                        }
                        else {
                            Zklavesnice.readString(ConsoleColors.CYAN_BRIGHT + "Stlac enter pre pokracovanie..." + ConsoleColors.RESET);
                            System.out.println("-------------------");
                        }
                    }
                }
            }
        }
        System.out.println(ConsoleColors.GREEN_BOLD+"\nKONIEC HRY! VITAZOM SA STAVA HRAC: "+winner.getName());
    }
}
