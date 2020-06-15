package com.jrp.cra;

import com.jrp.cra.dao.ICourseRepository;
import com.jrp.cra.dao.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClassRegistrationApplication {

	@Autowired
	ICourseRepository courseRepo;

	@Autowired
	IStudentRepository studentRepo;

	public static void main(String[] args) {
		SpringApplication.run(ClassRegistrationApplication.class, args);
	}

}
