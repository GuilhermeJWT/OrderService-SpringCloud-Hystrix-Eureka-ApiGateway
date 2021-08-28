package br.com.systemgs.orderservice.common;

import br.com.systemgs.orderservice.model.ModelOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionalResponse {

    private ModelOrder modelOrder;
    private double amount;
    private String transactionalId;
    private String message;

}
