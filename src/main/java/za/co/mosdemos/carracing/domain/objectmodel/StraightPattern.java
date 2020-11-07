package za.co.mosdemos.carracing.domain.objectmodel;

public class StraightPattern implements CarScorePolicy {

    @Override
    public double score(Car car) {
        return car.getAcceleration()+car.getTopSpeed();
    }
}
