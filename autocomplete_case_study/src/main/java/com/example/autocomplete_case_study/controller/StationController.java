package com.example.autocomplete_case_study.controller;

import com.example.autocomplete_case_study.exception.IllegalCharacterException;
import com.example.autocomplete_case_study.exception.InputTooLongException;
import com.example.autocomplete_case_study.exception.InputTooShortException;
import com.example.autocomplete_case_study.exception.ItemNotFoundException;
import com.example.autocomplete_case_study.model.Response;
import com.example.autocomplete_case_study.model.StationData;
import com.example.autocomplete_case_study.service.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class defines the auto-complete endpoint of the API.
 */
@RestController()
@RequestMapping("/api/v1")
public class StationController {
    @Autowired
    private DataProcessingService processingService;

    @GetMapping("/auto-complete/{inputString}")
    public ResponseEntity autoComplete(@PathVariable String inputString){
        Date date = new Date();
        Date endDate = new Date();

        long startTime = date.getTime();

        // validate user input
        if (!inputString.matches("^[A-z]*$")) {
            throw new IllegalCharacterException();
        }
        if (inputString.toCharArray().length < 3) {
            throw new InputTooShortException();
        }
        if (inputString.toCharArray().length > 50) {
            throw new InputTooLongException();
        }

        //retrieve all suggestions for an user input
        List<StationData> suggestions = processingService.getSuggestions(inputString);

        List<String> formattedStations = new ArrayList<>();
        for(StationData item: suggestions) {
            formattedStations.add(item.getStringRepresentation());
        }


        if (formattedStations.size() == 0) {
            throw new ItemNotFoundException();
        }

        Response response = new Response();

        response.setStationList(formattedStations);
        response.setNumberOfStationsFound(Integer.toString(formattedStations.size()));


        long endTime = endDate.getTime();
        long delta = endTime - startTime;
        response.setTimeTaken(delta + " ms");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
