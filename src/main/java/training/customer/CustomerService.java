package training.customer;

public class CustomerService {

	private CustomerDAO customerDAO = new CustomerDAOImpl();

	public boolean addCustomer(Customer customer) {
		if (customerDAO.getCustomer(customer.getName()) != null) {
			return false;
		}

		return customerDAO.saveCustomer(customer);
	}

}