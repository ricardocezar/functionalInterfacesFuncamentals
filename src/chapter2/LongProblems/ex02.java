package chapter2.LongProblems;

import java.time.LocalDate;
import java.time.Month;

class Car {
    int odometer;
    LocalDate manufacturingDate;
    Double originalValue;

    public Car(int odometer, LocalDate manufatoringDate, Double originalValue){
        this.odometer = odometer;
        this.manufacturingDate = manufatoringDate;
        this.originalValue = originalValue;
    }

    public int getOdometer(){
        return odometer;
    }

    public LocalDate getManufacturingDate(){
        return manufacturingDate;
    }

    public Double getOriginalValue(){
        return originalValue;
    }
}

@FunctionalInterface
interface ListValue {
    private Double getDepreciationByYear(Car car){
        return ( LocalDate.now().getYear() - car.getManufacturingDate().getYear() ) * 1000D;
    }
    private Double getDepreciationByMiles(Car car){
        return Math.abs(car.getOdometer() / 10000) * 500D;
    }

    default Double calculateDepreciation (Car car){
        return getDepreciationByYear(car) + getDepreciationByMiles(car);
    }

    Double compute(Car car);
}

public class ex02 {
    private static Double getDepreciationByYear(Car car){
        return ( LocalDate.now().getYear() - car.getManufacturingDate().getYear() ) * 1000D;
    }
    private static Double getDepreciationByMiles(Car car){
        return Math.abs(car.getOdometer() / 10000) * 500D;
    }

    private static Double calculateDepreciation (Car car){
        return getDepreciationByYear(car) + getDepreciationByMiles(car);
    }

    private static Double calculateVintageFactor(Car car){
        return ( LocalDate.now().getYear() - car.getManufacturingDate().getYear() ) * 250D;
    }

    public static void main(String[] args) {
        ListValue typical = car -> car.getOriginalValue() - calculateDepreciation(car);
        ListValue sport = car -> car.getOriginalValue() - calculateDepreciation(car) + calculateVintageFactor(car);

        Car a = new Car(60000, LocalDate.of(1990, Month.JANUARY, 1), 65000D);
        Double value = typical.compute(a);
        System.out.println(value);

        value = sport.compute(a);
        System.out.println(value);
    }
}
