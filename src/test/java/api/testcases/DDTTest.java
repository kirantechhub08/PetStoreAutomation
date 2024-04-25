package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProvider;
import io.restassured.response.Response;

public class DDTTest {
	
	@Test(priority = 1, dataProvider = "LoginData", dataProviderClass = DataProvider.class)
	public void TestPostUser(String userId, String uName, String fname, String lname,String userEmail, String pass,String ph ) {
		
		User u = new User();
		u.setId(Integer.parseInt(userId));
		u.setUsername(uName);
		u.setFirstname(fname);
		u.setLastname(lname);
		u.setEmail(userEmail);
		u.setPassword(pass);
		u.setPhone(ph);
		
		Response re=UserEndPoints.createUser(u);
		Assert.assertEquals(re.getStatusCode(), 200);
		
	}
	
	
	@Test(priority = 2, dataProvider = "UserName", dataProviderClass = DataProvider.class)
	public void testDeleteUser(String uname)
	{
		
		Response res=UserEndPoints.delete(uname);
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}

}
