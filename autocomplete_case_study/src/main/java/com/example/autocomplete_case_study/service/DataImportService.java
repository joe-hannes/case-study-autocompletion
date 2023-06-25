package com.example.autocomplete_case_study.service;

import com.example.autocomplete_case_study.model.StationData;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This class is responsible for fetching the data from the DB Station & Service server
 */
@Service
public class DataImportService {

    private static final String FILE_URL = "https://download-data.deutschebahn.com/static/datasets/haltestellen/D_Bahnhof_2016_01_alle.csv";
    private static final String DELIMITER = ";";

    /**
     * Requests the data and creates StationData objects.
     * @return A List containing each station as a StationData object.
     * @throws IOException
     */
    public static List<StationData> getData() throws IOException {

        URL url = new URL(FILE_URL);
        List<StationData> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line = br.readLine(); // skip first line
            while ((line = br.readLine()) != null) {

                String[] values = line.split(DELIMITER);
                StationData stationData = new StationData().createStationFromArray(values);

                records.add(stationData);
            }
        }

        return records;
    }
}
