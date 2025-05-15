package com.hexagonal.tasks.domain.models;

import lombok.Getter;

@Getter
public class AdditionalTaskInfo {
    private final Long userId;
    private final String UserName;
    private final String UserEmail;

    public AdditionalTaskInfo(Long userId, String userName, String userEmail) {
        this.userId = userId;
        UserName = userName;
        UserEmail = userEmail;
    }
}
