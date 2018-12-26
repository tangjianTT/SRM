package com.neusoft.srm.model.common;

import java.io.Serializable;

public class TreeState implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean checked = false;//是否选中(多选)
    private boolean expanded = false;//是否展开
    private boolean selected = false;//是否选中(单选)

    public boolean isChecked() {
        return checked;
    }
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    public boolean isExpanded() {
        return expanded;
    }
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
