package sk.stuba.fei.uim.oop;

public class CornerField extends Field {
    CornerTypes type;
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
                System.out.println("DEN ZUCTOVANIA! Hrac "+player.getName()+" musi zaplatit 20000!");
                player.payFromBalance(20000);
                break;
            case POLICE:
                System.out.println("Hraca "+player.getName()+" chytila policia a stravi 3 tahy vo vazeni! ");
                player.goPrison(3);
                break;
            default:
                System.out.println("Policko neexistuje");
                break;
        }
    }
}
