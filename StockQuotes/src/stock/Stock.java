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
	String stockSymbol = "";
	Double EPS = 0.0;
	Double Ask = 0.0;
	Double Bid = 0.0;
	
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
		
			//System.out.println(cnt+ " : " + stockInfos[cnt]);
			
			if(stockInfos[cnt].equals("EarningsShare"))
			{
				EPS = Double.parseDouble(stockInfos[cnt + 2]);
			}
			
			else if(stockInfos[cnt].equals("Ask"))
			{
				Ask = Double.parseDouble(stockInfos[cnt + 2]);
			}
			
			else if(stockInfos[cnt].equals("Bid"))
			{
				Bid = Double.parseDouble(stockInfos[cnt + 2]);
			}
		}
		
						//Based on location after parsing
				
	
		
		
		
		//TODO: Assign the rest of the variables (EPS, Volume, etc.)
		
		
	}

}
