package project;

public class Test {

	public static void main(String[] args) {
		User user=new User();
		user.setName("gl");
		
		UserDao userDao=new UserDao();
		
		userDao.addUser(user);

	}

}
