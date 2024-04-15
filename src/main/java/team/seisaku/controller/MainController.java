package team.seisaku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import team.seisaku.model.StudentModel;
import team.seisaku.service.StudentService;


@Controller
public class MainController {
	  @Autowired
	  private StudentService studentservice;
	  
	  @GetMapping("/")
	  public String top(Model model) {
		  return "top";
	  }
	  
	  @GetMapping("/create")
	  public ModelAndView add(StudentModel studenttable, ModelAndView model) {
	      model.addObject("student", studenttable);
	      model.setViewName("create");
	      return model;
	  }
	  @PostMapping("/create")
	  public String studenttable(@Validated @ModelAttribute @NonNull StudentModel student, RedirectAttributes result, ModelAndView model,
	          RedirectAttributes redirectAttributes) {
	      try {
	          this.studentservice.save(student);
	          redirectAttributes.addFlashAttribute("exception", "");

	      } catch (Exception e) {
	          redirectAttributes.addFlashAttribute("exception", e.getMessage());
	      }
	      return "redirect:/";
	    }
	  
}
