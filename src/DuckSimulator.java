// 6510405792 Vimudakorn Kittechapanich
public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulate = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
//        AbstractDuckFactory duckFactory = new CountingPoliteDuckFactory();
//        simulate.simulate();
//        simulate.simulate(duckFactory);
        simulate.simulateCompositeLeader();
    }
//    void simulate() {
//        Quackable mallardDuck = new QuackCounter(new PoliteQuackDecorator(new MallardDuck()));
//        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
//        Quackable duckCall = new DuckCall();
//        Quackable rubberDuck = new QuackCounter(new RubberDuck());
//        Quackable goose = new PoliteQuackDecorator(new GooseAdapter(new Goose()));
//        Quackable pigeon = new PigeonAdapter(new Pigeon());
//
//        System.out.println("\nDuck Simulator");
//        mallardDuck.quack();
//        redheadDuck.quack();
//        duckCall.quack();
//        rubberDuck.quack();
//        goose.quack();
//        pigeon.quack();
//
//        System.out.println("\nNumber of Quack" + QuackCounter.countQuack);
//    }

    void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        System.out.println("\nDuck Simulator: With Abstract Factory");

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();
        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();
        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);
        flockOfDucks.add(flockOfMallards);

        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);

        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        simulate(flockOfMallards);
        System.out.println("\nThe ducks quacked " + QuackCounter.countQuack + " times");

//        simulate(mallardDuck);
//        simulate(redheadDuck);
//        simulate(duckCall);
//        simulate(rubberDuck);
//        simulate(gooseDuck);

        System.out.println("\nThe ducks quacked " + QuackCounter.countQuack + " times");
    }
    private void simulateCompositeLeader() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = countingDuckFactory.createDuckCall();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();

        LeaderFlock flock = new LeaderFlock();
        flock.add(mallardDuck);
        flock.add(redHeadDuck);
        flock.add(duckCall);
        flock.add(rubberDuck);

        flock.quack();
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}