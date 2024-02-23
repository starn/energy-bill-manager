package fr.starn.energybillmanager.service;

import fr.starn.energybillmanager.entity.Client;
import fr.starn.energybillmanager.entity.DailyConsumption;
import fr.starn.energybillmanager.entity.Price;
import fr.starn.energybillmanager.repository.DailyConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ConsumptionServiceImpl implements ConsumptionService {
    @Autowired
    DailyConsumptionRepository dailyConsumptionRepository;

    @Override
    public double getCost(Price price, List<DailyConsumption> dailyConsumptions) {
        return dailyConsumptions.stream()
                .map((cons) ->
                    new BigDecimal(cons.getConsoKWH())
                            .multiply( new BigDecimal(String.valueOf(cons.isGaz() ? price.getPriceGaz() : price.getPriceElectricity())))
                )
                .reduce(BigDecimal::add).orElse(new BigDecimal(0)).doubleValue();
    }

    public List<DailyConsumption> getDailyConsumption(Client client, Date startDate, Date endDate){
        List<DailyConsumption> dailyConsumptions = dailyConsumptionRepository
                .findAllByClientIdAndConsumptionDateLessThanEqualAndConsumptionDateGreaterThanEqual(
                        client.getId(),
                        endDate,
                        startDate
                );
        return dailyConsumptions;
    }
}
