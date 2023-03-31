package com.example.service.impl;

import com.example.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.LoanMapper;
import com.example.pojo.Loan;
import com.example.service.ILoanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

@Service("iApplicationService")
public class LoanServiceImpl implements ILoanService {
    @Autowired
    private LoanMapper loanMapper;

    public ServerResponse<String> addApplication(Loan loan){
        int resultCount = loanMapper.insert(loan);
        if(resultCount == 0){
            return ServerResponse.createByErrorMessage("Apply failed!");
        }
        return ServerResponse.createBySuccessMessage("Apply successful!");
    }

    public ServerResponse<PageInfo> getApplicationList(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Loan> loanList = loanMapper.selectApplication();
        PageInfo pageResult = new PageInfo(loanList);

        return ServerResponse.createBySuccess(pageResult);
    }

}
