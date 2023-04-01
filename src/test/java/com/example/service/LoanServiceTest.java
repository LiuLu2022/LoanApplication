package com.example.service;

import com.example.common.ServerResponse;
import com.example.pojo.Loan;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LoanServiceTest {
    @Autowired
    private ILoanService loanService;

    @Test
    public void testAddApplication() {
        Loan loan = new Loan();
        loan.setCustomerSsn("Anna");
        loan.setFullName("Anna");
        loan.setLoanAmount(BigDecimal.valueOf(5000));
        ServerResponse<String> response = loanService.addApplication(loan);
        assertTrue(response.isSuccess());
    }


    @Test
    public void testGetApplicationList() {
        List<Loan> loanList = new ArrayList<>();
        Loan loan1 = new Loan();
        loan1.setCustomerSsn("Liv");
        loan1.setFullName("Liv");
        loan1.setLoanAmount(BigDecimal.valueOf(5000));


        Loan loan2 = new Loan();
        loan2.setCustomerSsn("Eva");
        loan2.setFullName("Eva");
        loan2.setLoanAmount(BigDecimal.valueOf(2000));

        loanList.add(loan1);
        loanList.add(loan2);

        ServerResponse<PageInfo> response = loanService.getApplicationList(1, 10);
        assertTrue(response.isSuccess());
    }
}

