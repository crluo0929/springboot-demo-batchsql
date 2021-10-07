package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
	
//	@Autowired TestRepository dao ;
	@Autowired TestRepositoryBatch dao2 ;
	@Value("${spring.jpa.properties.hibernate.jdbc.batch_size:100}") int batchSize;

	@GetMapping(path="/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping(path="/test")
	@Transactional
	public String test() {
		List<Test> list = new ArrayList<>();
		//prepare data
		for(int i=0;i<10000;++i) {
			list.add(new Test(0,"Batch"+i,"Addr"+i));
		}
		
		long s = System.currentTimeMillis();
		List<List<Test>> partitionList =  partition(list,batchSize);
		partitionList.forEach(l->{
			int ret= dao2.saveAll(l);
			System.out.println(ret);
		});
		long e = System.currentTimeMillis();
		
		return "hello 花費:"+(e-s)+" ms." ;
	}
	
	public static<T> List<List<T>> partition(List<T> list, int size) {
	    List<List<T>> partitions = new ArrayList<>();
	    if (list.size() == 0) {
	        return partitions;
	    }
	    int length = list.size();
	    int numOfPartitions = length / size + ((length % size == 0) ? 0 : 1);
	    for (int i = 0; i < numOfPartitions; i++) {
	        int from = i * size;
	        int to = Math.min((i * size + size), length);
	        partitions.add(list.subList(from, to));
	    }
	    return partitions;
	}
	
}
