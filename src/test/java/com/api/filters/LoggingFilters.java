package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilters implements Filter {
    private static final Logger logger = LogManager.getLogger(LoggingFilters.class);
    public Response filter(FilterableRequestSpecification var1, FilterableResponseSpecification var2, FilterContext ctx){
        logRequest(var1);
        Response response = ctx.next(var1, var2);
        logResponse(response);
        return response;
    }

    public void logRequest(FilterableRequestSpecification requestSpec){
        logger.info("BASE_URI: {}", requestSpec.getBaseUri());
        logger.info("Request Headers: {}", requestSpec.getHeaders());
        logger.info("Request Payload: {}", requestSpec.getBody().toString());
    }

    public void logResponse(Response response){
        logger.info(": {}", response.getStatusCode());
        logger.info("Response Headers: {}", response.getHeaders());
        logger.info("Response Body: {}", response.getBody().asString());
    }
}
