package za.co.mosdemos.carracing.application.repository;

import org.springframework.stereotype.Repository;
import za.co.mosdemos.carracing.domain.objectmodel.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CarConfigurationRepository implements ICarConfigurationRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Car> loadCars() {
        return em.createQuery("SELECT c FROM Car c", Car.class).getResultList();
    }
}
