package com.neusoft.srm.model.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tree implements Serializable {

    private static final long serialVersionUID = -2774588417130263137L;
    private String id;
    private String label;
    private String index;// 路径
    private TreeState state;
    private Object attributes;
    private List<Tree> children;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }
    public Object getAttributes() {
        return attributes;
    }
    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }
    public TreeState getState() {
        return state;
    }
    public void setState(TreeState state) {
        this.state = state;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }
}
