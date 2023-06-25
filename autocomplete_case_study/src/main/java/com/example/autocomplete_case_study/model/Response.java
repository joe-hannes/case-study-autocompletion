package com.example.autocomplete_case_study.model;

import java.util.List;

/**
 * This class defines the structure of a response for the auto-complete endpoint.
 */
public class Response {
    private List<String> station_list;
    private String time_taken;
    private String number_of_stations_found;

    public Response(List<String> station_list, String time_taken, String number_of_stations) {
        this.station_list = station_list;
        this.time_taken= time_taken;
        this.number_of_stations_found = number_of_stations;

    }
    public Response(){}

    public List<String> getStationList() {
        return this.station_list;
    }

    public String getTimeTaken() {
        return this.time_taken;
    }
    public String getNumberOfStationsFound(){
        return this.number_of_stations_found;
    }

    public void setStationList(List<String> stationList) {
        this.station_list = stationList;
    }
    public void setTimeTaken(String timeTaken) {
        this.time_taken = timeTaken;
    }
    public void setNumberOfStationsFound(String numberOfStationsFound) {
        this.number_of_stations_found = numberOfStationsFound;
    }

}
