package top.frankxxj.homework.backend.ride;

import jakarta.persistence.*;
import lombok.*;
import top.frankxxj.homework.backend.bike.Bike;
import top.frankxxj.homework.backend.security.user.User;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "ride")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bike_id", nullable = false)
    private Bike bike;

    @Column(name = "start")
    @Builder.Default
    private LocalDateTime start = LocalDateTime.now();

    @Column(name = "end")
    private LocalDateTime end;

    @Column(name = "distance")
    @Builder.Default
    private Double distance = 0.0;

    @Column(name = "is_finished")
    @Builder.Default
    private Boolean isFinished = false;

}