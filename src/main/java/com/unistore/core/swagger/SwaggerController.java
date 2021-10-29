package com.unistore.core.swagger;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("${api}/swagger")
@ApiIgnore
public class SwaggerController {

	@GetMapping("")
	void redirectToSwagger(HttpServletResponse response) throws IOException {
	  response.sendRedirect("/swagger-ui/index.html");
	}
    
}
