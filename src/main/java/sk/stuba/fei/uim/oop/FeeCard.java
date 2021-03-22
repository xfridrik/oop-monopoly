package sk.stuba.fei.uim.oop;
//hrac zaplati fee
public class FeeCard extends ChanceCard{
    private final int fee;

    public FeeCard(int fee) {
        this.fee = fee;
    }

    @Override
    public void chanceAction(Player player) {
        System.out.println("-DLZIS PENIAZE! Musis zaplatit $"+fee);
        player.payFromBalance(fee);
    }
}