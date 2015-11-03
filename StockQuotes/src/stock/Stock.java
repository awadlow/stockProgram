// 		EGR327 Project
// 		StockLogic.java
//		Created 10/25/15	ARW
//		This class is used to manipulate the quotes for Stock Quotes
// 		REVISION HISTORY
//		DATE			BY				DETAILS
//		

package stock;

public class Stock {
	
	String quote = "";
	String symbol = "ATVI";
	
	
	void parseQuote(String symbol)
	{
		try {
			quote = GetQuote.getStockQuote(symbol);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String delims = "[, \"]";
	
		String stockInfos[] = quote.split(delims);
		
		for(int cnt = 0; cnt < stockInfos.length; cnt++)    //REMOVE: Used to test the parsing
		{													
		System.out.println(stockInfos[cnt]);
		}
		
		symbol = stockInfos[8];  //Based on location after parsing
		
		//TODO: Assign the rest of the variables (EPS, Volume, etc.)
		
		
	}

}
