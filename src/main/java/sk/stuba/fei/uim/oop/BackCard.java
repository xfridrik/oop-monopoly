package sk.stuba.fei.uim.oop;
//hrac v dalsom kole zacina o backFields policok dozadu
public class BackCard extends ChanceCard{
    private final int backFields;

    public BackCard(int backFields) {
        this.backFields = backFields;
    }

    @Override
    public void chanceAction(Player player) {
        System.out.println("-UTEK! Buduce kolo zacinas o "+backFields+" policka blizsie k startu");
        player.positionUpdate(-backFields);
    }
}
