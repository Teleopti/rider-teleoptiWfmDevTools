package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.*;
import com.teleopti.wfm.developer.tools.OptionsReader;
import com.teleopti.wfm.developer.tools.OptionsTeleoptiMenuItem;
import com.teleopti.wfm.developer.tools.actions.legacy.*;

public class TeleoptiMenu extends DefaultActionGroup {

    public TeleoptiMenu() {
        super("TeleoptiMenu", true);
    }

    private boolean _inUpdate = false;

    private void registerAction(String id, AnAction action){
        ActionManager actionManager = ActionManager.getInstance();
        actionManager.unregisterAction(id);
        actionManager.registerAction(id, action);
    }

    @Override
    public void update(AnActionEvent event) {
        if (_inUpdate)
            return;
        _inUpdate = true;
        Presentation presentation = event.getPresentation();
        if (!presentation.isEnabled())
            presentation.setEnabled(true);
        presentation.setText("Teleopti");

        TeleoptiMenu teleoptiMenu = this;

        for(AnAction item: this.getChildren(event)){
            this.remove(item);
        }

        OptionsTeleoptiMenuItem[] items = new OptionsReader().Read().TeleoptiMenu;
        if (items != null && items.length > 0){
            for (OptionsTeleoptiMenuItem item: items) {
                TeleoptiMenuItem menuItem = new TeleoptiMenuItem(item.Text, item.Icon, item.Directory, item.Run);
                registerAction(item.Id, menuItem);
                teleoptiMenu.add(menuItem);
            }
        } else {

            RestoreToLocal restoreToLocal = new RestoreToLocal();
            registerAction("RestoreToLocal", restoreToLocal);
            teleoptiMenu.add(restoreToLocal);

            FixMyConfigFlow fixMyConfigFlow = new FixMyConfigFlow();
            registerAction("FixMyConfigFlow", fixMyConfigFlow);
            teleoptiMenu.add(fixMyConfigFlow);

            InfraTestConfig infraTestConfig = new InfraTestConfig();
            registerAction("InfraTestConfig", infraTestConfig);
            teleoptiMenu.add(infraTestConfig);

            NpmInstall npmInstall = new NpmInstall();
            registerAction("NpmInstall", npmInstall);
            teleoptiMenu.add(npmInstall);

            NpmStart npmStart = new NpmStart();
            registerAction("NpmStart", npmStart);
            teleoptiMenu.add(npmStart);

            NpmTest npmTest = new NpmTest();
            registerAction("NpmTest", npmTest);
            teleoptiMenu.add(npmTest);

            NpmTestRta npmTestRta = new NpmTestRta();
            registerAction("NpmTestRta", npmTestRta);
            teleoptiMenu.add(npmTestRta);

            NpmDevTest npmDevTest = new NpmDevTest();
            registerAction("NpmDevTest", npmDevTest);
            teleoptiMenu.add(npmDevTest);

            NpmRtaTest npmRtaTest = new NpmRtaTest();
            registerAction("NpmRtaTest", npmRtaTest);
            teleoptiMenu.add(npmRtaTest);

            NpmStartAlpha npmStartAlpha = new NpmStartAlpha();
            registerAction("NpmStartAlpha", npmStartAlpha);
            teleoptiMenu.add(npmStartAlpha);

            GruntNova gruntNova = new GruntNova();
            registerAction("GruntNova", gruntNova);
            teleoptiMenu.add(gruntNova);

            GruntDist gruntDist = new GruntDist();
            registerAction("GruntDist", gruntDist);
            teleoptiMenu.add(gruntDist);

            GruntDevTest gruntDevTest = new GruntDevTest();
            registerAction("GruntDevTest", gruntDevTest);
            teleoptiMenu.add(gruntDevTest);

            GruntRtaTest gruntRtaTest = new GruntRtaTest();
            registerAction("GruntRtaTest", gruntRtaTest);
            teleoptiMenu.add(gruntRtaTest);

            Etl etl = new Etl();
            registerAction("Etl", etl);
            teleoptiMenu.add(etl);

            EnsureRecurringJobs ensureRecurringJobs = new EnsureRecurringJobs();
            registerAction("EnsureRecurringJobs", ensureRecurringJobs);
            teleoptiMenu.add(ensureRecurringJobs);

        }

        CommandLine commandLine = new CommandLine();
        registerAction("CommandLine", commandLine);
        teleoptiMenu.add(commandLine);

        _inUpdate = false;
    }

}