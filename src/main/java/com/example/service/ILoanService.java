package com.example.service;

import com.github.pagehelper.PageInfo;
import com.example.common.ServerResponse;
import com.example.pojo.Loan;

public interface ILoanService {

    ServerResponse<String> addApplication(Loan loan);

    ServerResponse<PageInfo> getApplicationList(int pageNum, int pageSize);
}
