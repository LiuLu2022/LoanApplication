package com.example.service.impl;

import com.example.common.Const;
import com.example.common.ServerResponse;
import com.example.dao.UserMapper;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.pojo.User;
import com.example.util.MD5Util;

@Service("iUserService")
@Component
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

        public ServerResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUsername(username);
        if(resultCount == 0 ){
            return ServerResponse.createByErrorMessage("The user name does not exist.");
        }

        String md5Password = MD5Util.MD5EncodeUtf8(password);
        User user  = userMapper.selectLogin(username,md5Password);
        if(user == null){
            return ServerResponse.createByErrorMessage("Wrong Password.");
        }

        user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
        return ServerResponse.createBySuccess("Login successful!",user);
    }



    public ServerResponse<String> register(User user){
        ServerResponse validResponse = this.checkValid(user.getUsername(),Const.USERNAME);
        if(!validResponse.isSuccess()){
            return validResponse;
        }
        validResponse = this.checkValid(user.getEmail(),Const.EMAIL);
        if(!validResponse.isSuccess()){
            return validResponse;
        }
        //MD5 encrypt
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        int resultCount = userMapper.insert(user);
        if(resultCount == 0){
            return ServerResponse.createByErrorMessage("Register failed!");
        }
        return ServerResponse.createBySuccessMessage("Register successful!");
    }

    public ServerResponse<String> checkValid(String str,String type){
        if(org.apache.commons.lang3.StringUtils.isNotBlank(type)){
            //start to check
            if(Const.USERNAME.equals(type)){
                int resultCount = userMapper.checkUsername(str);
                if(resultCount > 0 ){
                    return ServerResponse.createByErrorMessage("The user name is already existed.");
                }
            }
            if(Const.EMAIL.equals(type)){
                int resultCount = userMapper.checkEmail(str);
                if(resultCount > 0 ){
                    return ServerResponse.createByErrorMessage("The email is already existed.");
                }
            }
        }else{
            return ServerResponse.createByErrorMessage("Wrong parameter.");
        }
        return ServerResponse.createBySuccessMessage("Check successful.");
    }

    public ServerResponse checkAdminRole(User user){
        if(user != null && user.getRole().equals("adviser")){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }
}
