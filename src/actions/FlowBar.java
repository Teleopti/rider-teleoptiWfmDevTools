package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.teleopti.wfm.developer.tools.OptionsAction;
import com.teleopti.wfm.developer.tools.OptionsReader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

public class FlowBar extends ActionGroup {
    private actions _actions;
    private boolean _inUpdate = false;

    public FlowBar() {
        super("FlowBar", false);
    }

    @NotNull
    @Override
    public AnAction[] getChildren(@Nullable AnActionEvent anActionEvent) {
        return _actions.actions();
    }

    @Override
    public void update(AnActionEvent event) {
        if (_inUpdate)
            return;
        _inUpdate = true;
        updateActions();
        _inUpdate = false;
    }

    private class actions {

        private AnAction[] _actions = {};
        private int _hash;

        public void add(AnAction action, int hash) {
            ArrayList<AnAction> a = new ArrayList<>(Arrays.asList(_actions));
            a.add(action);
            _actions = a.toArray(new AnAction[0]);
            _hash = 31 * _hash + hash;
        }

        public int hashCode() {
            return _hash;
        }

        public AnAction[] actions() {
            return _actions;
        }
    }

    private void updateActions() {
        actions actions = new actions();
        OptionsAction[] items = new OptionsReader().Read().NavigationToolBar;
        if (items != null) {
            for (OptionsAction item : items) {
                PluginAction action = new PluginAction(item);
                actions.add(action, action.hashCode());
            }
        }

        if (_actions == null || _actions.hashCode() != actions.hashCode())
            _actions = actions;
    }
}
