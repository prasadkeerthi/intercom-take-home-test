package com.example.partyinvite.service;

import com.example.partyinvite.exception.ExceptionEnum;
import com.example.partyinvite.model.CustomerData;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static com.example.partyinvite.Constants.INPUT_URL;
import static org.junit.jupiter.api.Assertions.*;


public class ReadDatServiceTest {

    @Test
    public void readDataFromGivenUrl() throws Exception {

        ReadDataService readDataService = new ReadDataService();
        List<CustomerData> list = readDataService.readData(INPUT_URL);
        assertFalse(list.isEmpty());
    }

    @Test
    public void throwsExceptionOnInvalidUrl() throws Exception {

        ReadDataService readDataService = new ReadDataService();
        Throwable exception = assertThrows(Exception.class, () -> readDataService.readData(""));
        assertEquals(ExceptionEnum.INPUT_URL_ERROR.getExceptionMessage(), exception.getMessage());

    }
}
