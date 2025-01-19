package pl.sp6pat.qsl.manager.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(schema = "qsl", name = "qsl_cards_to_pickup")
public class QslCardsToPickup extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    public String callsign;

    @Column(nullable = false)
    public Long qty;

    @Column(name = "last_updated", nullable = false)
    public LocalDateTime lastUpdated;

    @Column(nullable = false)
    public Boolean collected;

    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        this.lastUpdated = LocalDateTime.now();
    }

}
