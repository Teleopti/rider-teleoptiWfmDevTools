package com.teleopti.wfm.developer.tools;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class OptionsReader {

    public Options Read() {
        try {
            File file = new File(PathMaker.InRepo(".com.teleopti.wfm.developer.tools.json"));
            if (file.exists()){
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
                return mapper.readValue(file, Options.class);
            }
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (java.util.NoSuchElementException e) {
            e.printStackTrace();
        }
        return new Options();
    }
}
