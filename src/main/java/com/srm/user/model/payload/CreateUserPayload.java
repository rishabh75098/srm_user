package com.srm.user.model.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class CreateUserPayload {
    @NotEmpty(message = "User name cannot be empty")
    private String name;
    @NotEmpty(message = "User phone cannot be empty")
    private String phone;
    @NotEmpty(message = "User email cannot be empty")
    private String email;
    @NotEmpty(message = "User password cannot be empty")
    private String password;

    private String address;
}
