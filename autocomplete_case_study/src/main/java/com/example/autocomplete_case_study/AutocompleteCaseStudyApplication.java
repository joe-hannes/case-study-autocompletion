package com.example.autocomplete_case_study;

import com.example.autocomplete_case_study.exception.GlobalExceptionHandler;
import com.example.autocomplete_case_study.model.StationData;
import com.example.autocomplete_case_study.service.DataImportService;
import com.example.autocomplete_case_study.service.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@Import(GlobalExceptionHandler.class)
public class AutocompleteCaseStudyApplication {

    @Autowired
    private static DataImportService importService;
    @Autowired
    private static DataProcessingService processingService;

    static List<StationData> stations;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(AutocompleteCaseStudyApplication.class, args);
        stations = DataImportService.getData();
        DataProcessingService.buildTrie(stations);

    }

}
