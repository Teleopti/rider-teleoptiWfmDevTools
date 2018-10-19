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

        for(AnAction item: this.getChildren(event)){
            this.remove(item);
        }

        ActionRegistrator registrator = new ActionRegistrator();

        OptionsAction[] items = new OptionsReader().Read().TeleoptiMenu;
        if (items != null && items.length > 0){
            for (OptionsAction item: items) {
                add(new PluginAction(item));
            }
        } else {

            RestoreToLocal restoreToLocal = new RestoreToLocal();
            registrator.RegisterAction("RestoreToLocal", restoreToLocal);
            add(restoreToLocal);

            FixMyConfigFlow fixMyConfigFlow = new FixMyConfigFlow();
            registrator.RegisterAction("FixMyConfigFlow", fixMyConfigFlow);
            add(fixMyConfigFlow);

            InfraTestConfig infraTestConfig = new InfraTestConfig();
            registrator.RegisterAction("InfraTestConfig", infraTestConfig);
            add(infraTestConfig);

            NpmInstall npmInstall = new NpmInstall();
            registrator.RegisterAction("NpmInstall", npmInstall);
            add(npmInstall);

            NpmStart npmStart = new NpmStart();
            registrator.RegisterAction("NpmStart", npmStart);
            add(npmStart);

            NpmTest npmTest = new NpmTest();
            registrator.RegisterAction("NpmTest", npmTest);
            add(npmTest);

            NpmTestRta npmTestRta = new NpmTestRta();
            registrator.RegisterAction("NpmTestRta", npmTestRta);
            add(npmTestRta);

            NpmDevTest npmDevTest = new NpmDevTest();
            registrator.RegisterAction("NpmDevTest", npmDevTest);
            add(npmDevTest);

            NpmRtaTest npmRtaTest = new NpmRtaTest();
            registrator.RegisterAction("NpmRtaTest", npmRtaTest);
            add(npmRtaTest);

            NpmStartAlpha npmStartAlpha = new NpmStartAlpha();
            registrator.RegisterAction("NpmStartAlpha", npmStartAlpha);
            add(npmStartAlpha);

            GruntNova gruntNova = new GruntNova();
            registrator.RegisterAction("GruntNova", gruntNova);
            add(gruntNova);

            GruntDist gruntDist = new GruntDist();
            registrator.RegisterAction("GruntDist", gruntDist);
            add(gruntDist);

            GruntDevTest gruntDevTest = new GruntDevTest();
            registrator.RegisterAction("GruntDevTest", gruntDevTest);
            add(gruntDevTest);

            GruntRtaTest gruntRtaTest = new GruntRtaTest();
            registrator.RegisterAction("GruntRtaTest", gruntRtaTest);
            add(gruntRtaTest);

            Etl etl = new Etl();
            registrator.RegisterAction("Etl", etl);
            add(etl);

            EnsureRecurringJobs ensureRecurringJobs = new EnsureRecurringJobs();
            registrator.RegisterAction("EnsureRecurringJobs", ensureRecurringJobs);
            add(ensureRecurringJobs);

        }

        _inUpdate = false;
    }

}