package br.com.systemgs.orderservice.service;

import br.com.systemgs.orderservice.model.ModelOrder;
import br.com.systemgs.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public ModelOrder salvarOrder(ModelOrder modelOrder){
        return orderRepository.save(modelOrder);
    }

}
