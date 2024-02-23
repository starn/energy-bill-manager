package fr.starn.energybillmanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean isPRO;

    @Column(nullable = true)
    private long chiffreAffaire;

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


    public long getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(long chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }
}
