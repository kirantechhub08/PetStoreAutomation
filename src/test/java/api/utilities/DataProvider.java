package api.utilities;

import java.io.IOException;



public class DataProvider {
	
	@org.testng.annotations.DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
	
		String xFile=System.getProperty("user.dir") + "\\RestAPITestData.xlsx";
		int rowcount=XLUtility.getRowCount(xFile, "Sheet1");
		int cellCount=XLUtility.getCellCount(xFile, "Sheet1", 0);
		
		String[][] data= new String[rowcount][cellCount];
		
		for(int i=1;i<=rowcount; i++)
		{
			for(int j=0;j<cellCount; j++)
			{
				data[i-1][j]=XLUtility.getCellData(xFile, "Sheet1", i, j);
			}
		}
		
		return data;
		
	}
	
	
	@org.testng.annotations.DataProvider(name="UserName")
	public String[] getUsername() throws IOException {
		
		String xFile=System.getProperty("user.dir") + "\\RestAPITestData.xlsx";
		int rowcount=XLUtility.getRowCount(xFile, "Sheet1");
		
		String[] data= new String[rowcount];
		for(int i=1; i<=rowcount; i++)
		{
			data[i-1]=XLUtility.getCellData(xFile, "Sheet1", i, 1);
		}
		
		return data;
	
		

		
		
	}

}
