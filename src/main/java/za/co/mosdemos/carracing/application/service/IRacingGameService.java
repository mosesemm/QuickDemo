package za.co.mosdemos.carracing.application.service;

import za.co.mosdemos.carracing.domain.objectmodel.Car;
import za.co.mosdemos.carracing.domain.objectmodel.CarScore;
import za.co.mosdemos.carracing.domain.objectmodel.RaceTrack;

import java.util.List;
import java.util.Optional;

public interface IRacingGameService {
    List<RaceTrack> getRaceTracks();
    List<Car> getCars();
    List<CarScore> startRace(Optional<List<Car>> cars, Optional<String> trackPatterns);
}
