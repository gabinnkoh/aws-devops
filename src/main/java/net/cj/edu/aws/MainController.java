package net.cj.edu.aws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //controller와 response 방식이 다름. 데이터를 리턴할 때 (controller는 페이지(html)를 리턴할 떄)
public class MainController {

	@GetMapping("/") //@requestMapping(value="/", method=requestmethod.GET)이랑 똑같음
	public String home() {
		return "<h1>aws-devops</h1>"; //string을 넘기는 것이다
	}
}
