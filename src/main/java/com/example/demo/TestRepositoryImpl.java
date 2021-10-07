package com.example.demo;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;


public class TestRepositoryImpl implements TestRepositoryBatch{

	@Autowired EntityManager em ;
	
	@Override
	public int saveAll(List<Test> list) {
		String data = list.stream().map(item->"('"+item.getName()+"','"+item.getAddress()+"')").collect(Collectors.joining(",")) ;
		Query q = em.createNativeQuery("insert into test(name,address) values " + data);
		int i = q.executeUpdate();
		return i;
	}

	

}
