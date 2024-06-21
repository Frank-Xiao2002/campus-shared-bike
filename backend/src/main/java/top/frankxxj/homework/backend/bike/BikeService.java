package top.frankxxj.homework.backend.bike;

import java.util.List;
import java.util.UUID;

public interface BikeService {
    List<Bike> findNearbyAvailable(Double longitude, Double latitude);

    Bike findById(UUID bikeId);

    Bike create();

    void delete(UUID bikeId);
}
