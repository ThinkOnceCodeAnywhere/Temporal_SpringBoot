package com.clone.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.clone.workflow.temporal.Activity;
import com.clone.workflow.temporal.WorkFlow;
import com.clone.workflow.temporal.WorkflowImpl;

import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

@SpringBootApplication
public class SwiggyCloneApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(SwiggyCloneApplication.class, args);
		WorkerFactory factory = appContext.getBean(WorkerFactory.class);
		Activity signUpActivity = appContext.getBean(Activity.class);
		Worker worker = factory.newWorker(WorkFlow.QUEUE_NAME);
		worker.registerWorkflowImplementationTypes(WorkflowImpl.class);
		worker.registerActivitiesImplementations(signUpActivity);
		factory.start();
	}

}
