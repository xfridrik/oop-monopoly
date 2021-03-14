package sk.stuba.fei.uim.oop;

public class Field {
    private int position;
    private int type; //0=start,1=VAZENIE,2=Platba dani, 3=policia, 4=property field, 5=sanca

    public Field() {}

    public Field(int position, int type) {
        this.position = position;
        this.type = type;
    }

    public void setPosition(int pos){ position=pos; }
    public void setType(int type){
            this.type=type;
    }

    public int getType() {
        return type;
    }

    //public boolean buyField(Player player){return false;};
    //public int payFee(Player player){return 0;};
    public void action(Player player){
        switch (type){
            case 0:
                System.out.println("Hrac "+player.getName()+" je na starte, zostatok na ucte: "+player.getAccountBalance());
                break;
            case 1:
                System.out.println("Hrac "+player.getName()+" je na navsteve vo vazeni");
                break;
            case 2:
                System.out.println("DEN ZUCTOVANIA! Hrac "+player.getName()+" musi zaplatit 2000!");
                player.payFromBalance(2000);
                break;
            case 3:
                System.out.println("Hraca "+player.getName()+" chytila policia a stravi 3 tahy vo vazeni! ");
                player.goPrison(3);
                break;
            default:
                System.out.println("Fatal error");
                break;
        }
    };
}

