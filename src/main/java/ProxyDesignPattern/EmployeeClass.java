package ProxyDesignPattern;

public class EmployeeClass implements EmployeeDetails{
	@Override
	public void create(String client,EmployeeDetails e) {
		System.out.println("Employee Created");
	}
	@Override
	public void delete(String client,int id) {
		System.out.println("Employee Deleted");
	}
	

}
