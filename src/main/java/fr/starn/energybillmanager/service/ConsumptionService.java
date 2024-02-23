package fr.starn.energybillmanager.service;

import fr.starn.energybillmanager.entity.Client;
import fr.starn.energybillmanager.entity.DailyConsumption;
import fr.starn.energybillmanager.entity.Price;

import java.util.Date;
import java.util.List;

public interface ConsumptionService {
    List<DailyConsumption> getDailyConsumption(Client client, Date startDate, Date endDate);
    double getCost(Price price, List<DailyConsumption> dailyConsumptions);
}
