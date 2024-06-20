package top.frankxxj.homework.backend.ride;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link Ride}
 */
public record RideDto(UUID userId, UUID bikeId) implements Serializable {
}