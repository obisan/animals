package ru.ocean.animals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ocean.animals.model.OrderN;
import ru.ocean.animals.service.ClassService;
import ru.ocean.animals.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ClassService classService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String getOrders(Model model) {
        model.addAttribute("order", new OrderN());
        model.addAttribute("listOrders",    this.orderService.getOrders());
        model.addAttribute("listClasses",   this.classService.getClasses());

        return "order";
    }

    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("phylum") OrderN order) {

        if(order.getId() == null) {
            this.orderService.addOrder(order);
        } else {
            this.orderService.updateOrder(order);
        }

        return "redirect:/orders";
    }

    @RequestMapping(value = "/order/remove/{id}")
    public String removeOrder(@PathVariable("id") long id){
        this.orderService.removeOrder(id);

        return "redirect:/orders";
    }

    @RequestMapping(value = "/order/edit/{id}")
    public String editOrder(@PathVariable("id") long id, Model model) {
        model.addAttribute("order",         this.orderService.getOrderById(id));
        model.addAttribute("listOrders",    this.orderService.getOrders());
        model.addAttribute("listClasses",   this.classService.getClasses());

        return "order";
    }

}
