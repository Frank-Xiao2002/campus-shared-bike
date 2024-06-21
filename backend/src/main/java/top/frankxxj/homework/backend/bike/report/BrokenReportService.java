package top.frankxxj.homework.backend.bike.report;

import java.util.UUID;

public interface BrokenReportService {
    void reportBroken(UUID bikeId);

    void reportFixed(UUID bikeId);
}
