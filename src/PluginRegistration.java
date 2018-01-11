import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.Constraints;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.components.ApplicationComponent;
import com.teleopti.wfm.developer.tools.actions.SuperFlow;
import org.jetbrains.annotations.NotNull;

public class PluginRegistration implements ApplicationComponent {
    @NotNull
    public String getComponentName() {
        return "com.teleopti.wfm.developer.tools";
    }

    public void initComponent() {
        ActionManager actionManager = ActionManager.getInstance();

        SuperFlow superFlow = new SuperFlow();
        actionManager.registerAction("SuperFlowTest", superFlow);

        DefaultActionGroup navigationBarToolBar = (DefaultActionGroup) actionManager.getAction("NavBarToolBar");
        navigationBarToolBar.add(superFlow, Constraints.FIRST);
    }

    public void disposeComponent() {
    }
}