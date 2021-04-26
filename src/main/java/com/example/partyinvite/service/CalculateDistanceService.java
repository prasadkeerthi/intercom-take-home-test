package com.example.partyinvite.service;


import com.example.partyinvite.model.CustomerData;
import com.example.partyinvite.model.InviteeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


import static com.example.partyinvite.Constants.*;

/**
 * The type Calculate distance service.
 */
@Service
public class CalculateDistanceService {

    Logger logger = LoggerFactory.getLogger(CalculateDistanceService.class);
    /**
     * Short list customers on distance list.
     *
     * @param customerDataList the customer data list
     * @param targetDistance   the target distance
     * @return the list
     */
    public List<InviteeData> shortListCustomersOnDistance(List<CustomerData> customerDataList, double targetDistance) {
        List<InviteeData> shortList = new ArrayList<>();
        for (CustomerData customer : customerDataList) {

            double actualDistance = calculateDistanceBetweenLocations(customer.getLongitude(),
                    customer.getLatitude(), OFFICE_LATITUDE, OFFICE_LONGITUDE);

            if (actualDistance <= targetDistance) {

                InviteeData invitee = new InviteeData(customer.getUser_id(),
                        customer.getName(), actualDistance);
                shortList.add(invitee);

            }

        }
        return shortList;
    }

    /**
     * Calculate distance from hq double.
     *
     * @param lat1 the lat 1
     * @param lon1 the lon 1
     * @param lat2 the lat 2
     * @param lon2 the lon 2
     * @return the double
     */
    public double calculateDistanceBetweenLocations(double lat1, double lon1, double lat2, double lon2) {


        double lat1AsRads = lat1 * Math.PI / 180;
        double lat2AsRads = lat2 * Math.PI / 180;

        double haversineLat = haversine(lat1, lat2);
        double haversineLon = haversine(lon1, lon2);

        double angle = Math.sqrt(haversineLat + Math.cos(lat1AsRads)
                * Math.cos(lat2AsRads) * haversineLon
        );
        double distance = 2 * RADIUS_OF_EARTH * Math.asin(angle);
        logger.info("Distance for locations {},{} and {},{} is {}",lat1,lon1,lat2,lon2,distance);
        return 2 * RADIUS_OF_EARTH * Math.asin(angle);
    }

    /**
     * Haversine double.
     *
     * @param x the x
     * @param y the y
     * @return the double
     */
    public double haversine(double x, double y) {
        double sin = Math.sin(Math.toRadians(y - x) / 2);
        return sin * sin;
    }
}
