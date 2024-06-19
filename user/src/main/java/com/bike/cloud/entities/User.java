package com.bike.cloud.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

@Data
@Schema(description = "用户信息")
public class User {
    @NotNull
    @Schema(description = "主键ID", example = "1")
    private Integer id;//主键ID

    @Schema(description = "用户名")
    private String username;//用户名

    @JsonIgnore //json字符串中忽略这个属性
    private String password;//密码

    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    @Schema(description = "真实姓名")
    private String fullName;//真实姓名

    @Email
    @Schema(description = "邮箱")
    private String email;//邮箱

    @URL
    @Schema(description = "用户头像地址")
    private String userPic;//用户头像地址

    @Schema(description = "学号")
    private String studentId;//学号

    @Schema(description = "创建时间")
    private LocalDateTime createTime;//创建时间

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;//更新时间
}

