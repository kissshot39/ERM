package project.erm.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role {
    MANAGER("MANAGER"),
    MEMBER("MEMBER");

    private final String value;

    public static Role from(String role) {
        if (role == null || role.isBlank()) {
            throw new IllegalArgumentException("Role is null or blank");
        }

        try {
            return Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format("Role %s is invalid", role));
        }
    }

}
