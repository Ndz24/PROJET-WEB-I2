package demo.dao;

import demo.data.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDao extends JpaRepository<Email, Long> {
}
package main.java.demo.dao;

import demo.data.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDao extends JpaRepository<Email, Long> {
}
