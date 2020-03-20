import com.itheima.dao.IAccountDao;
import com.itheima.dao.IRoleDao;
import com.itheima.domain.Account;
import com.itheima.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class RoleTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IRoleDao roleDao;

    @Before
    public  void init()throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        roleDao = session.getMapper(IRoleDao.class);
    }

    @After
    public  void destroy()throws  Exception{
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public  void  testFindAll(){
        List<Role> accounts = roleDao.findAll();
        for(Role account : accounts){
            System.out.println("----每个角色的信息-----");
            System.out.println(account);
            System.out.println(account.getMyuser());
        }
    }
    @Test
    public  void findRolesByUid(){
        List<Role> accounts = roleDao.findRolesByUid(1);
        for(Role account : accounts){
            System.out.println("----每个角色的信息-----");
            System.out.println(account);
            System.out.println(account.getMyuser());
        }
    }



}
