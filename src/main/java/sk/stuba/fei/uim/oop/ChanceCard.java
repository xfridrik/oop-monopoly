package sk.stuba.fei.uim.oop;

public class ChanceCard {
    private final int prisonDays;
    private final int fee;
    private final int back;
    private final int credit;

    public ChanceCard(int prisonDays, int fee, int back, int credit) {
        this.prisonDays = prisonDays;
        this.fee = fee;
        this.back = back;
        this.credit = credit;
    }

    public int getPrisonDays() {
        return prisonDays;
    }

    public int getFee() {
        return fee;
    }

    public int getBack() {
        return back;
    }

    public int getCredit() {
        return credit;
    }
}
