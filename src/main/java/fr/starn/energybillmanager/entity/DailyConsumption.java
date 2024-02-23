package fr.starn.energybillmanager.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "daily_consumption")
public class DailyConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long clientId;
    private Date consumptionDate;
    private boolean isGaz;
    private long consoKWH;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public Date getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }

    public boolean isGaz() {
        return isGaz;
    }

    public void setGaz(boolean gaz) {
        isGaz = gaz;
    }

    public long getConsoKWH() {
        return consoKWH;
    }

    public void setConsoKWH(long consoKWH) {
        this.consoKWH = consoKWH;
    }

}
