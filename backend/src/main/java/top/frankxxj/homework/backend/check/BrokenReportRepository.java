package top.frankxxj.homework.backend.check;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrokenReportRepository extends JpaRepository<BrokenReport, UUID> {
}