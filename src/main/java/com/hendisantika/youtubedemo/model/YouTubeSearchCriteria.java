package com.hendisantika.youtubedemo.model;

import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * Project : candidate-app
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/11/17
 * Time: 04.05
 * To change this template use File | Settings | File Templates.
 */

public class YouTubeSearchCriteria {

    @Size(min = 5, max = 64, message = "Search term must be between 5 and 64 characters")
    private String queryTerm;

    public String getQueryTerm() {
        return queryTerm;
    }

    public void setQueryTerm(String queryTerm) {
        this.queryTerm = queryTerm;
    }

}
