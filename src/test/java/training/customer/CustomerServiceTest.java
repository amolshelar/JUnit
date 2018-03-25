package training.customer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import training.customer.CustomerService;

public class CustomerServiceTest {

	@Mock
	private CustomerDAO daoMock;

	@InjectMocks
	CustomerService customerService = new CustomerService();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	//@Test
	public void testAddCustomerThrowsException() {
		Customer customer = new Customer();
		customerService.addCustomer(customer);
	}

	@Test
	public void testAddCustomerReturnsNewCustomer() {
		//when(daoMock.saveCustomer(any(Customer.class))).thenReturn(new Customer());

		Customer customer = new Customer();
		assertThat(customerService.addCustomer(customer), is(notNull()));
	}

}
