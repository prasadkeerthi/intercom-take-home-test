package com.example.partyinvite.service;

import com.example.partyinvite.model.InviteeData;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.example.partyinvite.Constants.OUTPUT_LOCATION;

import static org.junit.Assert.assertTrue;



public class WriteToOutputTest {

    @Test
    public void writeDataTogivenLocation() throws Exception {
        WriteToOutput writeToOutput = new WriteToOutput();
        List<InviteeData> data = new ArrayList<>();
        InviteeData invitee = new InviteeData();
        invitee.setName("Keerthi");
        invitee.setUser_id(75);
        invitee.setDistance(150);
        data.add(invitee);
        writeToOutput.writeToOutput(data,OUTPUT_LOCATION);
        File tempFile = new File(new File("").getAbsolutePath() + OUTPUT_LOCATION);
        assertTrue(tempFile.exists());
    }



}
