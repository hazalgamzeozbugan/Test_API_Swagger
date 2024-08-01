import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ApiIntegrationTestSwagger {
    private static final String BASE_URL = "http://generator.swagger.io";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }
    @Test
    public void testGetEndpoint() {
        Response response = RestAssured
                .given()
                .when()
                .get("/api/gen/clients");

        int statusCode = response.getStatusCode();
        if (statusCode == 200) {
            System.out.println("GET isteği başarılı.");
        } else {
            System.out.println("GET isteği başarısız.");
        }
        assertEquals(statusCode, 200, "GET isteği başarısız.");
    }
}