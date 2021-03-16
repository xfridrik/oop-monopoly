package sk.stuba.fei.uim.oop;

public class PropertyField extends Field{
    private final Property property;

    public PropertyField(int price, int visitFee) {
        property=new Property(price, visitFee);
    }

    public  void  action(Player player){
        if(this.property.getOccupiedStatus()){
            if(player.getPlayerID()==this.property.getOwner().getPlayerID()){
                System.out.println("Hrac je na vlastnom pozemku");
            }
            else{
                System.out.println(ConsoleColors.PURPLE+"Musis zaplatit poplatok za vstup $"+this.property.getFee()+" hracovi "+this.property.getOwner().getName()+ConsoleColors.RESET);
                player.payFromBalance(this.property.getFee(),this.property.getOwner());
                System.out.println("Hrac "+player.getName()+" zaplatil. Novy zostatok na ucte: $"+player.getAccountBalance());
            }
        }
        else if(player.getAccountBalance()>=this.property.getPrice()){
            System.out.println("Hrac "+player.getName()+" moze kupit majetok za $"+this.property.getPrice()+". Zostatok na ucte: $"+player.getAccountBalance());
            String accept=Zklavesnice.readString("zadaj 'yes' pre nakup, nieco ine pre nekupenie nehnutelnosti");
            if (accept.compareTo("yes")==0){
                if(this.property.buy(player)){
                    System.out.println(ConsoleColors.GREEN+"USPESNY NAKUP!"+ConsoleColors.RESET);
                    System.out.println("Hrac "+player.getName()+" nakupil. Novy zostatok na ucte: $"+player.getAccountBalance());
                }
                else {
                    System.out.println(ConsoleColors.RED+"TRANSAKCIA NEPREBEHLA!"+ConsoleColors.RESET);
                    System.out.println("Zostatok na ucte: $"+player.getAccountBalance());
                }
            }
        }
        else {
            System.out.println("Hrac "+player.getName()+" vstupil na majetok za $"+this.property.getPrice()+". Zostatok na ucte: $"+player.getAccountBalance());
            System.out.println(ConsoleColors.RED+"Nemozes vykonat ziadne akcie, nemas dost penazi pre kupu!"+ConsoleColors.RESET);
        }
    }
}
