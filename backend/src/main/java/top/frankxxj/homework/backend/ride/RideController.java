package top.frankxxj.homework.backend.ride;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/ride")
@RequiredArgsConstructor
public class RideController {
    private final RideService rideService;

    @PostMapping("/start")
    public void startRide(@RequestBody RideDto dto) {
        rideService.startRide(dto);
    }

    @PostMapping("/end")
    public void endRide(@RequestParam UUID id) {
        rideService.endRide(id);
    }

    @GetMapping("/stats")
    public Map<Integer, Long> getStats(@RequestParam(required = false) LocalDate date) {
        return rideService.getStats(date);
    }
}
