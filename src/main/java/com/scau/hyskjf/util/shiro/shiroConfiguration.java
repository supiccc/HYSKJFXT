package com.scau.hyskjf.util.shiro;

import org.apache.log4j.Logger;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * Created by supiccc on 2018-08-09 14:23
 */
@Configuration
public class shiroConfiguration {
    Logger logger = Logger.getLogger(shiroConfiguration.class);

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Bean(name="shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);
        //配置登录的url和登录成功的url
        bean.setLoginUrl("/Login/sign_in.html");
//        bean.setSuccessUrl("/home");
        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
//        filterChainDefinitionMap.put("/Login/*", "anon");
//        filterChainDefinitionMap.put("/js/*", "anon");
//        filterChainDefinitionMap.put("/img/*", "anon");
//        filterChainDefinitionMap.put("/assets/*", "anon");
//        filterChainDefinitionMap.put("/Member/indexReal.html", "anon");
//        filterChainDefinitionMap.put("/login", "anon");
//        filterChainDefinitionMap.put("/sendSMS", "anon");
//        filterChainDefinitionMap.put("/forget", "anon");
//
//        filterChainDefinitionMap.put("/**", "user");
//        filterChainDefinitionMap.put("/sign*.html", "anon");
//        filterChainDefinitionMap.put("/forget_password.html", "anon");
//        filterChainDefinitionMap.put("/jsp/login.jsp*", "anon"); //表示可以匿名访问
//        filterChainDefinitionMap.put("/**", "user");  //配置记住我或认证通过可以访问的地址
        //filterChainDefinitionMap.put("/**", "user");  //配置记住我或认证通过可以访问的地址
//        filterChainDefinitionMap.put("/loginUser", "anon");
//        filterChainDefinitionMap.put("/logout*","anon");
//        filterChainDefinitionMap.put("/jsp/error.jsp*","anon");
//        filterChainDefinitionMap.put("/jsp/index.jsp*","authc");
//        filterChainDefinitionMap.put("/*", "authc");//表示需要认证才可以访问
//        filterChainDefinitionMap.put("/**", "authc");//表示需要认证才可以访问
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }
    //配置核心安全事务管理器
    @Bean(name="securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm,
                                           @Qualifier("sessionManager") SessionManager sessionManager,
                                           @Qualifier("catheManager")RedisCacheManager redisCacheManager) {
        System.out.println("--------------shiro已经加载----------------");
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(authRealm); // 加入用户数据源
        manager.setRememberMeManager(rememberMeManager()); // 加入记住我管理器
//        manager.setSessionManager(sessionManager);
//        manager.setCacheManager(redisCacheManager);
        return manager;
    }

    //配置自定义的权限登录器
    @Bean(name="authRealm")
    public AuthRealm authRealm(@Qualifier("credentialsMatcher") CredentialsMatcher matcher) {
        AuthRealm authRealm=new AuthRealm();
        authRealm.setCredentialsMatcher(matcher);
        return authRealm;
    }

    //配置自定义的密码比较器
    @Bean(name="credentialsMatcher")
    public CredentialsMatcher credentialsMatcher() {
        return new CredentialsMatcher();
    }

    // 配置会话管理器
    @Bean(name = "sessionManager")
    public SessionManager sessionManager(@Qualifier("redisSessionDAO") RedisSessionDAO redisSessionDAO) {
        SessionManager sessionManager = new DefaultWebSessionManager();
        ((DefaultWebSessionManager) sessionManager).setSessionDAO(redisSessionDAO);
//        ((DefaultWebSessionManager) sessionManager).setCacheManager(catheManage());
        return sessionManager;
    }

    // 配置会话操作
    @Bean(name = "redisSessionDAO")
    public RedisSessionDAO redisSessionDAO(@Qualifier("redisManage") RedisManager redisManager) {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager);
        return redisSessionDAO;
    }

    // 配置shiro redisManage
    @Bean(name = "redisManage")
    public RedisManager redisManage() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setExpire(1800);// 配置缓存过期时间
        redisManager.setPassword(password);
        return redisManager;
    }

    //cacheManager 缓存，使用redis实现
    @Bean(name = "catheManager")
    public RedisCacheManager catheManage(@Qualifier("redisManage") RedisManager redisManager) {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager);
        return redisCacheManager;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }

    /*
    * cookie 管理器
    * */
    @Bean
    public CookieRememberMeManager rememberMeManager() {
//        logger.info("注入Shiro的记住我(CookieRememberMeManager)管理器-->rememberMeManager", CookieRememberMeManager.class);
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        //rememberme cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度（128 256 512 位），通过以下代码可以获取
//         KeyGenerator keygen = KeyGenerator.getInstance("AES");
//        SecretKey deskey = keygen.generateKey();
//        System.out.println(Base64.encodeToString(deskey.getEncoded()));
//        SecureRandom random=SecureRandom.getInstance("SHA1PRNG");
//        random.setSeed("rememberMe".getBytes());
//        keygen.init(128, random);
//        SecretKey skey = keygen.generateKey();
        byte[] cipherKey = Base64.decode("6ZmI6I2j5Y+R5aSn5ZOlAA==");
//        byte[] cipherKey = Base64.decode(skey.getEncoded());
        cookieRememberMeManager.setCipherKey(cipherKey);
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }
    @Bean
    public SimpleCookie rememberMeCookie() {
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //如果httyOnly设置为true，则客户端不会暴露给客户端脚本代码，使用HttpOnly cookie有助于减少某些类型的跨站点脚本攻击；
        simpleCookie.setHttpOnly(true);
        //记住我cookie生效时间,默认30天 ,单位秒：60 * 60 * 24 * 30
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }
}
