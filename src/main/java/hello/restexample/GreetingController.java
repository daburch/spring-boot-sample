package hello.restexample;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

// The @RestController annotation identifies the service controller. Controllers handle the incoming HTTP traffic.
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // The @RequestMapping annotation ensures that HTTP requests to /greeting are mapped to the greeting() method.
    // @RequestParam binds the value of the query string parameter name into the name parameter of the greeting()
    // method. If the name parameter is absent in the request, the defaultValue of "World" is used.
    @RequestMapping(method = GET, name = "/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}