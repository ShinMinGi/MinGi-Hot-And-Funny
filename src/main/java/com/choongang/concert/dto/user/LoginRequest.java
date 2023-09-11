package com.choongang.concert.dto.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoginRequest {

    private String loginId;     // 로그인 아이디 - 이메일
    private String password;    // 비밀번호

}
