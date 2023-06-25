package com.example.autocomplete_case_study.model;

import java.lang.reflect.Field;
import java.util.Arrays;


/**
 * This class represents the data provided by the DB Station & Service Service.
 */
public class StationData {

    private String evaNr;
    private String ds100;
    private String name;
    private String verkehr;
    private String laenge;
    private String breite;



    public StationData(String evaNr, String ds100, String name, String verkehr, String laenge, String breite) {
        this.evaNr = evaNr;
        this.ds100 = ds100;
        this.name = name;
        this.verkehr = verkehr;
        this.laenge = laenge;
        this.breite = breite;
    }

    public StationData() {

    }

    /**
     * Returns the data formatted as asked in the description of the assignment
     * @return A string with the following format: <eva_nr> - <ds100> - <name>
     */
    public String getStringRepresentation() {
        return this.evaNr + " - " +
                this.ds100 + " - " +
                this.name ;
    }

    /**
     * Creates a new StationData object from an array.
     * @param data The data to create the object from. Must be in the format:
     *             [evaNr,ds100,name,verkehr,laenge,breite]
     * @return A StationData object.
     */
    public StationData createStationFromArray(String[] data) {
        return new StationData(data[0], data[1] , data[2], data[3], data[4], data[5]);
    }

    public String getEvaNr() {
        return evaNr;
    }

    public String getDs100() {
        return ds100;
    }

    public String getName() {
        return name;
    }

    public String getVerkehr() {
        return verkehr;
    }

    public String getLaenge() {
        return laenge;
    }

    public String getBreite() {
        return breite;
    }


}
