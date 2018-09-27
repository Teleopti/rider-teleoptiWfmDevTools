package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.spellchecker.dictionary.Dictionary;
import com.teleopti.wfm.developer.tools.OptionsAction;
import com.teleopti.wfm.developer.tools.OptionsReader;
import com.teleopti.wfm.developer.tools.actions.legacy.BatFlow;
import com.teleopti.wfm.developer.tools.actions.legacy.SuperFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class FlowBar extends ActionGroup {
    private AnAction[] _actions;

    public FlowBar() {
        super("FlowBar",false);
    }

    @NotNull
    @Override
    public AnAction[] getChildren(@Nullable AnActionEvent anActionEvent) {
        buildActions();
        return _actions;
    }

    private void buildActions(){
        if (_actions != null)
            return;

        ArrayList<AnAction> actions = new ArrayList<AnAction>();

        OptionsAction[] items = new OptionsReader().Read().NavigationToolBar;
        if (items != null && items.length > 0){
            for (OptionsAction item: items) {
                actions.add(new PluginAction(item));
            }
        } else {
            ActionRegistrator registrator = new ActionRegistrator();

            BatFlow batFlow = new BatFlow();
            registrator.RegisterAction("BatFlow", batFlow);
            actions.add(batFlow);

            SuperFlow superFlow = new SuperFlow();
            registrator.RegisterAction("SuperFlow", superFlow);
            actions.add(superFlow);
        }

        _actions = actions.toArray(new AnAction[0]);
    }
}
