package top.frankxxj.homework.backend.bike;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "bike")
@NoArgsConstructor
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "is_enabled", nullable = false)
    private Boolean isEnabled = true;

    @Column(name = "is_being_used", nullable = false)
    private Boolean isBeingUsed = false;

    public Bike(UUID id) {
        this.id = id;
    }
}