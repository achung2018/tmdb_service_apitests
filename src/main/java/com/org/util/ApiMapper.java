package com.org.util;

public class ApiMapper {
    public static String getMoviesEndpoint(String operation, String key) {
        String endP = "";
        String op = operation.toLowerCase();

        if (op.contentEquals("get")) {
            switch (key) {
                case "details":
                    break;
                case "account_states":
                    endP = "/account_states";
                    break;
                case "alt_titles":
                    endP = "/alternative_titles";
                    break;
                case "changes":
                    endP = "/changes";
                    break;
                case "credits":
                    endP = "/credits";
                    break;
                case "images":
                    endP = "/images";
                    break;
                case "keywords":
                    endP = "/keywords";
                    break;
                case "release_dates":
                    endP = "/release_dates";
                    break;
                case "videos":
                    endP = "/videos";
                    break;
                case "translations":
                    endP = "/translations";
                    break;
                case "recommendations":
                    endP = "/recommendations";
                    break;
                case "similar_movies":
                    endP = "/similar";
                    break;
                case "reviews":
                    endP = "/reviews";
                    break;
                case "lists":
                    endP =  "/lists";
                    break;
                case "latest":
                    endP = "/latest";
                    break;
                case "now_playing":
                    endP = "/now_playing";
                    break;
                case "popular":
                    endP = "/popular";
                    break;
                case "top_rated":
                    endP = "/top_rated";
                    break;
                case "upcoming":
                    endP = "/upcoming";
                    break;
            }
        }
        return endP;
    }
}
