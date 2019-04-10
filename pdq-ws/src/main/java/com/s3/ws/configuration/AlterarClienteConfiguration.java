package com.s3.ws.configuration;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import com.s3.ws.client.AlterarClienteClient;

@Configuration
public class AlterarClienteConfiguration {

	@Value("${client.login}")
	private String login;

	@Value("${client.password}")
	private String password;

	@Value("${client.uri}")
	private String defaultUri;

	@Bean
	public Jaxb2Marshaller marshaller() {
		// this package must match the package in the <generatePackage> specified in pom.xml
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.s3.sap.z_sap_alt_cli");
		return marshaller;
	}

	@Bean
	public AlterarClienteClient countryClient(Jaxb2Marshaller marshaller) {
		AlterarClienteClient client = new AlterarClienteClient();
		client.setDefaultUri(defaultUri);
		client.setMarshaller(marshaller());
		client.setUnmarshaller(marshaller());
		client.setMessageSender(httpComponentsMessageSender());
		return client;
	}

	@Bean
	public HttpComponentsMessageSender httpComponentsMessageSender() {
		// set the basic authorization credentials
		HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
		httpComponentsMessageSender.setCredentials(usernamePasswordCredentials());
		return httpComponentsMessageSender;
	}

	@Bean
	public UsernamePasswordCredentials usernamePasswordCredentials() {
		// pass the user name and password to be used
		return new UsernamePasswordCredentials(login, password);
	}
}