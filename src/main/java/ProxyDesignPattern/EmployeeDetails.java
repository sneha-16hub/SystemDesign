package ProxyDesignPattern;

public interface EmployeeDetails {
	public void create(String Client,EmployeeDetails e) throws Exception;
	public void delete(String Client,int id) throws Exception;
	

}
