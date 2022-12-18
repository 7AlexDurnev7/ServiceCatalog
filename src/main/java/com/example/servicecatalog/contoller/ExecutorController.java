package com.example.servicecatalog.contoller;

import com.example.servicecatalog.db.Executor;
import com.example.servicecatalog.db.Recall;
import com.example.servicecatalog.db.Serv;
import com.example.servicecatalog.repository.ServiceRepository;
import com.example.servicecatalog.service.ExecutorService;
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
@RequestMapping(value = "/executor")
public class ExecutorController {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private RecallService recallService;

    // handler for receiving a page with a list of all services
    @GetMapping()
    public String showAllExecutor(Model model) {
        List<Executor> listExecutor = executorService.listAllExecutor();
        model.addAttribute("listExecutor", listExecutor);
        return "executor-list";
    }

    // handler to get form for add executor
    @GetMapping("/new")
    public String showNewExecutorForm(Model model) {
        model.addAttribute("executor", new Executor());
        // добавим существующие группы в контекст add new entity
//        List<Group> groups = groupService.listAllGroups(); // список всех групп
//        model.addAttribute("groupsList", groups); // добавить в контекст представления
        return "executor-form";
    }

    //  handler to save date about executor
    @PostMapping("/new")
    public String saveNewExecutor(Executor executor, RedirectAttributes ra) {
        // 1. save new executor in date
        Executor saved = executorService.saveExecutor(executor);
        // 2.  add message that executor added
        ra.addFlashAttribute("message",
                "Executor " + saved + " saved successfully");
        return "redirect:/executor";
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable("id") Integer id, Model model) {
        Executor executor = executorService.getExecutorById(id);
        model.addAttribute(executor);
        List<Recall> recalls = recallService.findAllRecall(executor);
        model.addAttribute("recalls", recalls);
        return "executor-details";
    }

    // handler to delete service
    @GetMapping("/delete/{id}")
    public String deleteExecutor(@PathVariable("id") Integer id, RedirectAttributes ra) {
        executorService.deleteExecutorById(id);
        ra.addFlashAttribute("message", "Executor deleted");
        return "redirect:/executor";
    }

    // handler to update information about executor
    @GetMapping("/update/{id}")
    public String showUpdateExecutorForm(@PathVariable("id") Integer id, Model model) {
       Executor executor = executorService.getExecutorById(id);
        model.addAttribute("executor", executor);
//        List<Group> groupsList = groupService.listAllGroups();
//        model.addAttribute("groupsList", groupsList);
//        // ВАЖНО: при возврате представления указывается имя представления
        return "executor-update";
    }

    // handler to update information about executor
    @PostMapping("/update")
    public String updateExecutor(Executor executor, RedirectAttributes ra) {
        // изменяем поля
        Executor updated = executorService.updateExecutor(executor);
        // сообщение о том, что данные изменены
        ra.addFlashAttribute("message",
                "Executor " + updated + " update successfully");
        return "redirect:/executor";
    }
}
