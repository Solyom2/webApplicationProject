package hu.iit.me.controller;

import hu.iit.me.dto.ApplicantType;
import hu.iit.me.model.Applicant;
import hu.iit.me.model.Degree;
import hu.iit.me.service.ApplicantsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {

    private ApplicantsManager applicantsManager;

    public ApplicantController(ApplicantsManager applicantsManager) {
        this.applicantsManager = applicantsManager;
    }

    @RequestMapping(value="/listAll", method = RequestMethod.GET)
    @ResponseBody
    public Collection<ApplicantType> listAllApplicants() {
        Collection<Applicant> applicants = applicantsManager.listAllApplicants();
        return DTOConverter.applicantConverter(applicants);
    }

    @RequestMapping(value="/listByName", method = RequestMethod.GET)
    @ResponseBody
    public Collection<ApplicantType> listApplicantByName(@RequestParam(value = "name") String name) {
        Collection<Applicant> applicants = applicantsManager.findApplicantByName(name);
        return DTOConverter.applicantConverter(applicants);
    }

    @RequestMapping(value="/listById", method = RequestMethod.GET)
    @ResponseBody
    public Collection<ApplicantType> listApplicantById(@RequestParam(value = "id") int id) {
        Collection<Applicant> applicants = applicantsManager.findApplicantById(id);
        return DTOConverter.applicantConverter(applicants);
    }

    @RequestMapping(value="/listByDegree", method = RequestMethod.GET)
    @ResponseBody
    public Collection<ApplicantType> listApplicantByDegree(@RequestParam(value = "degree") Degree degree) {
        Collection<Applicant> applicants = applicantsManager.listApplicantsByDegree(degree);
        return DTOConverter.applicantConverter(applicants);
    }

    @RequestMapping(value="/listByAddress", method = RequestMethod.GET)
    @ResponseBody
    public Collection<ApplicantType> listApplicantByAddress(@RequestParam(value = "address") String address) {
        Collection<Applicant> applicants = applicantsManager.listApplicantsByAddress(address);
        return DTOConverter.applicantConverter(applicants);
    }

}
