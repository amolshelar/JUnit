package training.stock;

import java.util.List;

public class Portfolio {

	private StockService stockService;
	private List<Stock> stocks;

	public double getMarketValue() {
		int marketValue = 0;
		for (Stock stock : stocks) {
			int stockPrice = stockService.getPrice(stock); // Get current stock price
			marketValue = marketValue + (stockPrice * stock.getQuantity());
		}
		return marketValue;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

}
