// 		EGR327 Project
// 		Stock.java
//		Created 10/25/15	ARW
//		This class is used to manipulate the quotes for Stock Quotes
// 		REVISION HISTORY
//		DATE			BY				DETAILS
//		11/3/15			ARW				EPS, Ask, and Bid assigned. parseQuote written
//		11/12/15		ARW 			Added get functions and made variables private
//		11/12/15		ARW				Assigned more variables. checkPercent added. checkTime added
//		11/15/15		ARW				Added functions for Compare EPS and changed CheckTime to isTradingHours
//		12/3/15		    ARW				Added Error checking to parse quote
//		12/5/15			ARW				Optimized speed of parse quote and modularized code 
//		12/7/15			ARW				Fixed bug in checkTime function and checkVolume function

package stock;

import java.util.Date;
import java.util.TimeZone;

public class Stock {
	
	public static final int numberPlace = 2; //Based on where data is after parsing quote
	
	String quote = "";
	String stockSymbol = "";
	
	private String realTimeAsk = "NA";
	private String realTimeBid = "NA";
	private String volumeCharacters = "NA";
	private String percentChange = "NA";
	private String divShare = "NA"; 
	
	private Double eps = 0.000;
	private Double ask = 0.000;
	private Double bid = 0.000;
	private Double volume = 0.000;
	private boolean stockSymbolValid = true;
	
	
	
	
	boolean parseQuote(String symbol)
	{
		try {
			quote = GetQuote.getStockQuote(symbol);
		} catch (Exception e){ 
			System.out.println("THE STOCK SYMBOL COULD NOT BE FOUND.");
			stockSymbolValid = false;
			return false;
		}
		
		stockSymbol = symbol.toUpperCase();
		
		String delims = "[, \"]";
	
		String stockInfos[] = quote.split(delims);
		
		for(int cnt = 0; cnt < stockInfos.length; cnt++)   //Iterates through parsed quote string array
		{					
		
			System.out.println(cnt+ " : " + stockInfos[cnt]);
			
			if(stockInfos[cnt].equals("EBITDA") && (stockInfos[cnt + 1].equals(":null")))
			{
				System.out.println("NOT A VALID STOCK SYMBOL");
				stockSymbolValid = false;
				return false;
			}
			
			else{
				if(stockInfos[cnt].equals("EarningsShare") && 
						isValidData(stockInfos, cnt))
				{
					eps = Double.parseDouble(stockInfos[cnt + numberPlace]); //cnt + numberPlace represents
				}															 //data placement after parsing
				
				else if(stockInfos[cnt].equals("Ask") && 
						isValidData(stockInfos, cnt))
				{
					ask = Double.parseDouble(stockInfos[cnt + numberPlace]);
				}
				
				else if(stockInfos[cnt].equals("Bid") && 
						isValidData(stockInfos, cnt))
				{
					bid = Double.parseDouble(stockInfos[cnt + numberPlace]);
				}
				
				else if(stockInfos[cnt].equals("Volume") && 
						isValidData(stockInfos, cnt))
				{
					volume = Double.parseDouble(stockInfos[cnt + numberPlace]);
					checkVolumeNumber(volume);
				}
				
				else if(stockInfos[cnt].equals("AskRealtime") && 
						isValidData(stockInfos, cnt))
				{
					realTimeAsk = stockInfos[cnt + numberPlace];
				}
				
				else if(stockInfos[cnt].equals("BidRealtime") && 
						isValidData(stockInfos, cnt))
				{
					realTimeBid = stockInfos[cnt + numberPlace];
				}
				
				else if(stockInfos[cnt].equals("PercentChange") && 
						isValidData(stockInfos, cnt))
				{
					percentChange = stockInfos[cnt + numberPlace];
				}
				
				else if(stockInfos[cnt].equals("DividendShare") && 
						isValidData(stockInfos, cnt))
				{
					divShare = stockInfos[cnt + numberPlace];
				}
				
			}
			//TODO: Assign the rest of the variables (EPS, Volume, etc.)
		}
		
		return true;
	}		
				
