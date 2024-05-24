package interview.approval_service.role_based_access_control;

import java.util.ArrayList;
import java.util.List;

class User {
    private String username;
    private List<Role> roles;

    public User(String username) {
        this.username = username;
        this.roles = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public boolean hasPermission(String permissionName) {
        return roles.stream()
                .flatMap(role -> role.getPermissions().stream())
                .anyMatch(permission -> permission.getName().equals(permissionName));
    }
}