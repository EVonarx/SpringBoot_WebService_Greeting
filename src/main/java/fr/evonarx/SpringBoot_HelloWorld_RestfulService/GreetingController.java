package fr.evonarx.SpringBoot_HelloWorld_RestfulService;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/help")
	public String help()  {
		return "<h1 style=\"color:green\">How to call this web service?</h1><br/>"
				+ "<h2>/greeting => {\\\"id\\\":...,\\\"content\\\":\\\"Hello, World!\\\"}</h2><br/>"
				+ "<h2>/greeting?name=Eric => {\"id\":...,\"content\":\"Hello, Eric!\"}</h2><br/>";
	}
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}