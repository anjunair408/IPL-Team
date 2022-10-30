package Library_API;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class IPLTeam {
	
	@Test(priority=1)
	public void addBook(String isbn,String aisle)
	{
		
		RestAssured.baseURI="";
		int countForeign=0;
		
		String stringResponse=given()
		.body(Payload.payloadAPI()).when().get()
	    .then().log().all().extract().response().asString();
		
		JsonPath js=Payload.rawtoJson(stringResponse);
		int foreignount=js.getInt("player.country");
		for(int i=0;i<foreignount;i++)
		{
			if(js.get("player.country")!="India")
			{
				countForeign++;
			}
		}
		
		Assert.assertEquals(countForeign,4);
		
	}
	
}
