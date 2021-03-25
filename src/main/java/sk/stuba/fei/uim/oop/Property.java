package sk.stuba.fei.uim.oop;

public class Property {
    private final int price;
    private boolean occupied;
    private Player owner;
    private final int visitFee;

    public Property(int price, int visitFee) {
        this.price = price;
        this.visitFee = visitFee;
    }

    public Player getOwner() {
        return owner;
    }

    public int getFee(){
        if (owner.getPlayerStatus()){
            return visitFee;
        }
        return 0;
    }
    public int getPrice() {
        return price;
    }
    public boolean getOccupiedStatus(){
        if(occupied){
            //ked hrac prehral
            if (!owner.getPlayerStatus()){
                occupied=false;
            }
        }
        return occupied;
    }
    public boolean buy(Player buyer){
        if (buyer.getAccountBalance() >= price) {
            if (buyer.buyFromBalance(price)) {
                this.owner = buyer;
                occupied=true;
                return true;
            }
        }
        return false;
    }
}
