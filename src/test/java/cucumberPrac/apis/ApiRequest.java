package cucumberPrac.apis;

import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

public class ApiRequest extends SpecBuilder{
    public static Response post(String endPoint, Headers header, HashMap<String, Object> formParam, Cookies cookies)
    {
        return given(getRequestSpec())
                .headers(header)
                .formParams(formParam)
                .cookies(cookies)
                .when()
                .post(endPoint)
                .then().spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response get(String endPoint, Cookies cookies)
    {
        return  given(getRequestSpec())
                .cookies(cookies)
                .when()
                .get(endPoint)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }
}
