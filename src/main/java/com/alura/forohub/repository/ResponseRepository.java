package com.alura.forohub.repository;

import com.alura.forohub.model.response.Response;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ResponseRepository extends JpaRepository<Response, Long> {

}
