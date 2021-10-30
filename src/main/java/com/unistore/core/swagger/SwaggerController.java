package com.unistore.core.swagger;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api}/swagger")
public class SwaggerController {

	@GetMapping("")
	void redirectToSwagger(HttpServletResponse response) throws IOException {
	  response.sendRedirect("/swagger-ui.html");
	}
    
}
