import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.components.ApplicationComponent;
import com.teleopti.wfm.developer.tools.DevStuff;
import com.teleopti.wfm.developer.tools.actions.*;
import org.jetbrains.annotations.NotNull;

public class PluginRegistration implements ApplicationComponent {
    @NotNull
    public String getComponentName() {
        return "com.teleopti.wfm.developer.tools";
    }

    public void initComponent() {
        ActionManager actionManager = ActionManager.getInstance();

        // already done check
        if (actionManager.getAction("TeleoptiMenu") != null)
            return;

        new DevStuff().menuExperiments(actionManager);

        FlowBar flowBar = new FlowBar();
        // Adds FlowBar to "Navigation bar" and "Toolbar classic" (Main Toolbar)
        // Cant add to the new toolbar yet:
        // https://blog.jetbrains.com/dotnet/2021/11/16/rider-2021-3-brand-new-main-toolbar/
        // https://youtrack.jetbrains.com/issue/RIDER-70047
        // https://youtrack.jetbrains.com/issue/RIDER-70122
        DefaultActionGroup toolbarRunGroup = (DefaultActionGroup) actionManager.getAction("ToolbarRunGroup");
        toolbarRunGroup.add(flowBar, Constraints.FIRST);

        DefaultActionGroup mainMenu = (DefaultActionGroup) actionManager.getAction("MainMenu");
        TeleoptiMenu teleoptiMenu = new TeleoptiMenu();
        mainMenu.add(teleoptiMenu, new Constraints(Anchor.BEFORE, "HelpMenu"));
    }

    public void disposeComponent() {
    }
}