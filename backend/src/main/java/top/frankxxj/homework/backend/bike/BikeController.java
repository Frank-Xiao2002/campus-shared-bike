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

    @GetMapping
    public ResponseEntity<?> findAvailable(@RequestParam Double longitude, @RequestParam Double latitude) {
        return ResponseEntity.ok(bikeService.findNearbyAvailable(longitude, latitude));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(bikeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Bike> create() {
        return ResponseEntity.ok(bikeService.create());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        bikeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
