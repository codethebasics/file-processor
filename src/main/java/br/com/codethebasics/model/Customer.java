package br.com.codethebasics.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@XmlRootElement
public class Customer {

    @XmlElement
    private String uuid;

    private Integer age;

    private String name;

    public Customer() {
    }

    public Customer(Integer age, String name) {
        this.uuid = UUID.randomUUID().toString();
        this.age = age;
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public Integer getAge() {
        return age;
    }

    @XmlElement
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
}
