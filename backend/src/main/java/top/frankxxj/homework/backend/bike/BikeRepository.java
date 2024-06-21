package top.frankxxj.homework.backend.bike;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BikeRepository extends JpaRepository<Bike, UUID> {
    List<Bike> findByLongitudeBetweenAndLatitudeBetween(Double longitudeStart, Double longitudeEnd, Double latitudeStart, Double latitudeEnd);
}