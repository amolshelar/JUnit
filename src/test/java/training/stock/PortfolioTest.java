package training.stock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.atLeastOnce;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Matchers.any;

public class PortfolioTest {

	@Mock
	private StockService stockServiceMock;

	@InjectMocks
	Portfolio portfolio;

	@Before
	public void before() {
		portfolio = new Portfolio();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testMarketValue() {
		// Creates a list of stocks to be added to the portfolio
		List<Stock> stocks = new ArrayList<Stock>();
		Stock googleStock = new Stock("1", "Google", 5);
		Stock microsoftStock = new Stock("2", "Microsoft", 10);

		stocks.add(googleStock);
		stocks.add(microsoftStock);

		// add stocks to the portfolio
		portfolio.setStocks(stocks);

		// mock the behavior of stock service to return the value of various
		// stocks
		when(stockServiceMock.getPrice(googleStock)).thenReturn(50);
		when(stockServiceMock.getPrice(microsoftStock)).thenReturn(30);
		//when(stockServiceMock.getPrice(any(Stock.class))).thenReturn(100);

		double marketValue = portfolio.getMarketValue();
		assertEquals(marketValue, 550, 0);

		// verify the behavior
		verify(stockServiceMock).getPrice(googleStock);
		verify(stockServiceMock).getPrice(microsoftStock);

		verify(stockServiceMock, times(1)).getPrice(googleStock);
		verify(stockServiceMock, atLeastOnce()).getPrice(googleStock);

		// create an inOrder verifier for a single mock
		InOrder inOrder = inOrder(stockServiceMock);

		// following will make sure that add is first called then subtract is
		// called.
		inOrder.verify(stockServiceMock).getPrice(googleStock);
		inOrder.verify(stockServiceMock).getPrice(microsoftStock);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testMarketValue1() {
		List<Stock> stocks = new ArrayList<Stock>();
		Stock pgsStock = new Stock("1", "PGS", 5);

		stocks.add(pgsStock);

		// add stocks to the portfolio
		portfolio.setStocks(stocks);

		// mock the behavior of stock service to return the value of various
		// stocks
		when(stockServiceMock.getPrice(pgsStock)).thenThrow(IllegalArgumentException.class);

		double marketValue = portfolio.getMarketValue();
	}
}
