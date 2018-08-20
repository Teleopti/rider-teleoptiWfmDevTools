import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.Anchor;
import com.intellij.openapi.actionSystem.Constraints;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.components.ApplicationComponent;
import com.teleopti.wfm.developer.tools.OptionsReader;
import com.teleopti.wfm.developer.tools.OptionsTeleoptiMenuItem;
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

        DefaultActionGroup navigationBarToolBar = (DefaultActionGroup) actionManager.getAction("NavBarToolBar");

        SuperFlow superFlow = new SuperFlow();
        actionManager.registerAction("SuperFlow", superFlow);
        navigationBarToolBar.add(superFlow, Constraints.FIRST);

        BatFlow batFlow = new BatFlow();
        actionManager.registerAction("BatFlow", batFlow);
        navigationBarToolBar.add(batFlow, Constraints.FIRST);

        DefaultActionGroup mainMenu = (DefaultActionGroup) actionManager.getAction("MainMenu");
        TeleoptiMenu teleoptiMenu = new TeleoptiMenu();
        mainMenu.add(teleoptiMenu, new Constraints(Anchor.BEFORE, "HelpMenu"));
    }

    public void disposeComponent() {
    }
}