package carRentalSystem;

import java.util.List;


public class CarRentalSystem {
	List<Store> stores;
	List<User> users;
	public CarRentalSystem(List<Store> stores, List<User> users) {
		this.stores=stores;
		this.users=users;
	}
	
	void addUser(User user) {
		users.add(user);
	}
	void addStore(Store store) {
		stores.add(store);
	}
	void removeUser(User user) {
		
	}
	void removeStore(User store) {
		
	}

}
