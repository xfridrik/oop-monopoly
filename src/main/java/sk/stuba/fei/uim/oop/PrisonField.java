package sk.stuba.fei.uim.oop;

public class PrisonField extends Field{
    @Override
    public void action(Player player) {
        System.out.println("Hrac "+player.getName()+" je na navsteve vo vazeni");
    }
}
