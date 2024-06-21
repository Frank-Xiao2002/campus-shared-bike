package top.frankxxj.homework.backend.ride;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RideRepository extends JpaRepository<Ride, UUID> {
    Optional<Ride> findFirstByBike_IdOrderByStartDesc(UUID id);

    List<Ride> findByStartBetweenOrderByStartAsc(LocalDateTime startStart, LocalDateTime startEnd);
}