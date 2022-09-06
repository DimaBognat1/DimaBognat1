package net.myproject.patientmanagementsystem.entity;

public enum Permission {
    PATIENTS_READ("patients:read"),
    PATIENTS_WRITE("patients:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
