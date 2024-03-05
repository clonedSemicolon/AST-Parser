class Sample extends AbstractExample {
    @Override
    void abstractMethod1() {
        System.out.println("Implementation of method1");
    }

    @Override
    String abstractMethod2(int value) {
        return "Implementation of method2 with value: " + value;
    }

    @Override
    void concreteMethod() {}

    void printMethods(){
        System.out.println("This is a printing method demo");
    }
}