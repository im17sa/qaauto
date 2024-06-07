package api.Pojo.tests;

import api.Pojo.Get.Pet.SuccessFindPet;
import api.Pojo.Post.createUserInPetstore.Creation;
import api.Pojo.Post.createUserInPetstore.SuccessCreation;
import api.Pojo.Put.updateUserInPetstore.SuccessUpdate;
import api.Pojo.Put.updateUserInPetstore.Update;
import api.Pojo.specifications.Specifications;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PetstoreTests {

    private static final String URL = "https://petstore.swagger.io/v2";

    @Test
    public void successCreationTest() {
        Specifications.instalSpecification(Specifications.requestSpec(URL),
                Specifications.responseSpec200());

        Integer code = 200;
        String message = "567456";

        Creation user = new Creation(
                567456,
                "Artyom1234",
                "Sa",
                "An",
                "mailmail@gmail.com",
                "password12345",
                "89775678789",
                0
        );
        SuccessCreation successCreation = given()
                .body(user)
                .when()
                .post("/user")
                .then().log().all()
                .extract().as(SuccessCreation.class);

        Assert.assertNotNull(successCreation.getCode());
        Assert.assertNotNull(successCreation.getMessage());

        Assert.assertEquals(code, successCreation.getCode());
        Assert.assertEquals(message, successCreation.getMessage());
    }

    @Test
    public void successUpdateTest() {
        Specifications.instalSpecification(Specifications.requestSpec(URL),
                Specifications.responseSpec200());

        Integer code = 200;

        Update user = new Update(
                999777,
                "Matvey123456",
                "La",
                "Ba",
                "ramdaml@gmail.com",
                "wpassword098765",
                "89775678333",
                0
        );
        SuccessUpdate successUpdate = given()
                .body(user)
                .when()
                .put("/user/Artyom1234")
                .then().log().all()
                .extract().as(SuccessUpdate.class);

        Assert.assertNotNull(successUpdate.getCode());
        Assert.assertNotNull(successUpdate.getMessage());

        Assert.assertEquals(code, successUpdate.getCode());
        Assert.assertTrue(successUpdate.getMessage().matches("^\\d+$"));
    }

    @Test
    public void successFindPetTest() {
        Specifications.instalSpecification(Specifications.requestSpec(URL),
                Specifications.responseSpec200());

        Integer id = 788;
        String name = "doggie";
        String status = "available";

        SuccessFindPet successFindPet = given()
                .when()
                .get("/pet/788")
                .then().log().all()
                .extract().as(SuccessFindPet.class);

        Assert.assertNotNull(successFindPet.getId());
        Assert.assertNotNull(successFindPet.getCategory());
        Assert.assertNotNull(successFindPet.getName());
        Assert.assertNotNull(successFindPet.getPhotoUrls());
        Assert.assertNotNull(successFindPet.getTags());
        Assert.assertNotNull(successFindPet.getStatus());

        Assert.assertEquals(id, successFindPet.getId());
        Assert.assertEquals(id, successFindPet.getCategory().getId());
        Assert.assertEquals(name, successFindPet.getName());
        Assert.assertEquals(id, successFindPet.getTags().get(0).getId());
        Assert.assertEquals(status, successFindPet.getStatus());
    }
}
