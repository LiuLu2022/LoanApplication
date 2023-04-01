package com.example.service;

import com.example.pojo.Loan;
import com.github.pagehelper.PageInfo;
import com.example.common.ServerResponse;

public interface ILoanService {

    ServerResponse<String> addApplication(Loan loan);

    ServerResponse<PageInfo> getApplicationList(int pageNum, int pageSize);
}
