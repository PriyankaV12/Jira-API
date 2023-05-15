import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class verifyDetails extends baseTest {

    public verifyDetails() throws Exception {
    }

    @Test
    public void details()
    {
        RestAssured.baseURI = secrets.getBaseURI();

        String res1 = given().auth().preemptive().basic(secrets.getUsername(), secrets.getPassword()).pathParam(values.getIssueKey(), values.getIssueID())
                .queryParam(values.getQueryParamKey(), values.getQueryParamValue())
                .log().all()
                .when().get(values.getResource())
                .then().log().all()
                .extract().response().asString();
    }
}
