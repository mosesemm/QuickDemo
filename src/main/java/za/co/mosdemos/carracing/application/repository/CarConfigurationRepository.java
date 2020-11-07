package za.co.mosdemos.carracing.application.repository;

import org.springframework.stereotype.Repository;
import za.co.mosdemos.carracing.domain.objectmodel.Car;
import za.co.mosdemos.carracing.domain.objectmodel.CarBuilder;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarConfigurationRepository implements ICarConfigurationRepository{
    @Override
    public List<Car> loadCars() {
        List<Car> cars = new ArrayList<>();
        Car corv = new CarBuilder("CORV")
                .acceleration(8)
                .braking(3)
                .corneringAbility(4)
                .topSpeed(9)
                .build();
        Car gtr = new CarBuilder("GTR")
                .acceleration(6)
                .braking(7)
                .corneringAbility(9)
                .topSpeed(8)
                .build();
        cars.add(corv);
        cars.add(gtr);

        return cars;
    }
}
