package com.masspick.peak.dd.controller;

import com.masspick.peak.dd.config.SystemConfig;
import com.masspick.peak.dd.model.TaskCount;
import com.masspick.peak.dd.service.TaskCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by admin on 2018/5/16 0016.
 */
@Controller
public class HomeController {

    /**
     * systemConfig
     */
    @Autowired
    private SystemConfig systemConfig;

    /**
     * taskCountService
     */
    @Autowired
    private TaskCountService taskCountService;

    /**
     * @param model
     * @return String
     */
    @GetMapping({"/", "/index"})
    public String index(Model model) {
        TaskCount taskCount = taskCountService.findByTaskCount();
        model.addAttribute("taskCount", taskCount);
        return "index";
    }
}
