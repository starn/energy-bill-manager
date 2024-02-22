package fr.starn.energybillmanager.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "daily_consumption")
public class DailyConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long client_id;
    private Date consumption_date;
    private boolean is_gaz;
    private int consoKWH;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public Date getConsumption_date() {
        return consumption_date;
    }

    public void setConsumption_date(Date consumption_date) {
        this.consumption_date = consumption_date;
    }

    public boolean isIs_gaz() {
        return is_gaz;
    }

    public void setIs_gaz(boolean is_gaz) {
        this.is_gaz = is_gaz;
    }

    public int getConsoKWH() {
        return consoKWH;
    }

    public void setConsoKWH(int consoKWH) {
        this.consoKWH = consoKWH;
    }
}
