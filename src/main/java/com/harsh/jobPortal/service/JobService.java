package com.harsh.jobPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsh.jobPortal.model.JobPost;
import com.harsh.jobPortal.repository.JobRepo;

@Service
public class JobService {

  private JobRepo jobRepo;

  @Autowired
  public JobService(JobRepo jobRepo) {
    this.jobRepo = jobRepo;
  }

  public void addJob(JobPost job) {
    jobRepo.addJob(job);
  }

  public List<JobPost> getAllJobs() {
    return jobRepo.getAllJobs();
  }

}
