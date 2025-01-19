package com.example.Adress.Book.repo;

import com.example.Adress.Book.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository< Address,Integer> {
}
