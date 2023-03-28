package dao;

import pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int insert(User record);

    int checkUsername(String username);

    int checkEmail(String email);

    int checkPassword(@Param(value="password")String password,@Param("userId")Integer userId);

    User selectLogin(@Param("username") String username, @Param("password")String password);
}

