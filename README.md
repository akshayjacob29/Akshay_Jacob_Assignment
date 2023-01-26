# Rate Limiter
This is a rate limiter library that allows you to limit the number of requests a user can make to a specific API within a certain time window.

## Getting Started
To use this library, you will first need to create a RateLimiter object by passing in a list of ApiRateLimit objects. Each ApiRateLimit object represents the rate limit for a specific API, and contains the following fields:

* api: the name of the API
* limit: the maximum number of requests allowed within the time window
* timeWindow: the time window in milliseconds

Once you have created the RateLimiter object, you can use the checkRequest method to check if a request is allowed for a given user and API. The method takes two arguments:

* user: the user making the request
* api: the API the request is being made to
It returns true if the request is allowed and false if the request is not allowed.

## Dependencies
* junit 4.13.1 (for running the test cases)
* fasterxml.jackson.core - 2.11.3
* fasterxml.jackson.core.annotations - 2.11.3
* jackson-databind - 2.11.3 (since the api,limit and timeWindow are set in a JSON file named "rate_limit_config.json")

## Testing
The library includes a set of test cases to ensure the correct functionality of the rate limiter. You can run these tests by executing the TestRateLimiter class. The test cases include:

* testCheckRequestWithinRateLimit: This test case checks that a user can make the maximum number of requests allowed within the time window, and that subsequent requests are denied.
* testCheckRequestOverRateLimit: This test case is designed to check if the rate limiter correctly prevents a user from making more requests than the specified rate limit.
*testCheckRequestExceedingRateLimit: This test case is designed to check if the rate limiter correctly prevents a user from making more requests than the specified rate limit, even if the requests are spread out over a longer period of time.

## Built With
* Java

## Authors
* Akshay Jacob
