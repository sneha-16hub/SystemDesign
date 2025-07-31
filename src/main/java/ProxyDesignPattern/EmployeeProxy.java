package ProxyDesignPattern;

public class EmployeeProxy implements EmployeeDetails{
	EmployeeDetails e;
	EmployeeProxy(){
		e=new EmployeeClass();
	}
	@Override
	public void create(String client,EmployeeDetails obj) throws Exception {
		if(client.equals("ADMIN")) {
			e.create(client, obj);
			return;
		}
		throw new Exception("Access denied");
		
	}
	@Override
	public void delete(String client,int id) throws Exception {
		if(client.equals("ADMIN")) {
			e.delete(client, id);
			return;
		}
		
		throw new Exception("Access denied");
	}

}
