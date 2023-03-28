package controller;

import common.Const;
import common.ResponseCode;
import common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Application;
import pojo.User;
import service.IApplicationService;
import service.IUserService;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/application/")
public class ApplicationController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IApplicationService iApplicationService;

    @RequestMapping("addApplication.do")
    @ResponseBody
    public ServerResponse addApplication(HttpSession session, Application application){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");

        }
        if(!iUserService.checkAdminRole(user).isSuccess()){
            return iApplicationService.addApplication(application);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作,this function is for customer");
        }
    }

    @RequestMapping("getApplicationList.do")
    @ResponseBody
    public ServerResponse getApplicationList(HttpSession session, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum, @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");

        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            return iApplicationService.getApplicationList(pageNum,pageSize);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作,this function is for adviser");
        }
    }
}
