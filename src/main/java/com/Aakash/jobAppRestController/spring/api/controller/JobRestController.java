package com.Aakash.jobAppRestController.spring.api.controller;

import com.Aakash.jobAppRestController.spring.api.model.User;
import com.Aakash.jobAppRestController.spring.api.service.JobService;
import com.Aakash.jobAppRestController.spring.api.model.JobPost;
import com.Aakash.jobAppRestController.spring.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private UserService service1;

    @Autowired
    private JobService service;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service1.saveUser(user);
    }


    @GetMapping("jobPosts")

    public List<JobPost> getAllJobs(){
        return service.returnAllJobPosts();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }
    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobpost){
        service.addJobPost(jobpost);
    }

    @PutMapping("jobPost")
    public void updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        service.deleteJob(postId);
        return "deleted";
    }
    @GetMapping("load")
    public String loadData() {
        service.load();
        return "success";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> SearchByKeyword(@PathVariable("keyword") String keyword ){
        return service.search(keyword);
    }

}
