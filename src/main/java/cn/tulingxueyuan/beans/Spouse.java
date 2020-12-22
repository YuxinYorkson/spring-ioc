package cn.tulingxueyuan.beans;

public class Spouse {
    private String name;
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Spouse() {
        System.out.println("Spouse已加载");
    }

    public Spouse(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Spouse{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
