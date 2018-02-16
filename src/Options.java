package com.teleopti.wfm.developer.tools;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Options{
    public boolean RestoreToLocalFlow = false;
    public boolean EtlEnsureRecurringJobs = false;
    public boolean EtlEnsureRecurringJobsWithRetries = false;
}
