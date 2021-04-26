package com.example.partyinvite.service;


import com.example.partyinvite.exception.ExceptionEnum;
import com.example.partyinvite.model.InviteeData;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import static com.example.partyinvite.Constants.OUTPUT_LOCATION;

/**
 * The type Write to output.
 */
@Service
public class WriteToOutput {
    Logger logger = LoggerFactory.getLogger(WriteToOutput.class);
    /**
     * Write to output.
     *
     * @param result the result to be written into the output file
     */
    public void writeToOutput(List<InviteeData> result, String path) throws Exception {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(new File("").getAbsolutePath() + path);


            for (InviteeData invitee : result) {
                JSONObject obj = new JSONObject();
                obj.put("user_id", invitee.getUser_id());
                obj.put("name", invitee.getName());
                obj.put("distance", invitee.getDistance());
                fileWriter.write(obj.toJSONString());
                fileWriter.write("\n");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new Exception(ExceptionEnum.OUTPUT_FILE_ERROR.getExceptionMessage());
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }


}
