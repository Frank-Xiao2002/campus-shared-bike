package top.frankxxj.homework.backend.ride;

import java.util.UUID;

public interface RideService {
    void startRide(RideDto dto);

    void endRide(UUID rideId);
}
