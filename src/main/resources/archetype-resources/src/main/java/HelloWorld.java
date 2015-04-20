#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@RequestScoped
@Component
public class HelloWorld {
	private String sayHello = "Hello, I am a Spring bean!";
	private Logger log = LoggerFactory.getLogger(HelloWorld.class);

	public String getSayHello() {
		return sayHello;
	}
	
	@PostConstruct
	void log() {
		log.info("starting");
	}
} 