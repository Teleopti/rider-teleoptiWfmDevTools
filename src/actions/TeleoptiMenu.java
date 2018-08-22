package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.*;
import com.teleopti.wfm.developer.tools.OptionsReader;
import com.teleopti.wfm.developer.tools.OptionsAction;
import com.teleopti.wfm.developer.tools.actions.legacy.*;

public class TeleoptiMenu extends DefaultActionGroup {

    public TeleoptiMenu() {
        super("TeleoptiMenu", true);
    }

    private boolean _inUpdate = false;

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

        ActionRegistrator registrator = new ActionRegistrator();

        OptionsAction[] items = new OptionsReader().Read().TeleoptiMenu;
        if (items != null && items.length > 0){
            for (OptionsAction item: items) {
                teleoptiMenu.add(new PluginAction(item));
            }
        } else {

            RestoreToLocal restoreToLocal = new RestoreToLocal();
            registrator.RegisterAction("RestoreToLocal", restoreToLocal);
            teleoptiMenu.add(restoreToLocal);

            FixMyConfigFlow fixMyConfigFlow = new FixMyConfigFlow();
            registrator.RegisterAction("FixMyConfigFlow", fixMyConfigFlow);
            teleoptiMenu.add(fixMyConfigFlow);

            InfraTestConfig infraTestConfig = new InfraTestConfig();
            registrator.RegisterAction("InfraTestConfig", infraTestConfig);
            teleoptiMenu.add(infraTestConfig);

            NpmInstall npmInstall = new NpmInstall();
            registrator.RegisterAction("NpmInstall", npmInstall);
            teleoptiMenu.add(npmInstall);

            NpmStart npmStart = new NpmStart();
            registrator.RegisterAction("NpmStart", npmStart);
            teleoptiMenu.add(npmStart);

            NpmTest npmTest = new NpmTest();
            registrator.RegisterAction("NpmTest", npmTest);
            teleoptiMenu.add(npmTest);

            NpmTestRta npmTestRta = new NpmTestRta();
            registrator.RegisterAction("NpmTestRta", npmTestRta);
            teleoptiMenu.add(npmTestRta);

            NpmDevTest npmDevTest = new NpmDevTest();
            registrator.RegisterAction("NpmDevTest", npmDevTest);
            teleoptiMenu.add(npmDevTest);

            NpmRtaTest npmRtaTest = new NpmRtaTest();
            registrator.RegisterAction("NpmRtaTest", npmRtaTest);
            teleoptiMenu.add(npmRtaTest);

            NpmStartAlpha npmStartAlpha = new NpmStartAlpha();
            registrator.RegisterAction("NpmStartAlpha", npmStartAlpha);
            teleoptiMenu.add(npmStartAlpha);

            GruntNova gruntNova = new GruntNova();
            registrator.RegisterAction("GruntNova", gruntNova);
            teleoptiMenu.add(gruntNova);

            GruntDist gruntDist = new GruntDist();
            registrator.RegisterAction("GruntDist", gruntDist);
            teleoptiMenu.add(gruntDist);

            GruntDevTest gruntDevTest = new GruntDevTest();
            registrator.RegisterAction("GruntDevTest", gruntDevTest);
            teleoptiMenu.add(gruntDevTest);

            GruntRtaTest gruntRtaTest = new GruntRtaTest();
            registrator.RegisterAction("GruntRtaTest", gruntRtaTest);
            teleoptiMenu.add(gruntRtaTest);

            Etl etl = new Etl();
            registrator.RegisterAction("Etl", etl);
            teleoptiMenu.add(etl);

            EnsureRecurringJobs ensureRecurringJobs = new EnsureRecurringJobs();
            registrator.RegisterAction("EnsureRecurringJobs", ensureRecurringJobs);
            teleoptiMenu.add(ensureRecurringJobs);

        }

        CommandLine commandLine = new CommandLine();
        registrator.RegisterAction("CommandLine", commandLine);
        teleoptiMenu.add(commandLine);

        _inUpdate = false;
    }

}