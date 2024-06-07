package api.noPojo;

import api.Pojo.specifications.Specifications;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetstoreTest {

    private static final String URL = "https://petstore.swagger.io/v2";

    @Test
    public void createUser() {
        Specifications.instalSpecification(Specifications.requestSpec(URL),
                Specifications.responseSpec200());

        Map<String, Object> user = new HashMap<>();
        user.put("id", 567456);
        user.put("username", "Artyom1234");
        user.put("firstName", "Sa");
        user.put("lastName", "An");
        user.put("email", "mailmail@gmail.com");
        user.put("password", "password12345");
        user.put("phone", "89775678789");
        user.put("userStatus", 0);
        Response response = given()
                .body(user)
                .when()
                .post("/user")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int code = jsonPath.get("code");
        String message = jsonPath.get("message");

        Assert.assertEquals(200, code);
        Assert.assertEquals("567456", message);
    }

    @Test
    public void checkUserInfo() {
        Specifications.instalSpecification(Specifications.requestSpec(URL),
                Specifications.responseSpec200());

        Response response = given()
                .when()
                .get("/user/Artyom1234")
                .then().log().all()
                .body("id", equalTo(567456))
                .body("username", equalTo("Artyom1234"))
                .body("firstName", equalTo("Sa"))
                .body("lastName", equalTo("An"))
                .body("email", equalTo("mailmail@gmail.com"))
                .body("password", equalTo("password12345"))
                .body("phone", equalTo("89775678789"))
                .body("userStatus", equalTo(0))
                .extract().response();
    }

    @Test
    public void updateUser() {
        Specifications.instalSpecification(Specifications.requestSpec(URL),
                Specifications.responseSpec200());

        Map<String, Object> user = new HashMap<>();
        user.put("id", 999777);
        user.put("username", "Matvey123456");
        user.put("firstName", "La");
        user.put("lastName", "Ba");
        user.put("email", "ramdaml@gmail.com");
        user.put("password", "wpassword098765");
        user.put("phone", "89775678333");
        user.put("userStatus", 0);
        Response response = given()
                .body(user)
                .when()
                .put("/user/Artyom1234")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int code = jsonPath.get("code");
        String message = jsonPath.get("message");

        Assert.assertEquals(200, code);
        Assert.assertNotNull(message);
        Assert.assertTrue(message.matches("^\\d+$"));//строка состоит только из цифр
    }

    @Test
    public void deleteUser() {
        Specifications.instalSpecification(Specifications.requestSpec(URL),
                Specifications.responseSpec200());

        Response response = given()
                .when()
                .delete("/user/Matvey123456")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int code = jsonPath.get("code");
        String message = jsonPath.get("message");

        Assert.assertEquals(200, code);
        Assert.assertEquals("Matvey123456", message);
    }
}
