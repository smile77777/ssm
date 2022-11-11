package com.ljc.bank.dao.impl;

import com.ljc.bank.dao.AccountDao;
import com.ljc.bank.pojo.Account;
import com.ljc.bank.untils.SqlSessionUntil;
import org.apache.ibatis.session.SqlSession;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUntil.openSession();
        Account account=(Account) sqlSession.selectOne("account.selectByActno",actno);
//        sqlSession.close();
        return account;
    }

    @Override
    public int updateByActno(Account act) {
        SqlSession sqlSession=SqlSessionUntil.openSession();
        int count = sqlSession.update("account.updateByActno", act);
//        sqlSession.commit();
//        sqlSession.close();
        return count;
    }
}
