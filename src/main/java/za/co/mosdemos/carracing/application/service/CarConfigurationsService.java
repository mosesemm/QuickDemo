package za.co.mosdemos.carracing.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.mosdemos.carracing.application.repository.ICarConfigurationRepository;
import za.co.mosdemos.carracing.domain.objectmodel.Car;

import java.util.List;

@Service
public class CarConfigurationsService implements ICarConfigurationsService {

    @Autowired
    private ICarConfigurationRepository carConfigurationRepository;

    @Override
    public List<Car> loadCars() {
        return carConfigurationRepository.loadCars();
    }
}
