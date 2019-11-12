/**
 * @ClassNamePower
 * @Description
 * @Author
 * @Date2019/11/4 13:57
 * @Version V1.0
 **/

package com.jk.model;

import java.io.Serializable;
import java.util.List;

public class Power implements Serializable {
    private static final long serialVersionUID = 7356779860962190034L;
    private  Integer id;
    private String text;
    private String url;
    private Integer pid;
    private String state;
    private String roleId;
    private String checked;

    private List<Power> children;

    public List<Power> getChildren() {
        return children;
    }

    public void setChildren(List<Power> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
}