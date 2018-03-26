package training.customer;

public class CustomerService {

	private CustomerDAO customerDAO = new CustomerDAOImpl();

	public Customer addCustomer(Customer customer) {
		if (customerDAO.getCustomer(customer.getName()) != null) {
			return null;
		}

		return customerDAO.saveCustomer(customer);
	}

}