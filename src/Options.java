package com.teleopti.wfm.developer.tools;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Options{
    public boolean RestoreToLocalFlow = false;
    public boolean EtlEnsureRecurringJobs = false;
    public boolean EtlEnsureRecurringJobsWithRetries = false;
    public boolean NpmRunRtaTest = false;
    public boolean ToolsFlowWithoutSQLCMD = false;
    public boolean ToolsFlowWithFixMyConfig = false;
    public boolean ToolsFlowWithInfraTestConfigWithOptionalToggleMode = false;
    public boolean BatflowThatWorks = false;
}
