package ProxyDesignPattern;

public class Client {

	public static void main(String[] args) {
		try {
			EmployeeDetails emp=new EmployeeProxy();
			emp.create("ADMIN", new EmployeeClass());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
