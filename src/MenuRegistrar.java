package com.teleopti.wfm.developer.tools;

import com.intellij.openapi.actionSystem.impl.ActionConfigurationCustomizer;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.Anchor;
import com.intellij.openapi.actionSystem.Constraints;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.teleopti.wfm.developer.tools.actions.FlowBar;
import com.teleopti.wfm.developer.tools.actions.TeleoptiMenu;

/**
 * Registers the Teleopti menu and toolbar programmatically, during action-system init.
 *
 * This runs BEFORE the (merged) New UI menu/toolbar are built, which is why it works in the
 * real Rider New UI. The old 0.6.0 plugin did the same thing from
 * ApplicationComponent.initComponent() (also very early) and worked; the later migration to
 * AppLifecycleListener.appFrameCreated() injected too late (after Rider had already built its
 * menu) and to declarative &lt;add-to-group&gt;, neither of which render in Rider's merged menu.
 *
 * Uses a SyncHeavyCustomizeStrategy (the replacement for the deprecated
 * customize(ActionManager) override since 2026.3). It still gets the ActionManager and runs
 * synchronously during action-system init, same as before.
 */
public class MenuRegistrar implements ActionConfigurationCustomizer {

    private static final String MENU_ID = "com.teleopti.wfm.developer.tools.TeleoptiMenu";
    private static final String FLOWBAR_ID = "com.teleopti.wfm.developer.tools.FlowBar";

    @Override
    public CustomizeStrategy customize() {
        return (SyncHeavyCustomizeStrategy) MenuRegistrar::register;
    }

    private static void register(ActionManager actionManager) {
        if (actionManager.getAction(MENU_ID) == null) {
            TeleoptiMenu teleoptiMenu = new TeleoptiMenu();
            actionManager.registerAction(MENU_ID, teleoptiMenu);
            DefaultActionGroup mainMenu = (DefaultActionGroup) actionManager.getAction("MainMenu");
            if (mainMenu != null) {
                // Pass the provided actionManager: we are running inside ActionManagerImpl's
                // constructor, so the no-arg add() -> ActionManager.getInstance() would be a
                // cyclic init and crash startup (esp. Rider's BackendActionManager).
                mainMenu.add(teleoptiMenu, new Constraints(Anchor.BEFORE, "HelpMenu"), actionManager);
            }
        }

        if (actionManager.getAction(FLOWBAR_ID) == null) {
            FlowBar flowBar = new FlowBar();
            actionManager.registerAction(FLOWBAR_ID, flowBar);
            // Adds FlowBar to "Navigation bar" and "Toolbar classic" (Main Toolbar).
            // The brand-new Rider main toolbar still can't be targeted directly, see:
            // https://youtrack.jetbrains.com/issue/RIDER-70047
            DefaultActionGroup toolbarRunGroup = (DefaultActionGroup) actionManager.getAction("ToolbarRunGroup");
            if (toolbarRunGroup != null) {
                toolbarRunGroup.add(flowBar, Constraints.FIRST, actionManager);
            }
        }
    }
}
