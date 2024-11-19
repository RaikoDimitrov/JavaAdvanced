package com.company.DefiningClasses.CarConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            Car car;
            if (carData.length == 1) {
                car = new Car(carData[0]);
            } else {
                car = new Car(carData[0], carData[1], Integer.parseInt(carData[2]));
            }
            cars.add(car);
        }
        cars.forEach(car -> System.out.print(car.toString()));
    }
}
