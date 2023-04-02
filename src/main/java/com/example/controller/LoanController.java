package com.example.controller;

import com.example.common.Const;
import com.example.common.ResponseCode;
import com.example.common.ServerResponse;
import com.example.pojo.Loan;
import com.example.pojo.User;
import com.example.service.ILoanService;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/loan/")
public class LoanController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ILoanService iLoanService;

    @RequestMapping(value = "addApplication", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addApplication(HttpSession session, Loan loan) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "User didn't login, please login first.");
        }
        if (iUserService.checkCustomerRole(user).isSuccess()) {

            if (StringUtils.isEmpty(loan.getFullName()) || StringUtils.isEmpty(loan.getLoanAmount())) {
                return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), "fullName,loanAmount are necessary fields.");
            }
            loan.setCustomerSsn(user.getUsername()); //set CustomerSsn as username which is from session
            return iLoanService.addApplication(loan);
        } else {
            return ServerResponse.createByErrorMessage("No permission,this function is for customer");
        }
    }

    @RequestMapping(value = "getApplicationList", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getApplicationList(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "User didn't login, please login first.");
        }
        if (iUserService.checkAdviserRole(user).isSuccess()) {
            return iLoanService.getApplicationList(pageNum, pageSize);
        } else {
            return ServerResponse.createByErrorMessage("No permission,this function is for adviser");
        }
    }
}
