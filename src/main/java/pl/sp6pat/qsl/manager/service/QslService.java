package pl.sp6pat.qsl.manager.service;

import jakarta.enterprise.context.ApplicationScoped;
import pl.sp6pat.qsl.manager.entity.QslCardsToPickup;

import java.util.List;

@ApplicationScoped
public class QslService {

    public List<QslCardsToPickup> toPickup(String call) {
        if (call == null) {
            return List.of();
        }
        return QslCardsToPickup.find("callsign ilike ?1 AND qty > 0 AND NOT collected ORDER BY lastUpdated DESC", call).list();
    }

}
