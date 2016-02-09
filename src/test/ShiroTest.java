package test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Hao on 2/9/16.
 */
public class ShiroTest {

    private static Logger log = LoggerFactory.getLogger(ShiroTest.class);

    public static void main(String[] args) {

        //1.获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("file:/Users/Hao/IdeaProjects/multi-tenancy/shiro/dbRealm-admin.ini");

        //2.得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3.得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证)
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "admin");

        try {
            //4、登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
        }

        log.info("User is authenticated: "+String.valueOf(subject.isAuthenticated())); //断言用户已经登录

        //6、退出
        subject.logout();



        System.exit(0);
    }
}
