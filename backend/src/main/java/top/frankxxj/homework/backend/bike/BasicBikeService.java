package top.frankxxj.homework.backend.bike;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.frankxxj.homework.backend.ride.RideRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BasicBikeService implements BikeService {
    private final BikeRepository bikeRepository;
    private final RideRepository rideRepository;

    @Override
    public void reportBroken(UUID bikeId) {
        bikeRepository.findById(bikeId).ifPresent(bike -> {
            if (!bike.getIsEnabled()) {
                throw new RuntimeException("Bike is already broken");
            }
            bike.setIsEnabled(false);
            bikeRepository.save(bike);
        });
    }

    @Override
    public void reportFixed(UUID bikeId) {
        bikeRepository.findById(bikeId).ifPresent(bike -> {
            if (bike.getIsEnabled()) {
                throw new RuntimeException("Bike is already fixed");
            }
            bike.setIsEnabled(true);
            bikeRepository.save(bike);
        });
    }

    @Override
    public List<Bike> findAll() {
        return bikeRepository.findAll();
    }

    @Override
    public Bike findById(UUID bikeId) {
        return bikeRepository.findById(bikeId).orElse(null);
    }
}
