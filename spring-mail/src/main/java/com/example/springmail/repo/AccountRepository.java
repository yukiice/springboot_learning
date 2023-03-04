package com.example.springmail.repo;

import com.example.springmail.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
//
    Account findAccountByUsername(String username);

//   名字中带有e
    Account findAccountByUsernameLike(String name);

//    自定义
    @Transactional  // DML操作必须在事务环境下，可以不在这里声明，但一定要在事务环境下
    @Modifying   // 表示这是一个DML操作
    @Query("update  Account set password = ?2  where username = ?1")
    int updatePasswordById(String username,String password);
}
