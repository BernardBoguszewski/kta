package pl.com.britenet.kta.entity.user;

import lombok.Data;

@Data
public class Permission {
    private String description;

    public Permission() {
    }

    public Permission(String description) {
        this.description = description;
    }
}
