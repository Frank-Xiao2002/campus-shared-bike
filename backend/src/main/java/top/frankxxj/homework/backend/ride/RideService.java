package top.frankxxj.homework.backend.ride;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

public interface RideService {
    void startRide(RideDto dto);

    void endRide(UUID bikeId);

    Map<Integer, Long> getStats(LocalDate date);
}
