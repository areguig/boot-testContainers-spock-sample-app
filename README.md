# Spring-boot,testContainers and spock sample app

A sample spring boot application tested using TestContainers Spock framework. 

I wrote this sample during the writing of my post about [__Testing Spring-Boot apps using TestContainers and Spock__](https://areguig.github.io/test-springboot-apps-using-testContainers-and-spock/).

#### Requirements

- Docker or docker-machine (for OS X)
- Java 8 

#### Tech stack : 

- Tested using [Spock](http://spockframework.org/)
- Integration database provided by [TestContainers](https://www.testcontainers.org/)
- Powered by [Spring-Boot](https://projects.spring.io/spring-boot/)
- Built with [Gradle](https://gradle.org/)
- Uses [JOOQ](https://www.jooq.org/) as DSL to construct SQL queries.

### Run the sample

- run the tests 

```bash 
./gradlew test
```

- run the app 

```bash 
./gradlew bootRun
```

#### Contributions : 
Feel free to open issues or submit PRs if you thing it is needed.
