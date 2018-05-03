package com.example.tvdatabase;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TVPopulator implements CommandLineRunner {

	@Resource
	TVRepository tvRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
