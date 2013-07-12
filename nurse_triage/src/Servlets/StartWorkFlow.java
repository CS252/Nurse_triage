package Servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javaclasses.LoginPojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.util.ReflectUtil;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * Servlet implementation class StartWorkFlow
 */
@WebServlet("/StartWorkFlow")
public class StartWorkFlow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartWorkFlow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		
		if (((String) request.getParameter("sno")).equals("2"))
		{
		
		String pid = (String) request.getParameter("patientid");
		HttpSession session = request.getSession();
		
				RuntimeService runtimeService =	processEngine.getRuntimeService();
				
				RepositoryService repositoryService = processEngine.getRepositoryService();
				repositoryService.createDeployment().addInputStream("nurse_triage.bpmn20.xml", ReflectUtil.getResourceAsStream("nurse_triage.bpmn")).deploy();
				//repositoryService.createDeployment().addClasspathResource("triage_demo.bpmn20.xml").deploy();
				
				Map<String, Object> variableMap = new HashMap<String, Object>();
				
				pid = (String) request.getParameter("patientid");
				variableMap.put("Patientid", pid);
				variableMap.put("loginuser", ((LoginPojo) session.getAttribute("user")).getUsername());
				
				ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("triageProcess",variableMap);
				
		}
		
		else{
			
			System.out.println("else-one");
			
			RuntimeService runtimeService =	processEngine.getRuntimeService();
				
		/* TaskService taskService = processEngine.getTaskService();
				List<Task> taskList = taskService.createTaskQuery().assignee("kermit").list();
			
			String process_id = processInstance.getProcessInstanceId();
			
			HttpSession session=request.getSession(); 
			session.setAttribute("process_instance_id", process_id );
			//System.out.println(tid);
			
			Map<String, Object> variables = new HashMap<String, Object>();
			taskList = taskService.createTaskQuery()
	                .processInstanceId(processInstance.getProcessInstanceId()).list();			
			Task task = taskList.get(0);
			String taskId = task.getId();
			System.out.println(taskId);
			
			variables = runtimeService.getVariables(process_id);
			
			for (Map.Entry<String, Object> entry : variables.entrySet()) {
			    System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
			}
			
			String form1 = processEngine.getFormService().getTaskFormData(taskId).getFormKey();
			System.out.println(form1);
			response.sendRedirect(form1);	 */
		}
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
