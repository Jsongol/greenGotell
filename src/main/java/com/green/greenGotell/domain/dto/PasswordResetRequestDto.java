package com.green.greenGotell.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class PasswordResetRequestDto {

    @NotBlank
    @Email
    private String email;
}
