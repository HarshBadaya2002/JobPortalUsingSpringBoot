package com.harsh.jobPortal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.harsh.jobPortal.model.JobPost;
import com.harsh.jobPortal.service.JobService;

@Controller
public class JobController {

  @Autowired
  private JobService jobService;

  @RequestMapping({ "/", "home" })
  public String home() {
    return "home";
  }

  @RequestMapping("addjob")
  public String add() {
    return "addjob";
  }

  @GetMapping("viewalljobs")
  public String view(Model model) {
    List<JobPost> jobs = jobService.getAllJobs();
    model.addAttribute("jobPosts", jobs);
    return "viewalljobs";
  }

  @PostMapping("handleForm")
  public String handleForm(JobPost jobPost) {

    jobService.addJob(jobPost);
    return "success";
  }

}
