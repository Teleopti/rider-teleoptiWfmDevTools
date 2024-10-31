package com.teleopti.wfm.developer.tools;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Options {
    public OptionsAction[] TeleoptiMenu;
    public OptionsAction[] NavigationToolBar;
}

