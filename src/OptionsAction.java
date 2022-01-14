package com.teleopti.wfm.developer.tools;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionsAction {
    public String Id;
    public String Icon;
    public String Text;
    public String Description;
    public String Directory;
    public String[] Run;
    public String[] Script;
}
