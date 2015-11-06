// 		EGR327 Project
// 		StockLogic.java
//		Created 10/25/15	ARW
//		This class is used to manipulate the quotes for Stock Quotes
// 		REVISION HISTORY
//		DATE			BY				DETAILS
//		11/3/15			ARW				EPS, Ask, and Bid assigned. parseQuote written
//

package stock;

public class Stock {
	
	public static final int numberPlace = 2; //Based on where data is after parsing quote
	
	String quote = "";
	String stockSymbol = "";
	String realTimeAsk = "";
	String realTimeBid = "";
	String volumeCharacters = "";
	
	Double eps = 0.0;
	Double ask = 0.0;
	Double bid = 0.0;
	Double volume = 0.0;
	
	
	
	
	void parseQuote(String symbol)
	{
		try {
			quote = GetQuote.getStockQuote(symbol);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String delims = "[, \"]";
	
		String stockInfos[] = quote.split(delims);
		
		for(int cnt = 0; cnt < stockInfos.length; cnt++)   //Iterates through parsed quote string array
		{					
		
			System.out.println(cnt+ " : " + stockInfos[cnt]);
			
			if(stockInfos[cnt].equals("EarningsShare"))
			{
				eps = Double.parseDouble(stockInfos[cnt + numberPlace]); //cnt + numberPlace represents
			}															 //data placement after parsing
			
			else if(stockInfos[cnt].equals("Ask"))
			{
				ask = Double.parseDouble(stockInfos[cnt + numberPlace]);
			}
			
			else if(stockInfos[cnt].equals("Bid"))
			{
				bid = Double.parseDouble(stockInfos[cnt + numberPlace]);
			}
			
			else if(stockInfos[cnt].equals("Volume"))
			{
				volume = Double.parseDouble(stockInfos[cnt + numberPlace]);
				checkVolumeNumber(volume);
			}
			
			else if(stockInfos[cnt].equals("AskRealtime"))
			{
				realTimeAsk = stockInfos[cnt + numberPlace];
			}
			
			else if(stockInfos[cnt].equals("BidRealtime"))
			{
				realTimeBid = stockInfos[cnt + numberPlace];
			}

			//TODO: Assign the rest of the variables (EPS, Volume, etc.)
		}
		
		
	}		
				
	String checkVolumeNumber(Double volumeNumber)
	{
		if (volumeNumber <= 999999)
		{
			volumeCharacters = volumeNumber.toString().substring(0, 3) + "," + 
								volumeNumber.toString().substring(3, 6);   //Creates a string with format
		}																   //of "100,000" for volume 
		
		else if (volumeNumber >= 1000000 && volumeNumber <= 100000000) //Shortens volume to "10.2M" format
		{
			volumeNumber = (volumeNumber/1000000);
			
			if(volumeNumber < 10)
			{
				volumeCharacters = (volumeNumber.toString().substring(0, 3) + "M"); 
			}
			
			else if(volumeNumber >= 10)
			{
				volumeCharacters = (volumeNumber.toString().substring(0, 4) + "M");
			}
			
		}

		return volumeCharacters;
	}
	
		
	

}
