package Library_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class IPLTeam {
	
	@Test(priority=1)
	public void iplTeamSelection()
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
	
	@Test(priority=2)
	public void findWicketKeeper()
	{
		RestAssured.baseURI="";
		String keeperResponse=given()
				.body(Payload.payloadAPI()).when().get()
			    .then().log().all().extract().response().asString();

		       JsonPath js=Payload.rawtoJson(keeperResponse);
			   int keeperCount=js.getInt("player.role");

				for(int i=0; i<=keeperCount; i++)
				{
				   if(js.getString("player.role").equalsIgnoreCase("Wicket-keeper"))
				    {
				      System.out.println("Wicket-keeper found");
				     break;
				     }
				}

				Assert.assertEquals(keeperCount,"Wicket-keeper");
	}
	
}
