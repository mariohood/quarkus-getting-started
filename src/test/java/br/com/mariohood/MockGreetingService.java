package br.com.mariohood;

import br.com.mariohood.service.GreetingService;
import io.quarkus.test.Mock;
import jakarta.enterprise.context.ApplicationScoped;

@Mock
@ApplicationScoped
public class MockGreetingService extends GreetingService{

    @Override
    public String greeting(String name){
        return "hello " + name + "<<<<<<<<<<< from Mock service >>>>>>>>>>"; 
    } 


    
}
