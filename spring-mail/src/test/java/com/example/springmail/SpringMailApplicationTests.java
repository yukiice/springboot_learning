package com.example.springmail;
import com.example.springmail.entity.data.Account;
import com.example.springmail.entity.data.AccountDetail;
import com.example.springmail.repo.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootTestApplicationTests {

    @Resource
    AccountRepository accountRepository;
    @Transactional // 懒加载需要早事务环境下获取，因为repository方法调用完session后会立即执行关闭
    @Test
    void contextLoads(){
//        查询操作
        accountRepository.findById(1).ifPresent(System.out::println);
        accountRepository.findById(1).ifPresent(account -> {
            System.out.println(account.getDetail());
            System.out.println(account.getUsername());
        });
//        删除操作
//        accountRepository.deleteById(2);
    }

//    @Test
    void AddData(){
        Account account = new Account();
        account.setUsername("nick");
        account.setPassword("123");
        AccountDetail detail = new AccountDetail();
        detail.setAddress("郑州");
        detail.setName("瓜瓜");
        detail.setMail("222@qq.com");
        detail.setPhone("119");
        account.setDetail(detail);
        account = accountRepository.save(account);
        System.out.println("主键id为："+account.getId()+",外键ID为"+account.getDetail().getId());
    }


//
////    新增数据
////    @Test
//    void  addAccount(){
//        Account account = new Account();
//        account.setAuth("admin");
//        account.setUsername("huahua");
//        account.setPassword("123456");
//        account = accountRepository.save(account);
//        System.out.println("插入后拿到的id为："+account.getId());
//    }
//
////    分页操作
//    @Test
//    void  pageChange(){
//        accountRepository.findAll(PageRequest.of(0,2)).forEach(System.out::println);
//    }
//
////    自定义操作
//    @Test
//    void customizeOption(){
//       Account account =   accountRepository.findAccountByUsername("admin");
//        System.out.println(account);
//    }
//
////    找到名字中含有指定字符的数据
//    @Test
//    void findDataByName(){
//        Account account = accountRepository.findAccountByUsernameLike("%h%");
//        System.out.println(account);
//    }
}
