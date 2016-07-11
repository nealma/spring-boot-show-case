package com.nealma.repository.primary;

import com.nealma.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

/**
 * Created by nealpc on 7/5/16.
 */
@Component
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByName(String name);

    Order findByNameAndAge(String name, Integer age);

    @Query("from Order u where u.name=:name")
    Order findOrder(@Param("name") String name);

    @Query("from Order u where u.age > :age")
    Page<Order> findAll(@Param("age") Integer age, Pageable pageable);
}
