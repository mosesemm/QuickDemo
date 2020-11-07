package za.co.mosdemos.carracing.application.repository;

import za.co.mosdemos.carracing.domain.objectmodel.RaceTrack;

import java.util.List;

public interface ITrackConfigurationRepository {
    List<RaceTrack> loadTracks();
}
