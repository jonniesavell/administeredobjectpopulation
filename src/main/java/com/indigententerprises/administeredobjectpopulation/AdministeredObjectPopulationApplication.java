package com.indigententerprises.administeredobjectpopulation;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Queue;

import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AdministeredObjectPopulationApplication {

	public static void main(String[] args) throws NamingException {
		final ApplicationContext applicationContext =
				SpringApplication.run(AdministeredObjectPopulationApplication.class, args);

		final Context context = new InitialContext();

		final Queue requesterQueue = applicationContext.getBean("requesterQueue", Queue.class);
		context.bind(
				"cn=requesterQueue,ou=JMSDestinations,ou=Resources,dc=deliciouscottage,dc=com",
				requesterQueue
		);

		final Queue replierQueue = applicationContext.getBean("replierQueue", Queue.class);
		context.bind(
				"cn=replierQueue,ou=JMSDestinations,ou=Resources,dc=deliciouscottage,dc=com",
				replierQueue
		);

		final ConnectionFactory requesterConnectionFactory =
				applicationContext.getBean("requesterConnectionFactory", ConnectionFactory.class);
		context.bind(
				"cn=requesterConnectionFactory,ou=JMSConnectionFactories,ou=Resources,dc=deliciouscottage,dc=com",
				requesterConnectionFactory
		);

		final ConnectionFactory replierConnectionFactory =
				applicationContext.getBean("replierConnectionFactory", ConnectionFactory.class);
        context.bind(
				"cn=replierConnectionFactory,ou=JMSConnectionFactories,ou=Resources,dc=deliciouscottage,dc=com",
				replierConnectionFactory
		);
	}
}
