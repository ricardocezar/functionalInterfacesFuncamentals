package chapter1.LongProblems;

@FunctionalInterface
interface Area {
    default int numberOfSides(){
        return 4;
    }

    double compute(double x);
}

class Circle implements Area {
    @Override
    public double compute(double x) {
        return 3.14d * Math.pow(x, 2d);
    }

    @Override
    public int numberOfSides() {
        return 1;
    }
}

class Square implements Area {
    @Override
    public double compute(double x) {
        return x * x;
    }
}

class IsoscelesTriangulo implements Area {

    @Override
    public double compute(double x) {
        return (x * x) / 2;
    }

    @Override
    public int numberOfSides() {
        return 3;
    }
}

public class ex02 {
    public static void main(String[] args) {
        Area circle = new Circle();
        System.out.println(circle.compute(3));

        Area square = new Square();
        System.out.println(square.compute(3));

        Area triangle = new IsoscelesTriangulo();
        System.out.println(triangle.compute(3));
    }
}
