package top.frankxxj.homework.backend.bike.report;

import jakarta.persistence.*;
import lombok.*;
import top.frankxxj.homework.backend.bike.Bike;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "broken_report")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrokenReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "report_time", nullable = false)
    @Builder.Default
    private LocalDateTime reportTime = LocalDateTime.now();

    @ManyToOne(optional = false)
    @JoinColumn(name = "bike_id", nullable = false)
    private Bike bike;

    @Column(name = "is_fixed", nullable = false)
    @Builder.Default
    private Boolean isFixed = false;

    @Column(name = "fixed_time")
    private LocalDateTime fixedTime;

}