package edu.grsu.controllers;


import edu.grsu.filters.FilterDTO;
import edu.grsu.dtos.TaskDTO;
import edu.grsu.mappers.Mapper;
import edu.grsu.model.enums.TaskStatus;
import edu.grsu.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public ModelAndView getAll(Model model, @ModelAttribute("status") FilterDTO filterDTO) {
        ModelAndView modelAndView = new ModelAndView("index");

        if (filterDTO == null) {
            filterDTO = new FilterDTO();
        }

        List<TaskDTO> taskDTOS = Mapper.toListDTO(
                taskRepository.findAllByStatus(filterDTO.getStatus())
        );

        model.addAttribute("filter", filterDTO);
        model.addAttribute("tasks", taskDTOS);
        model.addAttribute("newTask", new TaskDTO());

        return modelAndView;
    }

    @PostMapping
    public ModelAndView create(@ModelAttribute("newTask") TaskDTO taskDTO) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        taskDTO.setStatus(TaskStatus.IN_PROGRESS);

        taskRepository.save(Mapper.toEntity(taskDTO));

        return modelAndView;
    }

    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable("id") Long id, @ModelAttribute("newTask") TaskDTO taskDTO) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        taskDTO.setId(id);

        taskRepository.save(Mapper.toEntity(taskDTO));

        return modelAndView;
    }


    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");

        taskRepository.deleteAllById(id);

        return modelAndView;
    }
}
