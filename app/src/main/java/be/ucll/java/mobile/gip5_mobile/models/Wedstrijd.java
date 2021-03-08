package be.ucll.java.mobile.gip5_mobile.models;

import com.google.gson.annotations.Expose;

import java.util.Date;

import java.time.LocalDateTime;
public class Wedstrijd {
    @Expose
    private Double id;
    @Expose
    private String tijdstip;
    @Expose
    private String locatie;
    @Expose
    private Double thuisploegId;
    @Expose
    private Double tegenstanderId;
    @Expose
    private String tegenstander;
    @Expose
    private String thuisploeg;

    public Wedstrijd(Double id,String tijdstip, String locatie, Double thuisploegId, Double tegenstanderId, String tegenstander, String thuisploeg) {
        this.id = id;
        this.tijdstip = tijdstip;
        this.locatie = locatie;
        this.thuisploegId = thuisploegId;
        this.tegenstanderId = tegenstanderId;
        this.tegenstander = tegenstander;
        this.thuisploeg = thuisploeg;
    }

    public String getTijdstip() {
        return tijdstip;
    }

    public void setTijdstip(String tijdstip) {
        this.tijdstip = tijdstip;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public Double getThuisploegId() {
        return thuisploegId;
    }

    public void setThuisploegId(Double thuisploegId) {
        this.thuisploegId = thuisploegId;
    }

    public Double getTegenstanderId() {
        return tegenstanderId;
    }

    public void setTegenstanderId(Double tegenstanderId) {
        this.tegenstanderId = tegenstanderId;
    }

    public String getTegenstander() {
        return tegenstander;
    }

    public void setTegenstander(String tegenstander) {
        this.tegenstander = tegenstander;
    }

    public String getThuisploeg() {
        return thuisploeg;
    }

    public void setThuisploeg(String thuisploeg) {
        this.thuisploeg = thuisploeg;
    }


    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }
}
