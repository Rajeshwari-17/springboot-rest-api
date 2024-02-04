package com.springboot.example.restapi.restapidemo.helloworld;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@Controller
@RestController
public class HelloWorldResources {
	
	@RequestMapping("/hello world")
	
	public String helloWorlg()
	{
		return "HellowWorld";
		
	}
	
@RequestMapping("/hello-worldbean")
	
	public helloWorldBean helloWorldBean()
	{
		return new helloWorldBean("Hello World");
		
	}
@RequestMapping("/hello-world-path-param/{name}")

public helloWorldBean helloWordpathparam(@PathVariable String name)
{
	return new helloWorldBean("HellowWorld , " + name);
	
}
@RequestMapping("/hello-world-path-param/{name}/message/{message}")
public helloWorldBean helloWorldMultiplePathParam
				(@PathVariable String name,
						@PathVariable String message) {
	return new helloWorldBean("Hello World " + name + "," + message);
}



}
