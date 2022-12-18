package com.example.servicecatalog.contoller;

import com.example.servicecatalog.db.Recall;
import com.example.servicecatalog.db.Serv;
import com.example.servicecatalog.service.RecallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/recalls")
public class RecallController {

    @Autowired
    private RecallService recallService;

    // handler for receiving a page with a list of all recall
    @GetMapping()
    public String showAllRecall(Model model) {
        List<Recall> listRecall = recallService.listAllService();
        model.addAttribute("listRecall", listRecall);
        return "recall-list";
    }

    // ADD and DELETE method i need write

    // handler to get form for add recall
    @GetMapping("/new")
    public String showNewRecallForm(Model model) {
        model.addAttribute("recall", new Recall());
        // добавим существующие группы в контекст add new entity
//        List<Group> groups = groupService.listAllGroups(); // список всех групп
//        model.addAttribute("groupsList", groups); // добавить в контекст представления
        return "executor-details";
    }

    //  handler to save date about recall
    @PostMapping("/new")
    public String saveNewRecall(Recall recall, RedirectAttributes ra) {
        // 1. save new service in date
        Recall saved = recallService.saveRecall(recall);
        // 2.  add message that service added
        ra.addFlashAttribute("message",
                "Recall " + saved + " saved successfully");
        return "redirect:/executor-details";
    }

    // handler to delete recall
//
    @GetMapping("/delete/{id}")
    public String deleteRecall(@PathVariable("id") Integer id, RedirectAttributes ra) {
        recallService.deleteRecallById(id);
        ra.addFlashAttribute("message", "Recall deleted");
        return "redirect:/executor-details";
    }
}
