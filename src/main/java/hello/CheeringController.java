package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheeringController {

	private final AtomicLong counter = new AtomicLong();
	private static final String template_cheering = "Come on %s!";

    @RequestMapping("/cheering")
    public Cheering cheering(@RequestParam(value="name", defaultValue="World") String name) {
        return new Cheering(counter.incrementAndGet(), String.format(template_cheering, name));
    }
    
}