package sk.stuba.fei.uim.oop;
/*Trieda obsahuje udaje o hracovi*/

public class Player {
    private int playerID; //ID (poradie hraca)
    private boolean playerStatus=true; //ak dany hrac prehra - false
    private int accountBalance; //stav uctu
    private int prisonMoves=0;
    private int position=0; //pozicia v poli
    private String name; //meno
    //private Property[] properties; //Nehnutelnosti hraca

    public Player(String name, int playerID) {
        this.name=name;
        this.playerID=playerID;
        accountBalance=20000;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getName() {
        return name;
    }

    //hadze kockou a posuva sa
    public int positionThrow(int throwNum){
        if (throwNum>0){
            System.out.println("Na tahu je hrac "+ConsoleColors.BLUE_UNDERLINED+getName()+ConsoleColors.RESET);
        }
        this.position=(this.position+throwNum);
        if (this.position > 23){
            this.position=this.position%24;
            newLap();
        }
        return position;
    }

    public int diceThrow(){
        return (int)(Math.random()*6) + 1;

    }

    public int getAccountBalance() {
        return accountBalance;
    }
    public int getPosition() {
        return position;
    }
    public boolean buyFromBalance(int price){
        if (price>accountBalance){
            return false;
        }
        accountBalance=accountBalance-price;
        return true;
    }
    //platba dani
    public void payFromBalance(int price){
        accountBalance=accountBalance-price;
        if(accountBalance<0){
            System.out.println(ConsoleColors.RED_BOLD+"Hrac "+name+" nema dost penazi a prehral!"+ConsoleColors.RESET);
            this.playerStatus=false;
        }
    }
    //platba hracovi
    public void payFromBalance(int price,Player player){
        accountBalance=accountBalance-price;
        if(accountBalance<0){
            player.receiveCredit(price+accountBalance);
            System.out.println(ConsoleColors.RED_BOLD+ConsoleColors.WHITE_BACKGROUND_BRIGHT+"Hrac "+name+" nema dost penazi a prehral!"+ConsoleColors.RESET);
            this.playerStatus=false;
        }
        else{
            player.receiveCredit(price);
        }
    }
    public void receiveCredit(int value){
        this.accountBalance=this.accountBalance+value;
    }
    public boolean getplayerStatus(){
        return playerStatus;
    }
    public void goPrison(int moves){
        this.position=6;
        prisonMoves=prisonMoves+moves;
    }
    //tah hraca, ak je vo vazeni - false inak true
    public boolean newMove(){
        if (prisonMoves>0){
            prisonMoves--;
            return false;
        }
        return true;
    }
    //Prechod startom
    public void newLap(){
        accountBalance=accountBalance+1000;
        System.out.println(ConsoleColors.GREEN+"Hrac dostal +1000 za prechod startom"+ConsoleColors.RESET);
    }
   // public void newProperty(Property prop)
}
