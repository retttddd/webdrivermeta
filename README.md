# webdrivermeta
A Spring Boot-based microservice offers downloadable links for corresponding web drivers via REST calls.

# Microservice Architecture with Spring Boot

This repository houses a robust microservice built using Spring Boot, designed to provide downloadable links for web drivers via RESTful API calls. The microservice is organized into well-structured packages to ensure clarity, maintainability, and extensibility.

## Project Structure

### Controller Package
The `controller` package serves as the gateway for external interactions with the microservice. It processes RESTful API calls from clients, making it the entry point for any external requests.

### Ports Package
The `ports` package is further subdivided into dedicated sections, each tailored to support specific web browsers. Each section contains a set of meticulously crafted model classes (record classes) designed for parsing and managing data relevant to the respective browser.

### Service Package
At the core of the microservice, you'll find the `service` package. This is where the intricate business logic resides, defining how to utilize the capabilities offered by the `ports` package. It orchestrates these components to achieve the microservice's primary objectives.

## Links
- [**Google Chrome api**](https://googlechromelabs.github.io/chrome-for-testing/latest-versions-per-milestone-with-downloads.json)
- [**Mozzila Firefox drivers api**](https://github.com/mozilla/geckodriver/releases)
- [**Chrome for Testing availability**](https://github.com/GoogleChromeLabs/chrome-for-testing#json-api-endpoints)

## usage
  ### build application
  ### make a rest call with the corresponding fields 
  

