import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class InfraTestConfig extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        CommandRunner.Run(e,
                PathMaker.InRepo(".debug-Setup"),
                PathMaker.InRepo(".debug-Setup\\InfraTestConfig.bat")
        );
    }
}
