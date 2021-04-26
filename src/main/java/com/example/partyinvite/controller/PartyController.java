package com.example.partyinvite.controller;

import com.example.partyinvite.model.CustomerData;
import com.example.partyinvite.model.InviteeData;
import com.example.partyinvite.service.CalculateDistanceService;
import com.example.partyinvite.service.ReadDataService;
import com.example.partyinvite.service.WriteToOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.example.partyinvite.Constants.INPUT_URL;
import static com.example.partyinvite.Constants.OUTPUT_LOCATION;

/**
 * The type Party controller.
 */
@RestController
public class PartyController {


    @Autowired
    ReadDataService readDataService;


    @Autowired
    CalculateDistanceService calculateDistanceService;


    @Autowired
    WriteToOutput writeToOutput;

    /**
     * Read customers from file list.
     *
     * @return the list
     */
    @RequestMapping("/customers")
    public List<CustomerData> readCustomersFromFile() throws Exception {
        return readDataService.readData(INPUT_URL);
    }

    /**
     * Short list invitees.
     *
     * @param distance the distance
     * @return the list
     */
    @RequestMapping(value = {"/customers/invitees/", "/customers/invitees/{distance}"})
    public List<InviteeData> shortListInvitees(@PathVariable(value = "distance") Optional<Double> distance) {
        double givenDistance = 100;
        if (distance.isPresent()) {
            givenDistance = distance.get();
        }
        List<InviteeData> customers = new ArrayList<>();
        try {
            List<CustomerData> customerDataList = readDataService.readData(INPUT_URL);
            customers = calculateDistanceService.shortListCustomersOnDistance(customerDataList, givenDistance);
            Collections.sort(customers, (o1, o2) -> o1.getUser_id() - o2.getUser_id());
            writeToOutput.writeToOutput(customers,OUTPUT_LOCATION);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return customers;
        }


    }


}
