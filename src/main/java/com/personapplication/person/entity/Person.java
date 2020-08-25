package com.personapplication.person.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
import org.springframework.format.datetime.joda.DateTimeParser;

@Entity
@Table(name="person")
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "age")
	private float age;
	@Column(name = "sex")
	private String sex;
	@Column(name = "birthday")
	private Date birthday;
	@Column(name = "created")
	private Date created;
	@Column(name = "contacts")
	private String contacts;
	@Column(name = "email")
	private String email;
	@Column(name = "modified")
	private Date modified;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", sex=" + sex
				+ ", birthday=" + birthday + ", created=" + created + ", contacts=" + contacts + ", email=" + email
				+ ", modified=" + modified + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public Person(int id, String name, String surname, float age, String sex, Date birthday, Date created,
			String contacts, String email, Date modified) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
		this.created = created;
		this.contacts = contacts;
		this.email = email;
		this.modified = modified;
	}
	public Person() {
		super();
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public float getAge() {
		return age;
	}
	public void setAge(float age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
}
