package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<Test,Integer>{

	//嗯 saveAll() 不支援　@GeneratedValue，只好自行實作...
	
}
