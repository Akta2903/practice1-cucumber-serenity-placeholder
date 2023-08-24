package com.placeholder.cucumber.steps;

import com.placeholder.cucumber.PlaceholderSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasKey;

public class MyStepdefs {

    static ValidatableResponse response;
    @Steps
    PlaceholderSteps placeholderSteps;
    @When("^User sends a GET request to posts endpoint$")
    public void userSendsAGETRequestToPostsEndpoint() {
        response = placeholderSteps.getPostsInfo();

    }

    @Then("^User must get back a valid status code 200$")
    public void userMustGetBackAValidStatusCode() {
        response.statusCode(200);
    }

    @When("^User sends a GET reques with userId to posts endpoint$")
    public void userSendsAGETRequesWithUserIdToPostsEndpoint() {
        response = placeholderSteps.getPostByUserId(1);

    }

    @Then("^Response body has userId key \"([^\"]*)\"$")
    public void responseBodyHasUserIdKey(String userId)  {
        response = placeholderSteps.getPostByUserId(1);
        response.statusCode(200).log().all();
        HashMap<String,?> postMap = response.extract().path("");
        Assert.assertThat(postMap,hasKey(userId));
    }

    @And("^Response body has id key \"([^\"]*)\"$")
    public void responseBodyHasIdKey(String id) {
        response = placeholderSteps.getPostByUserId(1);
        response.statusCode(200).log().all();
        HashMap<String,?> postMap = response.extract().path("");
        Assert.assertThat(postMap,hasKey(id));
    }

    @And("^Response body has title key \"([^\"]*)\"$")
    public void responseBodyHasTitleKey(String title)  {
        response = placeholderSteps.getPostByUserId(1);
        response.statusCode(200).log().all();
        HashMap<String,?> postMap = response.extract().path("");
        Assert.assertThat(postMap,hasKey(title));

    }

    @And("^Response body has body key \"([^\"]*)\"$")
    public void responseBodyHasBodyKey(String body) {
        response = placeholderSteps.getPostByUserId(1);
        response.statusCode(200).log().all();
        HashMap<String,?> postMap = response.extract().path("");
        Assert.assertThat(postMap,hasKey(body));

    }


}
