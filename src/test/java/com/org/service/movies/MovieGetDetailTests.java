package com.org.service.movies;

import com.org.service.ServiceErrorCode;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.parsing.Parser;
import org.json.JSONObject;


public class MovieGetDetailTests extends Movies {
    private String apiBaseUrl;

    public MovieGetDetailTests() {
        super();
        RestAssured.defaultParser = Parser.JSON;
        apiBaseUrl = setApiKeyParam(configRequestPath("get","details"));
    }

    /*
     * Test for retrieving movie details with valid movie id
     * Expected response - Test should return response with Movie Details entity of given id
     */
    @Test
    public void getMovieDetailsValidId() {
        // ID of movie under test
        Integer movieID = 157336;

        // Use Rest-Assured api to send request
        String response = RestAssured.given().contentType("application/json").log().all()
                            .pathParam("movie_id",movieID.toString())
                            .queryParam("language","en-US")
                            .body("{}")
                            .get(apiBaseUrl)
                            .asString();

        // Use log4j to log response to log file
        LOG.info(response);

        // Parse response into JSON Object
        JSONObject responseObject = new JSONObject(response);

        // Validate movie id in response the same as id used in the request
        Assert.assertTrue(responseObject.getInt("id") == movieID);

        // Additionally verify the movie title and status
        Assert.assertEquals(responseObject.getString("title"),"Interstellar");
        Assert.assertEquals(responseObject.getString("status"),"Released");
    }

    /*
     *  Test for retrieving movie details with invalid movie id
     *  Expected Response - Test should return response with error message and NOT_FOUND_ERROR status code
     */
    @Test
    public void getMovieDetailsInvalidId() {

        // Sending request with invalid movie id
        String response = RestAssured.given().contentType("application/json").log().all()
                .pathParam("movie_id","invalid")
                .queryParam("language","en-US")
                .body("{}")
                .get(apiBaseUrl)
                .asString();

        LOG.info(response);

        // Parse response into Json Object
        JSONObject responseObject = new JSONObject(response);

        // Validate error code and message in response match expected values
        Assert.assertTrue(responseObject.getInt("status_code") == ServiceErrorCode.NOT_FOUND_ERROR.getServiceErrorCode());
        Assert.assertEquals(responseObject.getString("status_message"), ServiceErrorCode.NOT_FOUND_ERROR.getServiceErrorMessage());
    }

    /*
     * Test for retrieving movie details with invalid API Key
     * Expected Response - Test should return response with error message and INVALID_API_KEY status code
     */
    @Test
    public void getMovieDetailsWithInvalidApiKey() {
        // Replace existing valid API key in the request to 'invalid'
        String urlWithInvalidKey = apiBaseUrl.replace(getApi_key(),"invalid");

        // Sending the request with invalid API Key
        String response = RestAssured.given().contentType("application/json").log().all()
                .pathParam("movie_id","invalid")
                .queryParam("language","en-US")
                .body("{}")
                .get(urlWithInvalidKey)
                .asString();

        LOG.info(response);

        // Parse response into Json Object
        JSONObject responseObject = new JSONObject(response);

        // Validate error code and message in response match expected values
        Assert.assertTrue(responseObject.getInt("status_code") == ServiceErrorCode.INVALID_API_KEY.getServiceErrorCode());
        Assert.assertEquals(responseObject.getString("status_message"),ServiceErrorCode.INVALID_API_KEY.getServiceErrorMessage());
    }

    /*
     * Test for retrieving movie details with videos request appended
     * Expected Response - Test should return response with Movies Details entity of given movie id including video details
     */
    @Test
    public void getMovieDetailsWithVideosAppend() {
        // Set movie id under test
        Integer movieID = 157336;

        // Use Rest-Assured api to send request
        String response = RestAssured.given().contentType("application/json").log().all()
                .pathParam("movie_id",movieID.toString())
                .queryParam("language","en-US")
                .queryParam("append_to_response","videos")
                .body("{}")
                .get(apiBaseUrl)
                .asString();

        // Log response into log file
        LOG.info(response);

        // Parse response into Json Object
        JSONObject responseObject = new JSONObject(response);

        // Validate movie id in response the same as id used in the request
        Assert.assertTrue(responseObject.getInt("id") == movieID);

        // Validate video list exists in the response
        JSONArray videoList = responseObject.getJSONObject("videos").getJSONArray("results");
        Assert.assertTrue(videoList.length() > 0);
    }

    /*
     * Test for retrieving movie details without specifying the language in the request query string for specific movie id
     * Expected Response - Test should return response with Movie Details entity of given id and default language - en-US
     */
    @Test(enabled = false)
    public void getMovieDetailsWithoutLanguageQuery() {
        // To Do
    }

    /*
     * Test for retrieving movie details with alternative titles appended
     * Expected Response - Test should return response with Movie Details entity of given movie id including details
      * about alternative titles
     */
    @Test(enabled = false)
    public void getMovieDetailsWithAlternativeTitles() {
        // To Do
    }

    /*
     * Test for retrieving movie details with the last 24 hour changes appended
     * Expected Response - Test should return response with Movie Details entity of given movie id including details about
     * the last 24 hour changes
     */
    @Test(enabled = false)
    public void getMovieDetailsWithChanges() {
        // To Do
    }

    /*
     * Test for retrieving movie details with Credits appended
     * Expected Response - Test should return response with Movie Details entity of given movie id including credits detail
     */
    @Test(enabled = false)
    public void getMovieDetailsWithCredit() {
        // To Do
    }

    /*
     * Test for retrieving movie details with Images appended
     * Expected Response - Test should return response with Movie Details entity of given movie id including images
     */
    @Test(enabled = false)
    public void getMovieDetailsWithImages() {
        // To Do
    }

    /*
     * Test for retrieving movie details with Keywords appended
     * Expected Response - Test should return response with Movie Details entity of given movie id including keywords
     */
    @Test(enabled = false)
    public void getMovieDetailsWithKeywords() {
        // To Do
    }

    /*
     * Test for retrieving movie details with Release Dates appended
     * Expected Response - Test should return response with Movie Details entity of given movie id including release
     * dates
     */
    @Test(enabled = false)
    public void getMovieDetailsWithReleaseDates() {
        // To Do
    }

    /*
     * Test for retrieving movie details with Translations appended
     * Expected Response - Test should return response with Movie Details entity of given movie id including translations
     */
    @Test(enabled = false)
    public void getMovieDetailsWithTranslations() {
        // To Do
    }

}
