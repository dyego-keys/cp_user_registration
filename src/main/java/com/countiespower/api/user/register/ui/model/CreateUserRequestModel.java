package com.countiespower.api.user.register.ui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestModel {

    @NotNull(message = "First name cannot be null")
    @Size(min=2, message = "First name cannot be less than two characters")
    private String firstName;
    @NotNull(message = "Last name cannot be null")
    @Size(min=2, message = "Last name cannot be less than two characters")
    private String lastName;
    @NotNull(message = "Password name cannot be null")
    @Size(min=6, max=16, message = "First name cannot be less than two characters")
    private String password;
    @NotNull(message = "Email name cannot be null")
    @Email
    private String email;

}