	String checkVolumeNumber(Double volumeNumber)
	{
		if (volumeNumber < 100000)
		{
			volumeCharacters = volumeNumber.toString();
		}
		
		else if (volumeNumber <= 999999)
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
	
	boolean checkPercentChange()
	{
		if(percentChange.startsWith("+")) //Check to see if gains were positive
		{
			return true;
		}
		
		else
			return false;
	}
		
	boolean isTradingHours() //Checks to see if trading is open 
	{
		TimeZone.setDefault(TimeZone.getTimeZone("EST"));
		Date currentTime = new Date();
		String currentTimeString = currentTime.toString();
		
		String delims = "[\\s+]";
		
		String timeInfo[] = currentTimeString.split(delims);
		
		String timeEST = timeInfo[3];
	
		double hour = 0;
		double minutes = 0;
		String day = "";
		
		hour = Double.parseDouble(timeEST.substring(0, 2)); //Store hour in "HH" format - 24 hr time
		minutes = Double.parseDouble(timeEST.substring(3, 5)); //Store minute in "MM" format
		day = timeInfo[0]; //Store the day of the week based on its location in the string
		
		System.out.println("Hour = " + hour + "Minutes = " + minutes);
		
		if( (((hour == 9 && minutes >= 30) && hour < 16) || (hour >= 10 && hour <= 16)) 
		  && !(day.equals("Sun"))  && !(day.equals("Sat"))) //Checks to see if the trading hours and days
		{													//are active
			return true;
		}
		
		else
			return false;
	}
	
	double getDifference(double otherEps)
	{
		double returnValueDifference;
		
		if(eps > otherEps)
		{
			returnValueDifference = Math.abs(eps - (otherEps));
			return returnValueDifference;
		}
		
		else
		{
			returnValueDifference = Math.abs(otherEps - (eps));
			return returnValueDifference;
		}
	}
	
	String getWinner(Stock otherStock)
	{
		if(eps == otherStock.getEps() && stockSymbol.equals(otherStock.getSymbol()))
		{
			return stockSymbol;
		}
		
		if(eps == otherStock.getEps() && !(stockSymbol.equals(otherStock.getSymbol())))
		{
			return (stockSymbol + otherStock.getSymbol());
		}
		
		else if(eps > otherStock.getEps())
			return stockSymbol;
		
		else
			return otherStock.getSymbol();
		
		
	}
	
	String getLoser(Stock otherStock)
	{
		
		if(eps.equals(otherStock.getEps()))
		{
			return "N/A";
		}
		
		else if(eps < otherStock.getEps())
			return stockSymbol;
		
		else
			return otherStock.getSymbol();
	}
	
	boolean isValidData(String stockQuote[],int counter)
	{
		
		if(stockQuote[counter + 1].equals(":null") ||
		stockQuote[counter + numberPlace].equals("0"))
		{
			return false;
		}
		
		else
			return true;
	}
	//Get Functions below here
	
	String getRealTimeAsk()
	{
		return realTimeAsk;
	}
	
	String getRealTimeBid()
	{
		return realTimeBid;
	}
	
	String getVolumeCharacters()
	{
		return volumeCharacters;
	}
	
	String getPercentChange()
	{
		return percentChange;
	}
	
	Double getEps()
	{
		return eps;
	}
	
	Double getAsk()
	{
		return ask;
	}
	
	Double getBid()
	{
		return bid;
	}
	
	Double getVolume()
	{
		return volume;
	}
	
	String getDivShare()
	{
		return divShare;
	}
	
	String getSymbol()
	{
		return stockSymbol;
	}

	boolean getstockSymbolValid()
	{
		return stockSymbolValid;
	}
	//End Get Functions

	
}
