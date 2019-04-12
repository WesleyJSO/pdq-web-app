package com.s3.ws.client;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 10-04-2019 15:59:51
 *
 */
@Service
public abstract class SOAPClient extends WebServiceGatewaySupport {

	public Logger getLogger(Class<?> clazz) {
		return LoggerFactory.getLogger(clazz);
	}
	
	protected String login;
	protected String password;
	protected String clientUrl;
	/**
	 * 
	 * @author José Wesley Silva
	 * 10-04-2019 15:57:33
	 *
	 * Ensures that the object has been properly configured
	 * @return A configured WebServiceTemplate
	 */
	public WebServiceTemplate getConfiguredWebServiceTemplate() {
		Assert.hasText(getWebServiceTemplate().getDefaultUri(), "The client's url must be defined");
		Assert.notNull(getWebServiceTemplate().getMessageSenders(), "The messageSender must be defined");
		Assert.isInstanceOf(HttpComponentsMessageSender.class, getWebServiceTemplate().getMessageSenders()[0],
				"The message sender must be of type HttpComponentsMessageSender");

		return getWebServiceTemplate();
	}
	/**
	 * 
	 * @author José Wesley Silva
	 * 10-04-2019 16:42:21
	 *
	 * @param uri
	 * @param login
	 * @param password
	 * @param contextPath
	 */
	public void configureWebServiceTemplate(String uri, String login, String password, String contextPath) {
		
		Assert.hasText(uri, "The client's uri must be defined");
		getWebServiceTemplate().setDefaultUri(uri);
		getWebServiceTemplate().setMessageSender(httpComponentsMessageSender(login, password));	
		getWebServiceTemplate().setMarshaller(marshaller(contextPath));
		getWebServiceTemplate().setUnmarshaller(marshaller(contextPath));
		getWebServiceTemplate().afterPropertiesSet();
	}
	
	private Jaxb2Marshaller marshaller(String contextPath) {
		
		Assert.hasText(contextPath, "The marshaller context path must be defined");
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(contextPath);
		return marshaller;
	}
	
	private HttpComponentsMessageSender httpComponentsMessageSender(String login, String password) {
		
		Assert.hasText(login, "The client's login must be defined");
		Assert.hasText(password, "The client's password must be defined");
		HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
		httpComponentsMessageSender.setConnectionTimeout(0);
		httpComponentsMessageSender.setReadTimeout(0);
		httpComponentsMessageSender.setCredentials(new UsernamePasswordCredentials(login, password));
		return httpComponentsMessageSender; 
	}
}
