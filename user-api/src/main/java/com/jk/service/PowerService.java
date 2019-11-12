package com.jk.service;

import com.jk.model.Power;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PowerService {
    List<Power> queryTree(HttpServletRequest request);

    List<Power> queryrolepowerByrole(Integer id);

    void updatePowerByRoleId(String roleId, String[] powerIds);
}
