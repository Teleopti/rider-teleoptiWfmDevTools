package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
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

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.EDT;
    }

    @NotNull
    @Override
    public AnAction @NotNull [] getChildren(@Nullable AnActionEvent anActionEvent) {
        if (_actions == null) {
            updateActions();
        }
        return _actions.actionsList();
    }

    @Override
    public void update(@NotNull AnActionEvent event) {
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

        public AnAction[] actionsList() {
            return _actions;
        }
    }

    public void updateActions() {
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
