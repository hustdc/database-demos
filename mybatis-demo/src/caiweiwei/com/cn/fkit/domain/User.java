package caiweiwei.com.cn.fkit.domain;

public class User {
	private Integer id;
	private String name;
	private String sex;
	private Integer age;
	// 无参构造函数
	public User() {
		
	}
	
	// 有参构造函数
	public User(String name, String sex, Integer age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
	
	// setter and getter
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
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
}
