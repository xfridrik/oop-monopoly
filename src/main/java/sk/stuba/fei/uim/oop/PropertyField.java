package sk.stuba.fei.uim.oop;

public class PropertyField extends Field{
    private Property property;

    public PropertyField(int price, int visitFee,int pos) {
        property=new Property(price, visitFee);
        super.setPosition(pos);
        super.setType(4);
    }

  /*  public boolean buyField (Player player) {
        return (property.buy(player));
    }
    public int payFee(Player player){
        return property.getFee();
    }*/
    public  void  action(Player player){
        if(this.property.getOccupiedStatus()){
            if(player.getPlayerID()==this.property.getOwner().getPlayerID()){
                System.out.println("Hrac je na vlastnom pozemku");
            }
            else{
                System.out.println(ConsoleColors.PURPLE+"Musis aplatit poplatok za vstup "+this.property.getFee()+" hracovi "+this.property.getOwner().getName()+ConsoleColors.RESET);
                player.payFromBalance(this.property.getFee(),this.property.getOwner());
                System.out.println("Hrac "+player.getName()+" zaplatil. Zostatok na ucte:"+player.getAccountBalance());
            }
        }
        else if(player.getAccountBalance()>=this.property.getPrice()){
            System.out.println("Hrac "+player.getName()+" moze kupit property za "+this.property.getPrice()+". Zostatok na ucte:"+player.getAccountBalance());
            String accept=KeyboardInput.readString("zadaj 'yes' pre nakup, nieco ine pre nekupenie nehnutelnosti");
            if (accept.compareTo("yes")==0){
                if(this.property.buy(player)){
                    System.out.println(ConsoleColors.GREEN+"USPESNY NAKUP!"+ConsoleColors.RESET);
                    System.out.println("Hrac "+player.getName()+" nakupil. Zostatok na ucte:"+player.getAccountBalance());
                }
                else {
                    System.out.println(ConsoleColors.RED+"TRANSAKCIA NEPREBEHLA!"+ConsoleColors.RESET);
                    System.out.println("Zostatok na ucte:"+player.getAccountBalance());
                }
            }
        }
        else {
            System.out.println(ConsoleColors.RED+"Nemozes vykonat ziadne akcie, nemas dost penazi pre kupu"+ConsoleColors.RESET);
        }
    }
}
