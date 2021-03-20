package sk.stuba.fei.uim.oop;

public class PayoutField extends Field{
    @Override
    public void action(Player player) {
        System.out.println("DEN ZUCTOVANIA! Hrac "+player.getName()+ConsoleColors.RED+" musi zaplatit $20000!"+ConsoleColors.RESET);
        player.payFromBalance(20000);
    }
}
