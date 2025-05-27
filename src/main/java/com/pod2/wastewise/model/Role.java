package com.pod2.wastewise.model;

import com.pod2.wastewise.model.enums.RoleType;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Role {
    @Id
    private String roleId;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @OneToMany(mappedBy = "role")
    private List<Worker> workers;

    public Role(){}

    public Role(String roleId, RoleType role, List<Worker> workers) {
        super();
        this.roleId = roleId;
        this.role = role;
        this.workers = workers;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}
