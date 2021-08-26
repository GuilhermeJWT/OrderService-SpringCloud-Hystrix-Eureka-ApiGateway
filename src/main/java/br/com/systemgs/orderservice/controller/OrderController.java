package br.com.systemgs.orderservice.controller;

import br.com.systemgs.orderservice.model.ModelOrder;
import br.com.systemgs.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/salvar")
    public ModelOrder salvaOrder(@RequestBody ModelOrder modelOrder){
        return orderService.salvarOrder(modelOrder);
    }

}
