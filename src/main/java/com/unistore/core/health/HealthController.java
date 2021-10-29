package com.unistore.core.health;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api}/health")
public class HealthController {
    
    @GetMapping("/alive")
	public boolean checkAlive(HttpServletResponse response) throws IOException {
        return true;
	}

}
