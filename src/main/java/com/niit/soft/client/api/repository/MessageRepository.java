package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tao
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
}
