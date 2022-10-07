package chapter1;

@FunctionalInterface
interface Summer<X> {
    X sum(X a, X b);
}

public class ex02 {
    public static void main(String[] args) throws Exception {
        Summer integerSummer = new Summer<Integer>() {
            @Override
            public Integer sum(Integer a, Integer b) {
                return a + b;
            }
        };

        Summer doubleSummer = new Summer<Double>() {
            @Override
            public Double sum(Double a, Double b) {
                return a + b;
            }
        };

        Summer longSummer = new Summer<Long>() {
            @Override
            public Long sum(Long a, Long b) {
                return a + b;
            }
        };

        System.out.println(integerSummer.sum(2, 3));
        System.out.println(doubleSummer.sum(2d, 3d));
        System.out.println(longSummer.sum(2L, 3L));
    }
}
