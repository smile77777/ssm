import com.ljc.pojo.User;
import com.ljc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_mapper.xml", "classpath:applicationContext_service.xml"})
public class testMyssm {
    @Autowired
    UserService userService;

    @Test
    public void test01(){
        List<User> list=userService.selectUserPage(null,null,0);
        list.forEach(user -> {System.out.println(user);});
    }
    @Test
    public void test02(){
        int num=userService.deleteUserById("123123123");
        System.out.println(num);
    }

    @Test
    public void test03(){
        int num=userService.getRowCount(null,"男");
        System.out.println(num);
    }
    @Test
    public void test04(){
        User u=new User("1","1","1","1","1","1","1");
        int num=userService.createUser(u);
        System.out.println(num);
    }

    @Test
    public void test05(){

    }
}
