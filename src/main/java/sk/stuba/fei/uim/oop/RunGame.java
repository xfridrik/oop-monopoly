package sk.stuba.fei.uim.oop;

public class RunGame {
    private int gameover;
    private Player[] players;
    private ChanceCard[] chanceDeck;
    private int lap=0;
    private int numOfPlayers;
    private final PlayingBoard board;
    private Player winner;

    public RunGame() {
        while (numOfPlayers<2){
            numOfPlayers=KeyboardInput.readInt(ConsoleColors.WHITE_BACKGROUND+ConsoleColors.BLACK_BOLD+"Vitaj v hre MonopolyLite! Zadaj pocet hracov"+ConsoleColors.RESET);}
        gameover=numOfPlayers;
        playerInitialize();
        board=new PlayingBoard();
        play();
    }

    private void playerInitialize(){
        players=new Player[numOfPlayers];
        for (int i=0;i<numOfPlayers;i++){
            String name=KeyboardInput.readString(ConsoleColors.YELLOW_BRIGHT+"Zadaj meno hraca "+i+ConsoleColors.RESET);
            players[i]=new Player(name,i);
        }
        winner=players[0];

    }

    private void play(){
        while(gameover>1){
            lap++;
            for(Player player:players){
                if(player.getplayerStatus()){ //kontrola prehry
                    if(player.newMove()){ //kontrola vazenia
                        int throwNum=4;//player.diceThrow();
                        player.positionThrow(throwNum);
                        System.out.println(ConsoleColors.BLUE_BOLD+"Tah "+lap+". Hrac "+player.getName()+" hodil "+throwNum+" a je na pozicii "+player.getPosition()+ConsoleColors.RESET);
                        board.getBoard()[player.getPosition()].action(player);
                        System.out.println(ConsoleColors.BLUE_BOLD+"Hrac "+player.getName()+" skoncil tah, zostatok na ucte: "+player.getAccountBalance()+ConsoleColors.RESET);
                        gameover=0;
                        for(Player inGamePlayer:players){
                            if(inGamePlayer.getplayerStatus()){
                                gameover++;
                                winner=inGamePlayer;
                            }
                        }
                        if(!(gameover>1)){
                            break;
                        }
                        else {
                            String accept = KeyboardInput.readString(ConsoleColors.CYAN_BRIGHT + "Stlac enter pre pokracovanie..." + ConsoleColors.RESET);
                            System.out.println("-------------------");
                        }
                    }
                }
            }
        }
        System.out.println(ConsoleColors.GREEN_BOLD+"\nKONIEC HRY! VITAZOM SA STAVA HRAC: "+winner.getName());
    }
}
