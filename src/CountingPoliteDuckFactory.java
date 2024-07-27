// 6510405792 Vimudakorn Kittechapanich
public class CountingPoliteDuckFactory extends AbstractDuckFactory{

    @Override
    public Quackable createMallardDuck() {
        return new PoliteQuackDecorator(new QuackCounter(new MallardDuck()));
    }

    @Override
    public Quackable createRedheadDuck() {
        return new PoliteQuackDecorator(new QuackCounter(new RedheadDuck()));
    }

    @Override
    public Quackable createDuckCall() {
        return new PoliteQuackDecorator(new QuackCounter(new DuckCall()));
    }

    @Override
    public Quackable createRubberDuck() {
        return new PoliteQuackDecorator(new QuackCounter(new RedheadDuck()));
    }
}