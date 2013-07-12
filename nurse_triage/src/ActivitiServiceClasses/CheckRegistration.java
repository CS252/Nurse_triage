package ActivitiServiceClasses;

import javaclasses.PatientDAO;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class CheckRegistration implements JavaDelegate{

	public void execute(DelegateExecution execution) throws Exception {
		    
			String pid1 = (String) execution.getVariable("Patientid");
		    try 
			{ 
				//if ((!pid1.equals("p1")))
		    	if (PatientDAO.check_reg(pid1)  == 0)
				{
					execution.setVariable("Patientid", "0");
				}
				
			}
			catch (Throwable theException) 
			{ 
				System.out.println(theException); 
			}
	}
}
