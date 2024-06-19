package com.bike.cloud.mapper;

import com.bike.cloud.entities.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM t_user WHERE username = #{username}")
    User findByUserName(String username);

    @Insert("INSERT INTO t_user(username, password, full_name, email, user_pic, student_id, create_time, update_time)" +
            " VALUES(#{username}, #{password}, #{fullName}, #{email}, #{userPic}, #{studentId}, NOW(), NOW())"
    )
    void add(User user);

    @Select("SELECT * FROM t_user WHERE id = #{id}")
    User findByUserId(Integer id);

    @Update("UPDATE t_user SET username=#{username}, password=#{password}, full_name=#{fullName}, email=#{email}, user_pic=#{userPic}, " +
            "student_id=#{studentId}, update_time=NOW() WHERE id = #{id}")
    void update(User user);

    @Update("UPDATE t_user SET user_pic=#{userPic}, update_time=NOW() WHERE id=#{id}")
    void updateAvatar(String userPic, Integer id);

    @Update("UPDATE t_user SET password=#{password}, update_time=NOW() WHERE id=#{id}")
    void updatePwd(String password, Integer id);
}


