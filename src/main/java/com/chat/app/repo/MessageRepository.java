package com.chat.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chat.app.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	@Query(value = "Select m from Message m where (m.sender.userId in (:sender,:reciever) and m.reciever.userId in (:sender,:reciever))  order by m.sentAt")
	public List<Message> getMessages(@Param("sender")Long sender,@Param("reciever")Long reciever);
}
