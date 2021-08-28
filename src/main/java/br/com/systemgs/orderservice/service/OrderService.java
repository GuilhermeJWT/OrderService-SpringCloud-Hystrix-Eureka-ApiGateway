package br.com.systemgs.orderservice.service;

import br.com.systemgs.orderservice.common.Payment;
import br.com.systemgs.orderservice.common.TransactionalRequest;
import br.com.systemgs.orderservice.common.TransactionalResponse;
import br.com.systemgs.orderservice.model.ModelOrder;
import br.com.systemgs.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate template;

    public TransactionalResponse salvarOrder(TransactionalRequest transactionalRequest){
        String response = "";
        ModelOrder modelOrder = transactionalRequest.getModelOrder();
        Payment payment = transactionalRequest.getPayment();
        payment.setOrderId(modelOrder.getId());
        payment.setAmount(modelOrder.getPrice());

        Payment paymentResponse =  template.postForObject("http://localhost:9191/api/payment/salvar", payment, Payment.class);
        orderRepository.save(modelOrder);

        response = paymentResponse.getPaymentStatus().equals("success")? "payment processing succesful and order placed" : "there is a failure in payment api, order added to cart";

        return new TransactionalResponse(modelOrder, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }

}
