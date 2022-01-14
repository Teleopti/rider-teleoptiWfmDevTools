import com.intellij.ide.CommonActionsManager;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.components.ApplicationComponent;
import com.teleopti.wfm.developer.tools.actions.*;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        //String allActionIds = actionManager.getActionIdList("")
        //        .stream()
        //        .collect(Collectors.joining("\n"));

        //DefaultActionGroup mainToolBar = (DefaultActionGroup) actionManager.getAction("MainToolBar");
        //String ids = Arrays.stream(mainToolBar.getChildActionsOrStubs())
        //        .map(a -> actionManager.getId(a))
        //        .collect(Collectors.joining("\n"));

        //DefaultActionGroup ToolbarRunGroup = (DefaultActionGroup) actionManager.getAction("ToolbarRunGroup");
        //flowBar.updateActions();
        //AnAction action = flowBar._actions.actions()[0];
        //ToolbarRunGroup.add(action, Constraints.LAST);

        DefaultActionGroup navigationBarToolBar = (DefaultActionGroup) actionManager.getAction("NavBarToolBar");
        FlowBar flowBar = new FlowBar();
        navigationBarToolBar.add(flowBar, Constraints.FIRST);

        DefaultActionGroup mainMenu = (DefaultActionGroup) actionManager.getAction("MainMenu");
        TeleoptiMenu teleoptiMenu = new TeleoptiMenu();
        mainMenu.add(teleoptiMenu, new Constraints(Anchor.BEFORE, "HelpMenu"));
    }

    public void disposeComponent() {
    }
}