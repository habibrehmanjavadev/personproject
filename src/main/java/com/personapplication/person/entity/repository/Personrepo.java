package com.personapplication.person.entity.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personapplication.person.entity.Person;
@Repository
public interface Personrepo extends JpaRepository<Person,Integer>{


}
