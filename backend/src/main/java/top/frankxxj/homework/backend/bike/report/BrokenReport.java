package top.frankxxj.homework.backend.bike.report;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import top.frankxxj.homework.backend.bike.Bike;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "broken_report")
public class BrokenReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "time", nullable = false)
    private LocalDateTime time = LocalDateTime.now();

    @ManyToOne(optional = false)
    @JoinColumn(name = "bike_id", nullable = false)
    private Bike bike;

    @Column(name = "is_fixed", nullable = false)
    private Boolean isFixed = false;

}