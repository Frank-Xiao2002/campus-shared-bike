package top.frankxxj.homework.backend.bike.report;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrokenReportRepository extends JpaRepository<BrokenReport, UUID> {
    BrokenReport findByBike_IdAndIsFixed(UUID id, Boolean isFixed);
}