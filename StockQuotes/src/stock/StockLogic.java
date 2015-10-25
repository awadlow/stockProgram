// 		EGR327 Project
// 		StockLogic.java
//		Created 10/25/15	ARW
//		This class is used to manipulate the quotes for Stock Quotes
// 		REVISION HISTORY
//		DATE			BY				DETAILS
//		

package stock;

public class StockLogic {
	
	String getStockQuote(String symbol)
	{
		String quote = "";
		
		GetQuote stockQuote = new GetQuote();
		
		try {
			quote = stockQuote.getStockQuote(symbol);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String delims = "[,]";
		String stockInfos[] = quote.split(delims);
		
		return stockInfos[2];
		
	}

}
