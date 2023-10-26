package org.teamhub.groupware.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SPAController {

    @RequestMapping({"/", "/notice/**", "/greeting","/clinicalDepartments", "/clinicHours", "/doctorProfile/**", "/gallery", "/directions", "/detail/**"})
    public String index(){
        return "forward:/index.html";
    }
}