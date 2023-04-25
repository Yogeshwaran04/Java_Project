package com.example.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mall.entity.service;

public interface mallrepository extends JpaRepository< service, Integer>{
	service findByMail(String mail);
	
}
