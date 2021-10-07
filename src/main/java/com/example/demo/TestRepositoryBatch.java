package com.example.demo;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TestRepositoryBatch {
	
	public int saveAll(List<Test> list) ;
	
}
