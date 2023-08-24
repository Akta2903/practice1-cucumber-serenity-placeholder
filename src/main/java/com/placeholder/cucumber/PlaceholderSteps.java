package com.placeholder.cucumber;

import com.placeholder.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PlaceholderSteps {

    @Step("Getting all the posts ")
    public ValidatableResponse getPostsInfo()
    {
        return SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_POSTS)
                .then();
    }

    @Step("Getting single post with userId = {0}")
    public ValidatableResponse getPostByUserId(int userId)
    {
        return SerenityRest.given()
                .pathParam("userId",userId)
                .when()
                .get(EndPoints.GET_SINGLE_POSTS_BY_userID)
                .then().log().all();
    }
}
