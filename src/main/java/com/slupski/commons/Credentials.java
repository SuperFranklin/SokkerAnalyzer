package com.slupski.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Credentials {
    private int teamId;
    private String login;
    private String password;
}
