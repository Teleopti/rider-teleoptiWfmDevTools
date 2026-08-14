import com.intellij.ide.AppLifecycleListener;
import com.intellij.openapi.actionSystem.*;
import com.teleopti.wfm.developer.tools.DevStuff;
import com.teleopti.wfm.developer.tools.actions.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PluginRegistration implements AppLifecycleListener {
    @Override
    public void appFrameCreated(@NotNull List<String> commandLineArgs) {
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
}
