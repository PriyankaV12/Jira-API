import gettersSetters.fileReader;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class addAttachments extends baseTest {

    public addAttachments() throws Exception {

    }

    @Test
    public void attachments()
    {
        RestAssured.baseURI = secrets.getBaseURI();
        String username = secrets.getUsername();
        String password = secrets.getPassword();

        String response =  given().auth().preemptive().basic(username, password).header(values.getAttachmentsHeaderKey(), values.getAttachmentsHeaderValue())
                .pathParam(values.getIssueKey(), values.getIssueID()).log().all()
                .header(values.getContentType(), values.getAttachmentsContentType())
                .multiPart("file", new File(values.getFilePathName()))
                .when().post(values.getAttachmentResource())
                .then().log().all()
                .extract().response().asString();

    }
}
