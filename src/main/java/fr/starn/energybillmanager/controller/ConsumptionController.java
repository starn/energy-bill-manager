package fr.starn.energybillmanager.controller;

import fr.starn.energybillmanager.dto.CostDTO;
import fr.starn.energybillmanager.entity.Client;
import fr.starn.energybillmanager.entity.DailyConsumption;
import fr.starn.energybillmanager.entity.Price;
import fr.starn.energybillmanager.repository.PriceRepository;
import fr.starn.energybillmanager.service.ClientService;
import fr.starn.energybillmanager.service.ConsumptionService;
import fr.starn.energybillmanager.utils.CalendarUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/consumption")
public class ConsumptionController {
    @Autowired
    ClientService clientService;

    @Autowired
    CalendarUtils calendarUtils;

    @Autowired
    ConsumptionService consumptionService;

    //I know i should NOT do that
    @Autowired
    PriceRepository priceRepository;

    @GetMapping("/{clientId}/{year}/{month}")
    public CostDTO getMonthlyCost(
            @PathVariable("clientId") long clientId,
            @PathVariable("year") int year,
            @PathVariable("month") int month){

        Client client = clientService.get(clientId);
        Price price = priceRepository.findFirstBy(client);

        // do not forget month -1 because the API use month between 1 and 31
        Date startDate = calendarUtils.getFirstDayOfMonth(month - 1, year);
        Date endDate = calendarUtils.getLastDayOfMonth(month - 1, year);

        List<DailyConsumption> dailyConsumptions = consumptionService.getDailyConsumption(client, startDate, endDate);

        double cost = consumptionService.getCost(price, dailyConsumptions);
        return new CostDTO(clientId, startDate, endDate, cost);
    }


}
