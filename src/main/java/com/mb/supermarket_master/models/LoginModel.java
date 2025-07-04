package com.mb.supermarket_master.models;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LoginModel {

    @NotNull(message = "username is required")
    @Size(min = 3, max = 15, message = "username must be between 3 and 15 characters")
    private String username;
    @NotNull(message = "password is required")
    @Size(min = 8, max = 15, message = "password must be between 8 and 15 characters")
    private String password;
}
