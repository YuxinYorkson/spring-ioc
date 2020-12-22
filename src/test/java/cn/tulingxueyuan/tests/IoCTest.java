package cn.tulingxueyuan.tests;

import cn.tulingxueyuan.beans.Person;
import cn.tulingxueyuan.beans.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCTest {

    ApplicationContext context;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("spring-ioc.xml");
    }

    @Test
    public void test01() {
        //加载spring容器
//        ApplicationContext spring的顶层接口
//        ClassPathXmlApplicationContext 根据项目路径的xml配置来实例化spring容器
//        FileSystemXmlApplicationContext 根据磁盘路径的xml配合来实例化spring容器
//        AnnotationConfigApplicationContext 根据javaconfig来配置实例化spring容器
//        在容器实例化的时候，就会加载所有的bean
        System.out.println("Spring容器已加载");

        //获取bean
        //1. 通过类来获取bean context.getBean(User.class)
        //2. 通过bean的名字或id获取 (User) context.getBean("user")
        //3. 通过名字+类型 context.getBean("user", User.class)
        User user = context.getBean(User.class);
        System.out.println(user);
    }

    /**
     * 通过别名获取bean
     */
    @Test
    public void test02() {
        User user = context.getBean("tuling",User.class);
        System.out.println(user);
    }

    /**
     * 基于setter的注入
     * 对应setter方法的名字
     */
    @Test
    public void test03() {
        User user = context.getBean("user5",User.class);
        System.out.println(user);
    }

    /**
     * 基于constructor的注入
     */
    @Test
    public void test04() {
        User user = context.getBean("user6",User.class);
        System.out.println(user);
    }

    /**
     * 复杂数据类型的依赖注入
     */
    @Test
    public void test05() {
        Person person = context.getBean("person",Person.class);
        System.out.println(person);
    }

    /**
     * p命名空间
     */
    @Test
    public void test06() {
        Person person = context.getBean("person2",Person.class);
        System.out.println(person);
    }
}
