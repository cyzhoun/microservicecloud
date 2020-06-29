package cn.test.pojo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Users的实体类
 * @author chongyu
 *
 */
public class Users {
	
	// 用户名
	@NotBlank(message="用户名不能为空")
	private String name;
	
	// 密码
	@NotBlank(message="密码不能为空")
	private String password;
	
	// 用户年龄
	@NotNull(message="年龄不能为空")
	private Integer age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Users [name=" + name + ", password=" + password + ", age=" + age + "]";
	}
	
	
}