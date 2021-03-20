package sk.stuba.fei.uim.oop;

public class StartField extends Field{
    @Override
    public void action(Player player) {
        System.out.println("Hrac "+player.getName()+" je na starte, zostatok na ucte: "+player.getAccountBalance());
    }
}
