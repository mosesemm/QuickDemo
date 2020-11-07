package za.co.mosdemos.carracing.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import za.co.mosdemos.carracing.application.service.IRacingGameService;
import za.co.mosdemos.carracing.domain.objectmodel.Car;
import za.co.mosdemos.carracing.domain.objectmodel.CarScore;
import za.co.mosdemos.carracing.domain.objectmodel.RaceTrack;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class CarRacingRunner implements CommandLineRunner {

    @Autowired
    private IRacingGameService racingGameService;

    private static Logger logger = LoggerFactory.getLogger(CarRacingRunner.class);

    @Override
    public void run(String... args) throws Exception {

        try {

            logger.info("Starting to run car racing game");
            Scanner scanner = new Scanner(System.in);

            System.out.println("List of tracks: ");

            Optional<List<RaceTrack>> optionalRaceTracks = Optional.ofNullable(racingGameService.getRaceTracks());

            //validate track list and display
            optionalRaceTracks
                    .orElseThrow(() -> new RuntimeException("No race tracks available"))
                    .stream()
                    .forEach((track) -> System.out.println(String.format("%d (%s) - %s", track.getId(), track.getName(), track.getPatterns())));

            System.out.println("Choose track (id): ");
            String trackId = scanner.next();

            //validate track id
            if(optionalRaceTracks.get()
                    .stream().noneMatch(track -> track.getId() == new Long(trackId))) {
                throw new IllegalArgumentException("Can only choose track ids appearing on the list");
            };

            Optional<List<Car>> optionalCars = Optional.ofNullable(racingGameService.getCars());

            //validate car list and display
            optionalCars
                    .orElseThrow(() -> new RuntimeException("No cars available"))
                    .stream()
                    .forEach(car ->
                            System.out.println(String.format("%d (%s) - acceleration (%d), bracking (%d), Cornering ability (%d), Top speed (%d)",
                                    car.getId(), car.getName(), car.getAcceleration(), car.getBraking(), car.getCornerAbility(), car.getTopSpeed())));

            System.out.println("Press any key to begin");

            System.in.read();

            System.out.println("And the race begins");

            //TODO: move this with validation of

            RaceTrack raceTrack = optionalRaceTracks.get().stream().filter(track -> track.getId() == new Long(trackId)).findFirst().get();

            Optional<List<CarScore>> carScores = Optional.ofNullable(racingGameService.startRace(optionalCars, Optional.ofNullable(raceTrack.getPatterns())));

            System.out.println("Winners: ");

            //TODO: will be nice to show indexes as well
            carScores
                    .orElseThrow(() -> new IllegalStateException("Unexpected error, scores cannot be empty after race"))
                    .stream()
                    .forEach(carScore -> System.out.println(String.format("%d (%s) - %f",
                            carScore.getCar().getId(), carScore.getCar().getName(), carScore.getScore())));

            logger.info("Finished to run car racing game");

            System.exit(0);

        }
        catch (Exception ex) {
            logger.error("Error occurred running car racing game", ex);
            System.exit(1);
        }
    }
}
