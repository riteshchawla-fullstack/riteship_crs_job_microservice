package com.riteship.crs.job.microservice.convertor;

import com.riteship.crs.job.microservice.dtos.JobDataBeanDTO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobDataBeanConvertor {

    public static List<JobDataBeanDTO> convertJobDataListToJobDataBean(ArrayList JobDataList) {
        List<JobDataBeanDTO> jobDataBeanDTOS = new ArrayList<>();
        if(!CollectionUtils.isEmpty(JobDataList)) {
            JobDataList.stream().forEach(data -> {
                if(data != null) {
                    HashMap jobData = (HashMap) data;
                    if(!CollectionUtils.isEmpty(jobData)) {
                        JobDataBeanDTO jobDataBeanDTO = getJobDataBeanDTOFromDataMap(jobData);
                        if(jobDataBeanDTO != null) {
                            jobDataBeanDTOS.add(jobDataBeanDTO);
                        }
                    }
                }
            });
        }
        return jobDataBeanDTOS;
    }

    public static JobDataBeanDTO getJobDataBeanDTOFromDataMap(HashMap jobData) {
        JobDataBeanDTO jobDataBeanDTO = null;
        if(!CollectionUtils.isEmpty(jobData)) {
            jobDataBeanDTO = new JobDataBeanDTO();
            jobDataBeanDTO.setJobCity((String)jobData.get("job_city"));
            jobDataBeanDTO.setJobId(Integer.valueOf((String)jobData.get("job_id")));
            jobDataBeanDTO.setJobCompanyId((String)jobData.get("job_company_id"));
            jobDataBeanDTO.setJobTitle((String)jobData.get("job_title"));
            jobDataBeanDTO.setJobSkills((String)jobData.get("job_skills"));
            jobDataBeanDTO.setJobPostDate((String)jobData.get("job_post_date"));
            jobDataBeanDTO.setJobDescription((String)jobData.get("job_description"));
            jobDataBeanDTO.setJobJtId((String)jobData.get("job_jt_id"));
        }
        return jobDataBeanDTO;
    }

    public static Map<String, String> getMapOfJobDataFromJobDataBean(JobDataBeanDTO jobDataBeanDTO) {
        Map<String, String> result = new HashMap<>();
        if(jobDataBeanDTO != null) {
            result.put("job_company_id", jobDataBeanDTO.getJobCompanyId());
            result.put("job_title", jobDataBeanDTO.getJobTitle());
            result.put("job_skills", jobDataBeanDTO.getJobSkills());
            result.put("job_post_date", jobDataBeanDTO.getJobPostDate());
            result.put("job_id", String.valueOf(jobDataBeanDTO.getJobId()));
            result.put("job_description", jobDataBeanDTO.getJobDescription());
            result.put("job_jt_id", jobDataBeanDTO.getJobJtId());
            result.put("job_city", jobDataBeanDTO.getJobCity());
        }
        return result;
    }
}
