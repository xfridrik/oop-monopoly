package sk.stuba.fei.uim.oop;
//hrac stravi days kol vo vazeni alebo zaplati fee
public class PrisonCard extends ChanceCard{
    private final int days;
    private final int fee;

    public PrisonCard(int days, int fee) {
        this.days = days;
        this.fee = fee;
    }

    @Override
    public void chanceAction(Player player) {
        if(player.getAccountBalance()>=fee) {
            System.out.println("-DANOVE PODVODY! Ides do vazenia na pocet dni: "+days+" alebo zaplatis pokutu $"+fee+ConsoleColors.RESET);
            String accept = Zklavesnice.readString("zadaj '" + ConsoleColors.GREEN + "yes" + ConsoleColors.RESET + "' pre zaplatenie pokuty, nieco ine pre vazbu");
            if (accept.compareTo("yes") == 0) {
                player.payFromBalance(fee);
            } else {
                player.goPrison(days);
            }
        }
        else{
            System.out.println("-DANOVE PODVODY! Ides do vazenia na pocet dni: "+days+" pretoze NEMAS rozpocet na pokutu- $"+fee+ConsoleColors.RESET);
            player.goPrison(days);
        }
    }
}