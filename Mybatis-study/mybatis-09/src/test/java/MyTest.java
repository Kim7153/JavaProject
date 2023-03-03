import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.clearCache();//手动清除缓存

        System.out.println("===================");

        User user2 = mapper.getUserById(1);
        System.out.println(user2);

        System.out.println(user == user2);//判断第二次查询是否在sqlSession中的缓存中拿到的 在没有清除缓存之前 两个值为true 清除缓存之后 user2重新查询了一遍 所以为false



        sqlSession.close();
    }
}
