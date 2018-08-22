import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.Anchor;
import com.intellij.openapi.actionSystem.Constraints;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.components.ApplicationComponent;
import com.teleopti.wfm.developer.tools.OptionsAction;
import com.teleopti.wfm.developer.tools.OptionsReader;
import com.teleopti.wfm.developer.tools.actions.*;
import com.teleopti.wfm.developer.tools.actions.legacy.BatFlow;
import com.teleopti.wfm.developer.tools.actions.legacy.SuperFlow;
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

        DefaultActionGroup navigationBarToolBar = (DefaultActionGroup) actionManager.getAction("NavBarToolBar");

        OptionsAction[] items = new OptionsReader().Read().NavigationToolBar;
        if (items != null && items.length > 0){
            for (OptionsAction item: items) {
                navigationBarToolBar.add(new PluginAction(item), Constraints.FIRST);
            }
        } else {

            ActionRegistrator registrator = new ActionRegistrator();

            SuperFlow superFlow = new SuperFlow();
            registrator.RegisterAction("SuperFlow", superFlow);
            navigationBarToolBar.add(superFlow, Constraints.FIRST);

            BatFlow batFlow = new BatFlow();
            registrator.RegisterAction("BatFlow", batFlow);
            navigationBarToolBar.add(batFlow, Constraints.FIRST);
        }

        DefaultActionGroup mainMenu = (DefaultActionGroup) actionManager.getAction("MainMenu");
        TeleoptiMenu teleoptiMenu = new TeleoptiMenu();
        mainMenu.add(teleoptiMenu, new Constraints(Anchor.BEFORE, "HelpMenu"));
    }

    public void disposeComponent() {
    }
}