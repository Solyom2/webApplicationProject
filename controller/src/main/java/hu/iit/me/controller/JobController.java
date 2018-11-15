package hu.iit.me.controller;

import hu.iit.me.model.Job;
import hu.iit.me.service.JobsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping("/job")
public class JobController {

    private JobsManager jobsManager;

    public JobController(JobsManager jobsManager) {
        this.jobsManager = jobsManager;
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Job> listAllJobs() {
        return jobsManager.listAllJobs();
    }

}