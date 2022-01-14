package com.teleopti.wfm.developer.tools;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.Constraints;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.teleopti.wfm.developer.tools.actions.FlowBar;

public class DevStuff {

    public String[] devPaths = {};
    //public String[] devPaths = {"C:\\Code\\twfm\\", "C:\\Code\\teleoptiwfm\\", "C:\\Code\\teleoptiwfm.git\\", "C:\\Code\\teleopticcc\\", "D:\\Code\\teleoptiwfm\\"};

    public void menuExperiments(ActionManager actionManager){

        //FlowBar flowBar = new FlowBar();
        //FlowActions flowActions = new FlowActions();

        //String allActionIds = actionManager.getActionIdList("")
        //        .stream()
        //        .collect(Collectors.joining("\n"));

        //DefaultActionGroup mainToolBar = (DefaultActionGroup) actionManager.getAction("MainToolBar");
        //String ids = Arrays.stream(mainToolBar.getChildActionsOrStubs())
        //        .map(a -> actionManager.getId(a))
        //        .collect(Collectors.joining("\n"));

        //DefaultActionGroup toolbarRunGroup = (DefaultActionGroup) actionManager.getAction("ToolbarRunGroup");
        //for (AnAction action : flowActions.getActions()) {
        //    toolbarRunGroup.add(action, Constraints.FIRST);
        //}

        //toolbarRunGroup.add(flowBar, Constraints.FIRST);

        //DefaultActionGroup toolbarRunGroup = (DefaultActionGroup) actionManager.getAction("ToolbarRunGroup");
        //for (AnAction action : flowBar.getChildActionsOrStubs()) {
        //    toolbarRunGroup.add(action, Constraints.LAST);
        //}


    }
}
