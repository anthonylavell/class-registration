package com.jrp.cra.validators;

import com.jrp.cra.entites.Student;
import com.jrp.cra.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<IUniqueValue, String> {
    @Autowired
    StudentService studentService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        Student student= studentService.getStudentByEmail(value);
        if (student !=null){
             return false;
        }else {
            return true;
        }
    }
}
