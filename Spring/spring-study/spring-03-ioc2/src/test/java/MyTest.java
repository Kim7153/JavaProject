import com.kuang.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author LYL
 * @create 2021/5/31 20:38
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) context.getBean("user");
        user.show();
    }
}
