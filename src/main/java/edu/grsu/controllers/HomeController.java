package edu.grsu.controllers;


import edu.grsu.filters.FilterDTO;
import edu.grsu.model.TaskDTO;
import edu.grsu.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private Repository repository;

    @GetMapping
    public ModelAndView getAll(Model model, @ModelAttribute("status") FilterDTO filterDTO){
        ModelAndView modelAndView = new ModelAndView("index");

        if(filterDTO == null){
            filterDTO = new FilterDTO();
        }

        List<TaskDTO> taskDTOS = repository.getTasks(filterDTO);

        model.addAttribute("filter", filterDTO);
        model.addAttribute("tasks", taskDTOS);
        model.addAttribute("newTask", new TaskDTO());

        return modelAndView;
    }

    @PostMapping
    public ModelAndView create(@ModelAttribute("newTask") TaskDTO taskDTO){
        ModelAndView modelAndView = new ModelAndView("redirect:/home");

        repository.create(taskDTO);

        return modelAndView;
    }

}
