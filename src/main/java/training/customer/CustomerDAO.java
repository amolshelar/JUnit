package training.customer;

public interface CustomerDAO {

	Customer getCustomer(String name);

	boolean saveCustomer(Customer customer);

	void deleteCustomer(Integer id);

}
