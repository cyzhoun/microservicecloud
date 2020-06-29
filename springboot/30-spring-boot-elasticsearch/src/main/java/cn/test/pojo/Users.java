package cn.test.pojo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * user VO 
 * @author chongyu
 *
 */
@Document(indexName="testone",type="users")
public class Users {

	@Id
	private Integer userid;// 用户id
	private String username;// 用户名
	private String address;// 用户地址
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date birthday;// 出生日期
	
	
	// getset方法
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username + ", address=" + address + ", birthday=" + birthday
				+ "]";
	}
}
