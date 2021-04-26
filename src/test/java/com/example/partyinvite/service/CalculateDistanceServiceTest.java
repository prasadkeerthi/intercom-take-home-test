package com.example.partyinvite.service;

import org.junit.jupiter.api.Test;

import static com.example.partyinvite.Constants.OFFICE_LATITUDE;
import static com.example.partyinvite.Constants.OFFICE_LONGITUDE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateDistanceServiceTest {


    @Test
    public void calculateDistanceBetweenLocations_should_return_expected_value_on_given_data() {

        double lat1 = 53.2451022;
        double lon1 = -6.238335;
        double lat2 = OFFICE_LATITUDE;
        double lon2 = OFFICE_LONGITUDE;
        CalculateDistanceService calculateDistanceService = new CalculateDistanceService();
        double result = calculateDistanceService.calculateDistanceBetweenLocations(lat1, lon1, lat2, lon2);
        assertEquals(10.566936288868758, result);
    }
    @Test
    public void calculateDistanceBetweenSameLocations_should_return_expected_value_on_given_data() {

        double lat1 = 53.2451022;
        double lon1 = -53.2451022;
        double lat2 = 53.2451022;
        double lon2 = -53.2451022;
        CalculateDistanceService calculateDistanceService = new CalculateDistanceService();
        double result = calculateDistanceService.calculateDistanceBetweenLocations(lat1, lon1, lat2, lon2);
        assertEquals(0, result);
    }
}
