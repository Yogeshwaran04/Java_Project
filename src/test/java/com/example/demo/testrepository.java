package com.example.demo;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.example.mall.dao.mallrepository;
import com.example.mall.entity.service;

//@AutoConfigureTestDatabase(replace= Replace.NONE)
//@Rollback(false)
@ContextConfiguration(classes = {service.class})
public class testrepository {
	
	@Autowired
	private  mallrepository repo;
	@Autowired
	private TestEntityManager entityManager;
	@Test
	public void testCreateUser(){
		service ser= new service();
		ser.setMail("vaithishvaran@gmail.com");
		ser.setName("yogeshwaran");
		ser.setMobile("9360693902");
		ser.setPassword("Vaithi@04");
		service saved=repo.save(ser);
		service exist=entityManager.find(service.class, saved.getId());
		assertThat(exist.getMail()).isEqualTo(ser.getMail());
	}

}
