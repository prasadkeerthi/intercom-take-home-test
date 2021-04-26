package com.example.partyinvite.service;


import com.example.partyinvite.model.CustomerData;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import static com.example.partyinvite.exception.ExceptionEnum.INPUT_URL_ERROR;

/**
 * The type Read data service.
 */
@Service
public class ReadDataService {
    Logger logger = LoggerFactory.getLogger(ReadDataService.class);

    /**
     * Read data list from input file.
     *
     * @return the list of customers
     */
    public List<CustomerData> readData(String inputUrl) throws Exception {

        List<CustomerData> customerDataList = new ArrayList<CustomerData>();
        JSONParser parser = new JSONParser();
        try {
            URL urlReader = new URL(inputUrl);
            URLConnection urlConnection = urlReader.openConnection();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            String line = buffer.readLine();
            while (line != null) {
                Object obj = parser.parse(line);
                parseJsonToData(customerDataList, obj);
                line = buffer.readLine();
            }
            buffer.close();
        } catch (Exception e) {
            logger.error("Exception {1} thrown",INPUT_URL_ERROR.getExceptionMessage() );
            throw new Exception(INPUT_URL_ERROR.getExceptionMessage());

        }
        return customerDataList;
    }

    /**
     * Parse json to data.
     *
     * @param customerDataList the customer data list
     * @param obj              the obj
     */
    public void parseJsonToData(List<CustomerData> customerDataList, Object obj) {

        JSONObject jsonObject = (JSONObject) obj;
        int userId = Integer.parseInt(jsonObject.get("user_id").toString());
        String name = jsonObject.get("name").toString();
        double longitude = Double.parseDouble(jsonObject.get("longitude").toString());
        double latitude = Double.parseDouble(jsonObject.get("latitude").toString());
        CustomerData customerObject = new CustomerData(userId, name, longitude, latitude);
        customerDataList.add(customerObject);

    }

}



