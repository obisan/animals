package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.Certificate;
import ru.ocean.animals.service.CertificateService;
import ru.ocean.animals.service.ObjectService;

@Controller
public class CertificateController {

    @Autowired
    private CertificateService      certificateService;

    @Autowired
    private ObjectService           objectService;

    @RequestMapping(value = "/certificates", method = RequestMethod.GET)
    public String getCertificates(Model model) {
        model.addAttribute("certificate",       new Certificate());
        model.addAttribute("listCertificates",  this.certificateService.getCertificates());
        model.addAttribute("listObjects",       this.objectService.getObjectsAlive());

        return "certificate";
    }

    @RequestMapping(value = "/certificate/add", method = RequestMethod.POST)
    public String addCertificate(@ModelAttribute("certificate") Certificate certificate) {
        if(certificate.getId() == null) {
            this.certificateService.addCertificate(certificate);
        } else {
            this.certificateService.updateCertificate(certificate);
        }

        return "redirect:/certificates";
    }

    @RequestMapping(value = "/certificate/remove/{id}")
    public String removeCertificate(@PathVariable("id") long id) {
        this.certificateService.removeCertificate(id);

        return "redirect:/certificates";
    }

    @RequestMapping(value = "/certificate/edit/{id}")
    public String editCertificate(@PathVariable("id") long id, Model model) {
        model.addAttribute("certificate",       this.certificateService.getCertificateById(id));
        model.addAttribute("listCertificates",  this.certificateService.getCertificates());
        model.addAttribute("listObjects",       this.objectService.getObjectsAlive());

        return "certificate";
    }

}
