package com.kevtubio.questionados.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SignupRequestDTO {

    private String username;
    private String password;
    private String email;
    private Set<String> role;

}
