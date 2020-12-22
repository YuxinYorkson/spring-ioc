package cn.tulingxueyuan.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Person implements InitializingBean, DisposableBean {
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private List<String> hobbies;
    private Map<Integer,String> course;
    private Spouse spouse;

    public Person() {
        System.out.println("Person已加载");
    }

    public Person(Spouse spouse2) {
        this.spouse = spouse2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<Integer, String> getCourse() {
        return course;
    }

    public void setCourse(Map<Integer, String> course) {
        this.course = course;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", hobbies=" + hobbies +
                ", course=" + course +
                ", spouse=" + spouse +
                '}';
    }

    public static Person createPersonFactory() {
        Child child = new Child();
        child.setName("儿子");
        return child;
    }

    public void destroy() throws Exception {
        System.out.println("销毁Person");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("实例化Person");
    }

    public void initByXmlConfig() throws Exception {
        System.out.println("XML---实例化Person");
    }

    public void destroyByXmlConfig() throws Exception {
        System.out.println("XML--销毁Person");
    }
}
