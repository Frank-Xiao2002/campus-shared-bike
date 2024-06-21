package top.frankxxj.homework.backend.bike.report;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/broken")
@RequiredArgsConstructor
public class BrokenController {
    private final BrokenReportService brokenReportService;

    @PostMapping("/{bikeId}")
    public void reportBroken(@PathVariable UUID bikeId) {
        brokenReportService.reportBroken(bikeId);
    }

    @PutMapping("/{bikeId}")
    public void reportFixed(@PathVariable UUID bikeId) {
        brokenReportService.reportFixed(bikeId);
    }
}
