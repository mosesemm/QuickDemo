package za.co.mosdemos.carracing.domain.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import za.co.mosdemos.carracing.BaseUnitTest;
import za.co.mosdemos.carracing.configurations.UnitTestConfiguration;
import za.co.mosdemos.carracing.domain.objectmodel.Car;
import za.co.mosdemos.carracing.domain.objectmodel.CarBuilder;
import za.co.mosdemos.carracing.domain.objectmodel.RaceTrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@Import(UnitTestConfiguration.class)
public class CarRacingServiceTests extends BaseUnitTest {

    private static List<Car> cars = new ArrayList<>();

    @Autowired
    private ICarRacingService carRacing;

    @BeforeAll
    public static void setup() {
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
    }

    @AfterAll
    public static void tearDown() {
        cars.clear();
    }

    @Test
    public void testStartSimpleCarRacing() {
        RaceTrack track = new RaceTrack("Example track", "11001");
        Optional<Map<Car, Double>> results = carRacing.start(Optional.of(cars), Optional.of(track.getPatterns()));
        assertThat(results.isPresent()).isTrue();
        assertThat(results.get().get(cars.stream().filter(car -> "CORV".equals(car.getName()))
                        .findFirst().get())).isEqualTo(new Double(65));
        assertThat(results.get().get(cars.stream().filter(car -> "GTR".equals(car.getName()))
                .findFirst().get())).isEqualTo(new Double(74));
    }
    @Test
    public void testStartCarRacingEmptyParams() {

        Optional<Map<Car, Double>> results = carRacing.start(Optional.ofNullable(null), Optional.ofNullable(null));
        assertThat(results.isPresent()).isTrue();
        assertThat(results.get().get(0)).isNull();

    }

    @Test
    public void testStartCarRacingWithoutRacingTrack() {

        Optional<Map<Car, Double>> results = carRacing.start(Optional.of(cars), Optional.ofNullable(null));
        assertThat(results.isPresent()).isTrue();
        assertThat(results.get().get(0)).isNull();

    }

    @Test
    public void testStartCarRacingWithoutCars() {
        RaceTrack track = new RaceTrack("Example track", "11001");
        Optional<Map<Car, Double>> results = carRacing.start(Optional.ofNullable(null), Optional.ofNullable(track.getPatterns()));
        assertThat(results.isPresent()).isTrue();
        assertThat(results.get().get(0)).isNull();
    }
}
