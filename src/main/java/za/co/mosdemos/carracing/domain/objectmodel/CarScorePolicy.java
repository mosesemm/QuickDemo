package za.co.mosdemos.carracing.domain.objectmodel;

import za.co.mosdemos.carracing.domain.objectmodel.Car;

public interface CarScorePolicy {
    double score(Car car);
}
