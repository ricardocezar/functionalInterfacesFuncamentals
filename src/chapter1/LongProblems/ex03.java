package chapter1.LongProblems;

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

class TypicalCarValue implements ListValue{

    @Override
    public Double compute(Car car) {
        return car.getOriginalValue() - calculateDepreciation(car);
    }
}

class SportsCarValue implements ListValue {
    private Double calculateVintageFactor(Car car){
        return ( LocalDate.now().getYear() - car.getManufacturingDate().getYear() ) * 250D;
    }

    @Override
    public Double compute(Car car) {
        return car.getOriginalValue() - calculateDepreciation(car) + calculateVintageFactor(car);
    }
}

public class ex03 {
    public static void main(String[] args) {
        ListValue typicalCar = new TypicalCarValue();
        Double value = typicalCar.compute(new Car(60000, LocalDate.of(1990, Month.JANUARY, 1), 65000D));
        System.out.println(value);

        ListValue sportsCar = new SportsCarValue();
        value = sportsCar.compute(new Car(60000, LocalDate.of(1990, Month.JANUARY, 1), 65000D));
        System.out.println(value);
    }
}
