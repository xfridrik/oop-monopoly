package sk.stuba.fei.uim.oop;
//hrac dostane credit
public class CreditCard extends ChanceCard{
    private final int credit;

    public CreditCard(int credit) {
        this.credit = credit;
    }

    @Override
    public void chanceAction(Player player) {
        System.out.println("-LOTERIA! Vyhravas kredit $"+credit);
        player.receiveCredit(credit);
    }
}