package top.frankxxj.homework.backend.bike;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BasicBikeService implements BikeService {
    private final BikeRepository bikeRepository;

    @Override
    public List<Bike> findNearbyAvailable(Double longitude, Double latitude) {
        Double longitudeStart = longitude - 0.01;
        Double longitudeEnd = longitude + 0.01;
        Double latitudeStart = latitude - 0.01;
        Double latitudeEnd = latitude + 0.01;
        return bikeRepository.findByLongitudeBetweenAndLatitudeBetween(longitudeStart, longitudeEnd, latitudeStart, latitudeEnd);
    }

    @Override
    public Bike findById(UUID bikeId) {
        return bikeRepository.findById(bikeId).orElse(null);
    }

    @Override
    public Bike create() {
        return bikeRepository.save(new Bike());
    }

    @Override
    public void delete(UUID bikeId) {
        bikeRepository.findById(bikeId).ifPresent(bike -> {
            bike.setIsEnabled(false);
            bike.setIsBeingUsed(false);
            bikeRepository.save(bike);
            log.info("Bike {} has been disabled", bikeId);
        });
    }

}
