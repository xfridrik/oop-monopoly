package sk.stuba.fei.uim.oop;
//policka umiestnene v rohu, ktore maju iba vypis alebo jednoduchsiu logiku
public class CornerField extends Field {
    private final CornerTypes type;
    public CornerField(CornerTypes type) {
        this.type=type;
    }

    public void action(Player player){
        switch (type){
            case START:
                System.out.println("Hrac "+player.getName()+" je na starte, zostatok na ucte: "+player.getAccountBalance());
                break;
            case PRISON:
                System.out.println("Hrac "+player.getName()+" je na navsteve vo vazeni");
                break;
            case PAYOUT:
                System.out.println("DEN ZUCTOVANIA! Hrac "+player.getName()+ConsoleColors.RED+" musi zaplatit $20000!"+ConsoleColors.RESET);
                player.payFromBalance(20000);
                break;
            case POLICE:
                System.out.println("Hraca "+player.getName()+" chytila policia a stravi 3 tahy vo vazeni! ");
                player.goPrison(3);
                break;
        }
    }

    public CornerTypes getType() {
        return type;
    }
}
