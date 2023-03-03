import com.kuang.dao.UserDaoSqlServerImpl;
import com.kuang.service.UserService;
import com.kuang.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author LYL
 * @create 2021/5/28 10:31
 */
public class MyTest {
    public static void main(String[] args) {
        //获取ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //容器在手，天下我有，需要什么酒直接get什么
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");

        //使用
        userServiceImpl.getUser();


/*        //用户实际调用的是业务层，dao层他们不需要接触！
        UserService userService = new UserServiceImpl();
        ((UserServiceImpl) userService).setUserDao(new UserDaoSqlServerImpl());
        userService.getUser();*/


/*        UserDao userDao = new UserDaoImpl();
        userDao.getUser();*/
    }
}
