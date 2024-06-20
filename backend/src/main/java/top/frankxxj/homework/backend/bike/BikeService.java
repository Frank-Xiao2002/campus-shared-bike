package top.frankxxj.homework.backend.bike;

import top.frankxxj.homework.backend.ride.RideDto;

import java.util.List;
import java.util.UUID;

public interface BikeService {
    void reportBroken(UUID bikeId);

    void reportFixed(UUID bikeId);

    List<Bike> findAll();

    Bike findById(UUID bikeId);
}
