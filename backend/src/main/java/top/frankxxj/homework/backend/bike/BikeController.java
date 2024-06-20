package top.frankxxj.homework.backend.bike;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/bike")
@RequiredArgsConstructor
public class BikeController {
    private final BikeService bikeService;

    @PostMapping("/report/{bikeId}/broken")
    public ResponseEntity<?> reportBroken(@PathVariable UUID bikeId) {
        bikeService.reportBroken(bikeId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/report/{bikeId}/fixed")
    public ResponseEntity<?> reportFixed(@PathVariable UUID bikeId) {
        bikeService.reportFixed(bikeId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(bikeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(bikeService.findById(id));
    }
}
