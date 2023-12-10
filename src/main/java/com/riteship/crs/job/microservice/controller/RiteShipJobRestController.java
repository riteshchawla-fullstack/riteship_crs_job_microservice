package com.riteship.crs.job.microservice.controller;

import com.riteship.crs.job.microservice.convertor.JobDataBeanConvertor;
import com.riteship.crs.job.microservice.dtos.JobDataBeanDTO;
import com.riteship.crs.job.microservice.entities.JobDataBean;
import com.riteship.crs.job.microservice.impl.RiteShipJobServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/riteship/jobs")
public class RiteShipJobRestController {

    /*@Autowired
    private RiteShipJobDBOperationsBean JobDBOperationsBean;*/

    @Autowired
    private RiteShipJobServiceBean<JobDataBean, Integer> jobServiceBean;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/getAll")
    public @ResponseBody List<JobDataBeanDTO> getAllCompanies() {
        return JobDataBeanConvertor.convertJobDataListToJobDataBean(jobServiceBean.getAllJob(0));
    }

    @PutMapping("/save-job")
    public @ResponseBody String saveJob(JobDataBeanDTO jobData) {
        jobServiceBean.saveJob((HashMap)JobDataBeanConvertor.getMapOfJobDataFromJobDataBean(jobData));
        return "Success";
    }

    @GetMapping("/get-job")
    public @ResponseBody JobDataBeanDTO getJobDetails(int job_id) {
        return JobDataBeanConvertor.getJobDataBeanDTOFromDataMap(jobServiceBean.getJobDetails(job_id));
    }

    @PatchMapping("/update-job")
    public @ResponseBody String updateJob(JobDataBeanDTO jobData) {
        return jobServiceBean.updateJob((HashMap)JobDataBeanConvertor.getMapOfJobDataFromJobDataBean(jobData));
    }
}
