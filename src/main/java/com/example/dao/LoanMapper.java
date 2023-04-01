package com.example.dao;

import com.example.pojo.Loan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoanMapper {
    int insert(Loan record);

    List<Loan> selectApplication();
}
