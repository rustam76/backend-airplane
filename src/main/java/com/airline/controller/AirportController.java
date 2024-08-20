package com.airline.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.model.Airport;
import com.airline.service.AirportService;
import com.airline.utils.ApiResponse;
import com.airline.utils.ApiResponseErr;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
            try {
                List<Airport> airports = airportService.findAll();


                System.out.println("airports 13: "+  airports);

                if (airports.isEmpty() || airports == null) {
                    ApiResponseErr<?> apiResponse = new ApiResponseErr<>(
                        HttpStatus.NOT_FOUND.value(),
                        "No airports found"
                    );
                    return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
                }

                ApiResponse<?> apiResponse = new ApiResponse<>(
                    HttpStatus.OK.value(),
                    "Data retrieved successfully",
                    airports
                );
                return new ResponseEntity<>(apiResponse, HttpStatus.OK);
            } catch (Exception e) {
                // TODO: handle exception
                ApiResponseErr<?> apiResponse = new ApiResponseErr<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal server error" + e
                    
                );
                return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try {
            Airport airport = airportService.findById(id);

            if (airport == null) {
                ApiResponseErr<?> apiResponse = new ApiResponseErr<>(
                    HttpStatus.NOT_FOUND.value(),
                    "No airports found"
                );
                return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
            }
            ApiResponse<?> apiResponse = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Data retrieved successfully",
                airport
            );
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponseErr<?> apiResponse = new ApiResponseErr<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal server error"
            );
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> save(@Valid @RequestBody Airport airport) {
        System.out.println("airport post 123: "+airport);
        
        try {

            if (airport.getName() == null || airport.getCode() == null || airport.getCity() == null || airport.getCountry() == null) {
                ApiResponseErr<?> apiResponse = new ApiResponseErr<>(
                    HttpStatus.BAD_REQUEST.value(),
                    "Airport name, code, country and city are required"
                );
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
            }

            Airport savedAirport = airportService.save(airport);
            ApiResponse<?> apiResponse = new ApiResponse<>(
                HttpStatus.CREATED.value(),
                "Airport created successfully",
                savedAirport
            );
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponseErr<?> apiResponse = new ApiResponseErr<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal server error"
            );
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> update(@RequestBody Airport airport, Long id) {
        try {
            Airport updatedAirport = airportService.update(airport, id);
            ApiResponse<?> apiResponse = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Airport updated successfully",
                updatedAirport
            );
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponseErr<?> apiResponse = new ApiResponseErr<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal server error"
            );
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            airportService.delete(id);
            ApiResponse<?> apiResponse = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Airport deleted successfully"
            );
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponseErr<?> apiResponse = new ApiResponseErr<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal server error"
            );
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
