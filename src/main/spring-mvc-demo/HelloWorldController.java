package springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	// need a controller to show initial HTML form

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// new controller method to read form data and pass it to model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		// read the req. parameter from HTML form
		String theName = request.getParameter("studentName");

		theName = theName.toUpperCase();
		String result = "YO " + theName;
		
		//add the message to model
		model.addAttribute("message", result);

		return "helloworld";
	}
	
	//using @RequestParam
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		theName = theName.toUpperCase();
		String result = "YO " + theName;
		
		//add the message to model
		model.addAttribute("message", result);

		return "helloworld";
	}

}
