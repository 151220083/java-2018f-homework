public class Calabash extends Creature {
    public Huluwa huluwa;
    Calabash(Huluwa huluwa) {
        setName("娃");
        setType(1);
        this.huluwa = huluwa;
    }

    @Override
    public void Print() {
        huluwa.ColorOff();
    }
}
