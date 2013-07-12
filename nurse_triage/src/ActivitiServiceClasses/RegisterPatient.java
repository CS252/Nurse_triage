package ActivitiServiceClasses;

import javaclasses.HibernateUtil;
import javaclasses.PatientPojo;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RegisterPatient implements JavaDelegate{
	
	public void execute(DelegateExecution execution) throws Exception {
		
	    	  
	try 
	{ 		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
		Transaction tx = session.beginTransaction(); 
		
		 PatientPojo bean1 = new PatientPojo();
		 bean1.setPatientid((String) execution.getVariable("Patientid"));
		 bean1.setFirstname((String) execution.getVariable("Firstname"));
		 bean1.setLastname((String) execution.getVariable("Lastname"));
		 bean1.setDob((String) execution.getVariable("Dob"));
		 bean1.setAge((String) execution.getVariable("Age"));
		 bean1.setEmail((String) execution.getVariable("Email"));
		 bean1.setPhoneno((String) execution.getVariable("Phoneno"));
		 bean1.setAddress((String) execution.getVariable("Address"));
		 bean1.setCategory((String) execution.getVariable("Category"));
		 bean1.setGender((String) execution.getVariable("Gender"));
				 		 
		 session.save(bean1); 
		 tx.commit();
		 
	}
	catch (Throwable theException) 
	{ 
		System.out.println(theException); 
	}
	

}
}
