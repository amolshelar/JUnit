package training.customer;

public interface CustomerDAO {

	Customer getCustomer(String name);

	Customer saveCustomer(Customer customer);

	void deleteCustomer(Integer id);

}
