import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class addComment extends baseTest {
    public addComment() throws Exception {
    }

    @Test
    public void comment()
    {
        RestAssured.baseURI = secrets.getBaseURI();


        String res1 = given().auth().preemptive().basic(secrets.getUsername(), secrets.getPassword()).pathParam(values.getIssueKey(), values.getIssueID()).log().all()
                .header(values.getContentType(), values.getHeaderValue())
                .body(utilities.commentBody()).when().post(values.getCommentResource())
                .then().log().all()
                .extract().response().asString();
    }
}


