package com.db.user.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class userCreateRequest {
    String username;
    String password;
    String firstname;
    String lastname;
    LocalDate daybird;

}
