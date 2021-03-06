package za.co.mosdemos.carracing.application.repository;

import org.springframework.data.repository.CrudRepository;
import za.co.mosdemos.carracing.domain.objectmodel.RaceTrack;

//Trying out new springboot features
public interface TrackConfigurationRepository extends CrudRepository<RaceTrack, Long> {
}
