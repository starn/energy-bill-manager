package fr.starn.energybillmanager.service;

import fr.starn.energybillmanager.entity.Client;
import fr.starn.energybillmanager.entity.DailyConsumption;
import fr.starn.energybillmanager.entity.Price;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ConsumptionServiceImplTest {
    @Autowired
    ConsumptionService consumptionService;

    @Test
    void getCost() {
        Client client = new Client();
        client.setId(1);
        client.setPRO(true);
        client.setChiffreAffaire(10000);

        Price price = getPriceForProSmallCA();
        List<DailyConsumption>  consumptions = getConsumptions();
        double cost = consumptionService.getCost(price, consumptions);
        double expected = 10 * 0.113 + 20 * 0.118;
        assertEquals(expected, cost);
    }

    private Price getPriceForProSmallCA(){
        return new Price(0, true, 0, 100000, 0.113f, 0.118f);
    }

    private List<Price> getAllPrices(){
        Price pricePro1 = getPriceForProSmallCA();
        Price pricePro2 = new Price(1l, true, 100001l, 999999999999l, 111f, 0.114f);
        Price priceParticulier = new Price(2, false, 0, 0, 0.115f, 0.121f);
        List<Price> result = new ArrayList<>();
        result.add(pricePro1);
        result.add(pricePro2);
        result.add(priceParticulier);
        return result;
    }

    private List<DailyConsumption> getConsumptions(){
        List<DailyConsumption> result = new ArrayList<>();
        DailyConsumption c1 = new DailyConsumption();
        c1.setGaz(true);
        c1.setConsoKWH(10);
        result.add(c1);
        DailyConsumption c2 = new DailyConsumption();
        c2.setGaz(false);
        c2.setConsoKWH(20);
        result.add(c2);
        return result;
    }
}