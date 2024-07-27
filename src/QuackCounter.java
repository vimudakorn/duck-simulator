// 6510405792 Vimudakorn Kittechapanich
public class QuackCounter implements Quackable {
    Quackable duck;
    static int countQuack = 0;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }
    @Override
    public void quack() {
        duck.quack();
        countQuack++;
    }
}
