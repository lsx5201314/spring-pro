package com.jk.service;

import com.jk.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> queryRole();

    List<Object> queryRoleTree(Integer userId);

    void updateUserRole(String userid, String[] roleIds);
}
