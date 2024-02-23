package fr.starn.energybillmanager.repository;

import fr.starn.energybillmanager.entity.DailyConsumption;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface DailyConsumptionRepository extends CrudRepository<DailyConsumption, Long> {

    List<DailyConsumption> findAllByClientIdAndConsumptionDateLessThanEqualAndConsumptionDateGreaterThanEqual(long clientId, Date endDate, Date startDate);
}
