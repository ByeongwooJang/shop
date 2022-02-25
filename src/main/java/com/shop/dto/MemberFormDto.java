package com.shop.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MemberFormDto {
    @NotBlank(message = "이름은 필수에요")
    private  String name;
    @NotBlank(message = "이메일은 필수에요")
    @Email(message="이메일 형식으로 입력하세요")
    private String email;
    @NotBlank(message = "비밀번호는 필수에요")
    @Length(min=8, max=16, message="비밀번호는 8자 이상, 16자 이하")
    private String password;
    @NotBlank(message = "주소는 필수에요")
    private String address;
}
