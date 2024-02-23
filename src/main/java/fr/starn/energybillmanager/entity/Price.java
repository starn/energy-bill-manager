package fr.starn.energybillmanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean isPRO;

    private long caMin;

    private long caMax;

    private float priceGaz;

    private float priceElectricity;

    public Price() {
    }

    public Price(long id, boolean isPRO, long caMin, long caMax, float priceGaz, float priceElectricity) {
        this.id = id;
        this.isPRO = isPRO;
        this.caMin = caMin;
        this.caMax = caMax;
        this.priceGaz = priceGaz;
        this.priceElectricity = priceElectricity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPRO() {
        return isPRO;
    }

    public void setPRO(boolean PRO) {
        isPRO = PRO;
    }

    public long getCaMin() {
        return caMin;
    }

    public void setCaMin(long caMin) {
        this.caMin = caMin;
    }

    public long getCaMax() {
        return caMax;
    }

    public void setCaMax(long caMax) {
        this.caMax = caMax;
    }

    public float getPriceGaz() {
        return priceGaz;
    }

    public void setPriceGaz(float priceGaz) {
        this.priceGaz = priceGaz;
    }

    public float getPriceElectricity() {
        return priceElectricity;
    }

    public void setPriceElectricity(float priceElectricity) {
        this.priceElectricity = priceElectricity;
    }
}
