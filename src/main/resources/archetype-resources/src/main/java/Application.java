#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "${package}" })
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);
	}

	@Bean
	public ServletRegistrationBean facesServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(
				new FacesServlet(), new String[] { "*.jsf", "*.xhtml" });
		registration.setName("Faces Servlet");
		registration.setLoadOnStartup(1);
		return registration;
	}

	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return new ServletContextInitializer() {
			@Override
			public void onStartup(ServletContext servletContext)
					throws ServletException {
				servletContext.setInitParameter(
						"com.sun.faces.forceLoadConfiguration",
						Boolean.TRUE.toString());
				servletContext
						.setInitParameter("primefaces.THEME", "bootstrap");
				servletContext.setInitParameter(
						"primefaces.CLIENT_SIDE_VALIDATION",
						Boolean.TRUE.toString());
				servletContext.setInitParameter(
						"javax.faces.FACELETS_SKIP_COMMENTS",
						Boolean.TRUE.toString());
				servletContext.setInitParameter("primefaces.FONT_AWESOME",
						Boolean.TRUE.toString());
				servletContext.setInitParameter("primefaces.UPLOADER",
						"commons");
			}
		};
	}
}
