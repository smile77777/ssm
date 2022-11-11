package com.ljc.bank.service;

import com.ljc.bank.exceptions.MoneyNotEnoughException;
import com.ljc.bank.exceptions.TranferException;

public interface AccountService {

    /**
     * 账户转账方法
     * @param fromActno 转出账户
     * @param toActno 转入账号
     * @param money 转账金额
     */
    void transfer(String fromActno,String toActno,Double money) throws MoneyNotEnoughException, TranferException;
}
