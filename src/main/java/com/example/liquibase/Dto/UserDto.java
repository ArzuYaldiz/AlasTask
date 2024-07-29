package com.example.liquibase.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private int user_id;
    private String user_name;
    private String email;
    private String password;
}
