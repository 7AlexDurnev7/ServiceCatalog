package com.example.servicecatalog.contoller;

import com.example.servicecatalog.db.Serv;
import com.example.servicecatalog.service.ServiceServ;
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
@RequestMapping(value = "/service")
public class ServiceController {

    @Autowired
    private ServiceServ serviceServ;

    // handler for receiving a page with a list of all services
    @GetMapping()
    public String showAllService(Model model) {
        List<Serv> listService = serviceServ.listAllService();
        model.addAttribute("listService", listService);
        return "service-list";
    }


    // handler to get form for add service
    @GetMapping("/new")
    public String showNewServForm(Model model) {
        model.addAttribute("service", new Serv());
        // добавим существующие группы в контекст add new entity
//        List<Group> groups = groupService.listAllGroups(); // список всех групп
//        model.addAttribute("groupsList", groups); // добавить в контекст представления
        return "service-form";
    }

    //  handler to save date about service
    @PostMapping("/new")
    public String saveNewService(Serv service, RedirectAttributes ra) {
        // 1. save new service in date
        Serv saved = serviceServ.saveServ(service);
        // 2.  add message that service added
        ra.addFlashAttribute("message",
                "Service " + saved + " saved successfully");
        return "redirect:/service";
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable("id") Integer id, Model model) {
        Serv service = serviceServ.getServiceById(id);
        model.addAttribute("service", service);
        return "service-details";
    }

    // handler to delete service
    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable("id") Integer id, RedirectAttributes ra) {
        serviceServ.deleteServById(id);
        ra.addFlashAttribute("message", "Service deleted");
        return "redirect:/service";
    }

    // handler to update information about service
    @GetMapping("/update/{id}")
    public String showUpdateServiceForm(@PathVariable("id") Integer id, Model model) {
        Serv service = serviceServ.getServiceById(id);
        model.addAttribute("service", service);
//        List<Group> groupsList = groupService.listAllGroups();
//        model.addAttribute("groupsList", groupsList);
//        // ВАЖНО: при возврате представления указывается имя представления
        return "service-update";
    }

    // handler to update information about service
    @PostMapping("/update")
    public String updateStudent(Serv service, RedirectAttributes ra) {
        // изменяем поля
        Serv updated = serviceServ.updateService(service);
        // сообщение о том, что данные изменены
        ra.addFlashAttribute("message",
                "Service " + updated + " update successfully");
        return "redirect:/service";
    }

}
