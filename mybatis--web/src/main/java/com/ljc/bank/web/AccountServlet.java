package com.ljc.bank.web;

import com.ljc.bank.exceptions.MoneyNotEnoughException;
import com.ljc.bank.exceptions.TranferException;
import com.ljc.bank.service.AccountService;
import com.ljc.bank.service.impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {

    private AccountService accountService=new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));
        try {
            accountService.transfer(fromActno,toActno,money);
            //以下为成功
            response.sendRedirect(request.getContextPath()+"/success.html");
        } catch (MoneyNotEnoughException e) {
            response.sendRedirect(request.getContextPath()+"/erreor1.html");
        } catch (TranferException e) {
            response.sendRedirect(request.getContextPath()+"/erreor2.html");
        }
    }
}
