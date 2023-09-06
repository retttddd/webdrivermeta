# WebdriverMeta

Welcome to WebdriverMeta, a Spring Boot-based microservice designed to provide downloadable links for web drivers via RESTful API calls. This repository showcases a robust microservice architecture organized into well-structured packages, emphasizing clarity, maintainability, and extensibility.


## Project Structure

### Controller Package
The `controller` package serves as the primary gateway for external interactions with this microservice. It expertly handles RESTful API calls from clients, serving as the entry point for external requests.

### Ports Package
Within the `ports` package, you'll find dedicated sections, each meticulously tailored to support specific web browsers. These sections house a collection of exquisitely crafted model classes (record classes) designed to parse and manage data exclusively for the corresponding browser.

### Service Package
At the heart of our microservice lies the `service` package, home to the intricate business logic. Here, we define precisely how to leverage the capabilities offered by the `ports` package, orchestrating these components to achieve the microservice's primary objectives.

## Useful Links

- [**Google Chrome Drivers Repository**](https://googlechromelabs.github.io/chrome-for-testing/latest-versions-per-milestone-with-downloads.json)

- [**Mozilla Firefox Drivers Repository**](https://github.com/mozilla/geckodriver/releases)

- [**Chrome for Testing Availability**](https://github.com/GoogleChromeLabs/chrome-for-testing#json-api-endpoints)

-  [**GitHub REST API documentation**](https://docs.github.com/en/rest/releases/releases?apiVersion=2022-11-28)


## Usage

1. **Build Application**: To get started, build the application. `./mwnv clean package`
2. **Run Application**: Run application using. `java -jar ./target/webdrivermeta-1.0.0.jar`
4. **Make a REST Call**: Use the REST API tool to make a request with the corresponding fields. `http://localhost:8080/getDriverUrl?browser=FireFox&version=93.232313.123123.12313.1.&platform=macos-aarch64`

By following these straightforward steps, you can seamlessly access and utilize WebdriverMeta to acquire the web drivers links you need.

