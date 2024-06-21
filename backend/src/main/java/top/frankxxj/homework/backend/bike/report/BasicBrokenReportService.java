package top.frankxxj.homework.backend.bike.report;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.frankxxj.homework.backend.bike.Bike;
import top.frankxxj.homework.backend.bike.BikeRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BasicBrokenReportService implements BrokenReportService {
    private final BrokenReportRepository repository;
    private final BikeRepository bikeRepository;

    @Override
    public void reportBroken(UUID bikeId) {
        bikeRepository.findById(bikeId).ifPresent(bike -> {
            if (bike.getIsBeingUsed()) {
                throw new RuntimeException("Bike is being used, please stop the ride first");
            }
            bike.setIsEnabled(false);
            bikeRepository.save(bike);
        });
        //create and save a new report
        var report = BrokenReport.builder()
                .bike(new Bike(bikeId))
                .build();
        repository.save(report);
    }

    @Override
    public void reportFixed(UUID bikeId) {
        //update the report
        var report = repository.findByBike_IdAndIsFixed(bikeId, false);
        report.setIsFixed(true);
        report.setFixedTime(LocalDateTime.now());
        repository.save(report);
        //correct the bike status
        bikeRepository.findById(bikeId).ifPresent(bike -> {
            bike.setIsEnabled(true);
            bikeRepository.save(bike);
        });
    }
}
