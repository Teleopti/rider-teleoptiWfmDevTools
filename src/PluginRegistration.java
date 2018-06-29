import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.Anchor;
import com.intellij.openapi.actionSystem.Constraints;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.components.ApplicationComponent;
import com.teleopti.wfm.developer.tools.actions.*;
import org.jetbrains.annotations.NotNull;

public class PluginRegistration implements ApplicationComponent {
    @NotNull
    public String getComponentName() {
        return "com.teleopti.wfm.developer.tools";
    }

    public void initComponent() {
        ActionManager actionManager = ActionManager.getInstance();

        if (actionManager.getAction("TeleoptiMenu") != null)
            return;

        DefaultActionGroup mainMenu = (DefaultActionGroup) actionManager.getAction("MainMenu");
        DefaultActionGroup navigationBarToolBar = (DefaultActionGroup) actionManager.getAction("NavBarToolBar");

        TeleoptiMenu teleoptiMenu = new TeleoptiMenu();
        mainMenu.add(teleoptiMenu, new Constraints(Anchor.BEFORE, "HelpMenu"));

        SuperFlow superFlow = new SuperFlow();
        actionManager.registerAction("SuperFlow", superFlow);
        navigationBarToolBar.add(superFlow, Constraints.FIRST);

        BatFlow batFlow = new BatFlow();
        actionManager.registerAction("BatFlow", batFlow);
        navigationBarToolBar.add(batFlow, Constraints.FIRST);

        RestoreToLocal restoreToLocal = new RestoreToLocal();
        actionManager.registerAction("RestoreToLocal", restoreToLocal);
        teleoptiMenu.add(restoreToLocal);

        FixMyConfigFlow fixMyConfigFlow = new FixMyConfigFlow();
        actionManager.registerAction("FixMyConfigFlow", fixMyConfigFlow);
        teleoptiMenu.add(fixMyConfigFlow);

        InfraTestConfig infraTestConfig = new InfraTestConfig();
        actionManager.registerAction("InfraTestConfig", infraTestConfig);
        teleoptiMenu.add(infraTestConfig);

        NpmStartAlpha npmStartAlpha = new NpmStartAlpha();
        actionManager.registerAction("NpmStartAlpha", npmStartAlpha);
        teleoptiMenu.add(npmStartAlpha);

        NpmDevTest npmDevTest = new NpmDevTest();
        actionManager.registerAction("NpmDevTest", npmDevTest);
        teleoptiMenu.add(npmDevTest);

        NpmRtaTest npmRtaTest = new NpmRtaTest();
        actionManager.registerAction("NpmRtaTest", npmRtaTest);
        teleoptiMenu.add(npmRtaTest);

        GruntNova gruntNova = new GruntNova();
        actionManager.registerAction("GruntNova", gruntNova);
        teleoptiMenu.add(gruntNova);

        GruntDist gruntDist = new GruntDist();
        actionManager.registerAction("GruntDist", gruntDist);
        teleoptiMenu.add(gruntDist);

        GruntDevTest gruntDevTest = new GruntDevTest();
        actionManager.registerAction("GruntDevTest", gruntDevTest);
        teleoptiMenu.add(gruntDevTest);

        GruntRtaTest gruntRtaTest = new GruntRtaTest();
        actionManager.registerAction("GruntRtaTest", gruntRtaTest);
        teleoptiMenu.add(gruntRtaTest);

        Etl etl = new Etl();
        actionManager.registerAction("Etl", etl);
        teleoptiMenu.add(etl);

        EnsureRecurringJobs ensureRecurringJobs = new EnsureRecurringJobs();
        actionManager.registerAction("EnsureRecurringJobs", ensureRecurringJobs);
        teleoptiMenu.add(ensureRecurringJobs);

        CommandLine commandLine = new CommandLine();
        actionManager.registerAction("CommandLine", commandLine);
        teleoptiMenu.add(commandLine);

    }

    public void disposeComponent() {
    }
}