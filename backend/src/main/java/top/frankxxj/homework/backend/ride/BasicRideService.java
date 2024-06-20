package top.frankxxj.homework.backend.ride;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import top.frankxxj.homework.backend.bike.Bike;
import top.frankxxj.homework.backend.bike.BikeRepository;
import top.frankxxj.homework.backend.user.User;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BasicRideService implements RideService {
    private final BikeRepository bikeRepository;
    private final RideRepository rideRepository;

    @Override
    public void startRide(RideDto dto) {
        bikeRepository.findById(dto.bikeId()).ifPresent(bike -> {
            if (bike.getIsBeingUsed()) {
                throw new RuntimeException("Bike is already being used");
            }
            bike.setIsBeingUsed(true);
            rideRepository.save(Ride.builder()
                    .user(new User(dto.userId()))
                    .start(LocalDateTime.now())
                    .bike(new Bike(dto.bikeId())).build());
            bikeRepository.save(bike);
            log.info("Ride started for bike {} & user {}", dto.bikeId(), dto.userId());
        });
    }

    @Override
    public void endRide(UUID bikeId) {
        bikeRepository.findById(bikeId).ifPresent(bike -> {
            if (!bike.getIsBeingUsed()) {
                throw new RuntimeException("Bike is not being used");
            }
            rideRepository.findFirstByBike_IdOrderByStartDesc(bikeId).ifPresent(ride -> {
                Assert.isNull(ride.getEnd(), "Ride is already ended");
                ride.setEnd(LocalDateTime.now());
                rideRepository.save(ride);
            });
            bike.setIsBeingUsed(false);
            bikeRepository.save(bike);
            log.info("Ride ended for bike {}", bikeId);
        });
    }
}
