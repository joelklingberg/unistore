package com.unstore.orderrow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRowRepository extends JpaRepository<OrderRow, Long> {
    
}
