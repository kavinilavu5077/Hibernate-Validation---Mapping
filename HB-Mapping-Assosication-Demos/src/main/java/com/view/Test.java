package com.view;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.PersistenceException;



public class Test {
	public static void main(String[] args)
	{
		Transaction tr=null;
		try(Session session=HBUtil.getSesFactory().openSession())
		{
			tr=session.beginTransaction();
			Person p1=new Person(100,"Kumar","Nadayanur");
			Employee p2=new Employee("rithesh",80000,"CEO","03062004");
			Customer p3=new Customer("friend@gmail.com",967859943,"Regular","santhosh");
			
			
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	        Validator validator = factory.getValidator();
	        Set<ConstraintViolation<Person>> violation = validator.validate(p1);
	        Set<ConstraintViolation<Employee>> violation2 = validator.validate(p2);
	        Set<ConstraintViolation<Customer>> violation3 = validator.validate(p3);
	        
	        

	        if (!violation.isEmpty()||!violation2.isEmpty()||!violation3.isEmpty())
	        {
	            for (ConstraintViolation<Person> violation1 : violation) {
	                System.out.println(violation1.getMessage());
	            }
	      
	            for (ConstraintViolation<Employee> violation4 : violation2) {
	                System.out.println(violation4.getMessage());
	            }
	     
	            for (ConstraintViolation<Customer> violation5 : violation3) {
	                System.out.println(violation5.getMessage());
	            }
	            
	            
	        }
	            
	            
	            
	        
	            session.merge(p1);
	            session.merge(p2);
				session.merge(p3);
	            tr.commit();
	        
			session.close();
		}
		
	
		catch (PersistenceException e) {
		    
		    e.printStackTrace();
		    if (tr != null) tr.rollback();
		    
		}
		catch(Exception e) {
			e.printStackTrace();
			if (tr != null) tr.rollback();
		}
	}

	
}