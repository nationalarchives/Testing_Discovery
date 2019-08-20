package records_API;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Discovery_API_Records_Collection {

	@Test
	public void verifyRecords_Details() throws InterruptedException {

		Response resp = given().accept(ContentType.JSON).when().get(
				"http://test.discovery.nationalarchives.gov.uk/API/records/v1/collection/WO 339/72331?source=TNA&direction=NEXT");
		System.out.println("The status code is " + resp.asString());
		System.out.println("The status code is " + resp.statusCode());
		int Actual = resp.statusCode();
		System.out.println(Actual);

		// System.out.println("The status cod is " +resp.statusCode());

		Assert.assertEquals(Actual, 200);
		if (resp.statusCode() == 200) {

			System.out.println("status code verified");
		}

		else

		{
			System.out.println("status code is not verified");
		}
	}

}
