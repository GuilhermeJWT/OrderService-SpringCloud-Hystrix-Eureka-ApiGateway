package br.com.systemgs.orderservice.repository;

import br.com.systemgs.orderservice.model.ModelOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<ModelOrder, Long> {

}
