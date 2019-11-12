/**
 * @ClassNameRole
 * @Description
 * @Author
 * @Date2019/11/4 14:00
 * @Version V1.0
 **/

package com.jk.model;

import java.io.Serializable;

public class Role implements Serializable {
    private static final long serialVersionUID = 6748631656776223163L;
    private Integer rid;
    private String rname;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}