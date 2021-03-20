package sk.stuba.fei.uim.oop;

public class PoliceField extends Field{
    @Override
    public void action(Player player) {
        System.out.println("Hraca "+player.getName()+" chytila policia a stravi 3 tahy vo vazeni! ");
        player.goPrison(3);
    }
}
