package com.ljc.bank.service.impl;

import com.ljc.bank.dao.AccountDao;
import com.ljc.bank.dao.impl.AccountDaoImpl;
import com.ljc.bank.exceptions.MoneyNotEnoughException;
import com.ljc.bank.exceptions.TranferException;
import com.ljc.bank.pojo.Account;
import com.ljc.bank.service.AccountService;
import com.ljc.bank.untils.SqlSessionUntil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao=new AccountDaoImpl();

    @Override
    public void transfer(String fromActno, String toActno, Double money) throws MoneyNotEnoughException, TranferException {
        SqlSession sqlSession = SqlSessionUntil.openSession();
        Account fromAct = accountDao.selectByActno(fromActno);
        if(fromAct.getBalance()<money){
            throw new MoneyNotEnoughException("对不起，你的余额不足");
        }
        Account toAct=accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance()-money);
        toAct.setBalance(toAct.getBalance()+money);
        int count = accountDao.updateByActno(fromAct);
        count += accountDao.updateByActno(toAct);
        if(count!=2){
            throw new TranferException("转账失败");
        }
        sqlSession.commit();
//        sqlSession.close();
        SqlSessionUntil.close(sqlSession);
    }
}
