# Rate Limiter Project

## Overview

This program is a rate limiter implementation that allows for controlling the rate at which a user can access a specific API. The rate limiter is implemented using a combination of a ConcurrentHashMap and a List of ApiRateLimit objects.

The ConcurrentHashMap is used to store the request rate for each user and API combination, while the List of ApiRateLimit objects is used to store the rate limit and time window for each API.

The RateLimiter class is the main class responsible for enforcing the rate limit. It has methods to check if a request is allowed, and to retrieve the current request rate for a user and API.

## Usage
To use the rate limiter, you will need to create an instance of the RateLimiter class and pass in a List of ApiRateLimit objects. Each ApiRateLimit object represents a specific API and contains the rate limit and time window for that API.

Once you have an instance of the RateLimiter, you can use the checkRequest method to check if a request from a specific user to a specific API is allowed. This method returns a boolean value indicating if the request is allowed or not.

You can also use the getRate method to retrieve the current request rate for a specific user and API.
