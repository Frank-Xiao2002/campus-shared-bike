package top.frankxxj.homework.backend.bike;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bike")
@RequiredArgsConstructor
public class BikeController {
    private final BikeService bikeService;

}
