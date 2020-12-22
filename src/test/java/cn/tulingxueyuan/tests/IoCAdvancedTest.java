package cn.tulingxueyuan.tests;

import cn.tulingxueyuan.beans.Person;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCAdvancedTest {

    private ClassPathXmlApplicationContext context;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("spring-ioc-advanced.xml");
    }

    /**
     * 控制bean的加载顺序
     */
    @Test
    public void test01() {
        System.out.println("Spring已加载");
    }

    /**
    * 懒加载
    */
    @Test
    public void test02() {
        System.out.println("懒加载Test");
        /*Spouse spouse = context.getBean("spouse1",Spouse.class);
        System.out.println(spouse);*/
    }

    /**
     * 作用域
     */
    @Test
    public void test03() {
        //singleton
        Person person1 = context.getBean("person", Person.class);
        Person person2 = context.getBean("person", Person.class);
        System.out.println(person1);
        System.out.println(person2);

        //prototype
        Person person3 = context.getBean("person1", Person.class); // new Person();
        Person person4 = context.getBean("person1", Person.class); // new Person();
        System.out.println(person3);
        System.out.println(person4);
    }

    /**
     * 使用静态工厂方法来实例化Bean
     */
    @Test
    public void test04() {
        Person person = context.getBean("person2", Person.class);
        System.out.println(person);
    }

    /**
     * 使用实例工厂方法来实例化Bean
     */
    @Test
    public void test05() {
        Person person = context.getBean("person3", Person.class);
        System.out.println(person);
    }

    /**
     * 自动注入
     * byType byName
     */
    @Test
    public void test06() {
        Person person = context.getBean("person4", Person.class);
        System.out.println(person);
    }

    /**
     * 生命周期
     * 1. 使用接口的方式实现：
     *  1> 初始化回调  InitializingBean，重写afterPropertiesSet()方法
     *  2> 销毁回调  实现DisposableBean，重写destroy()方法
     */
    @Test
    public void test07() {
        Person person1 = context.getBean("person5", Person.class);
        Person person2 = context.getBean("person6", Person.class);
        System.out.println(person1);
        System.out.println(person2);
        context.close();
    }

    /**
     * 第三方bean和外部属性文件
     */
    @Test
    public void test08() {
        DruidDataSource datasource = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(datasource);
    }

    /**
     * SpEL
     */
    @Test
    public void test09() {
        Person person = context.getBean("person7", Person.class);
        System.out.println(person);
    }

}
