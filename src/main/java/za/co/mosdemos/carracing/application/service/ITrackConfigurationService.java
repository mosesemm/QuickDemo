package za.co.mosdemos.carracing.application.service;

import za.co.mosdemos.carracing.domain.objectmodel.RaceTrack;

import java.util.List;

public interface ITrackConfigurationService {
    List<RaceTrack> loadTracks();
}
