package br.com.mariohood;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.mariohood.service.GreetingService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

import java.util.UUID;




@QuarkusTest
public class GreetingResourceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger("GreetingResourceTest");

    @Inject
    GreetingService service;
   
    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("hello"));    
    }

   
    @Test
    public void testHelloGreetingEndpoint(){
       LOGGER.info(service.greeting("Quarkus")); 
       Assertions.assertTrue(service.greeting("Quarkus").startsWith("hello Quarkus"));

    }
   
}