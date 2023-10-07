package com.ah.bean;

public class User {
	//�û�ID
		private Integer id;
		//�û���
		private String username;
		//����
		private String password;
		//����
		private Integer age;
		//�Ա�
		private String sex;
		//״̬
		private Integer status;
		public User(){
			
		}
		public User(Integer id, String username, String password, Integer age, String sex, Integer status) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.age = age;
			this.sex = sex;
			this.status = status;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
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
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		
		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", sex=" + sex
					+ ", status=" + status + "]";
		}
		
		
		
			
}
