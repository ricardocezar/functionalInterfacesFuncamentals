package chapter2;

@FunctionalInterface
interface Summer<X> {
    X sum(X a, X b);
}

public class ex02 {
    public static void main(String[] args) {
        Summer<Integer> integerSummer = (a, b) -> a + b;
        Summer<Double> doubleSummer = (a, b) -> a + b;
        Summer<Long> longSummer = (a, b) -> a + b;
        
        System.out.println(integerSummer.sum(2, 3));
        System.out.println(doubleSummer.sum(2d, 3d));
        System.out.println(longSummer.sum(2L, 3L));
    }
}
