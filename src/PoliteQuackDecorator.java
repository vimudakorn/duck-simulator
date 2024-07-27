// 6510405792 Vimudakorn Kittechapanich
public class PoliteQuackDecorator implements Quackable{
    Quackable duck;

    public PoliteQuackDecorator(Quackable duck) {
        this.duck = duck;
    }
    @Override
    public void quack() {
        duck.quack();
        System.out.print(" ka");
    }
}
