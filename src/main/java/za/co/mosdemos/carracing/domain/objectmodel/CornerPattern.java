package za.co.mosdemos.carracing.domain.objectmodel;

public class CornerPattern implements CarScorePolicy{
    @Override
    public double score(Car car) {
        return car.getBraking() + car.getCornerAbility();
    }
}
