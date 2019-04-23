package com.s3.service.sap;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.dvsmedeiros.bce.domain.Result;
import com.pdq.pedido.domain.Parametro;
import com.s3.helper.ParametroHelper;
import com.s3.repository.ParametroRepository;
import com.s3.ws.client.SOAPClient;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 10-04-2019 16:48:08
 *
 * @param <T> - Request entity which contains, the access key, the SAP object representing the order object and a SAP error object 
 * @param <E> - Response entity which usualy contains, status description, SAP status and result 
 */
@Service
public abstract class AbstractWebService<T, E> extends SOAPClient {

	private static final String packageBasePath = "com.s3.sap.";
	private static final String packageBaseUrl = "http://s3.com/sap/";
	@Autowired private ParametroRepository parametroRepository;
	
	public Result execute(T request) {
		Optional<Parametro> username = parametroRepository.findById(ParametroHelper.PARAMETER_SAP_WS_USERNAME);
		Optional<Parametro> password = parametroRepository.findById(ParametroHelper.PARAMETER_SAP_WS_PASSWORD);
		Optional<Parametro> schemeAndHost = parametroRepository.findById(ParametroHelper.PARAMETER_SAP_WS_BASE_URL);
		Optional<Parametro> path = parametroRepository.findById("sap.webservice."
				.concat(request.getClass().getPackage().getName()
						.replace(packageBasePath, "")
						.replace("_", ""))
				.concat(".url"));
		String url = schemeAndHost.get().getValParametro().concat(path.get().getValParametro());
		Result result = new Result();
		try {
			configureWebServiceTemplate(
					url,
					username.get().getValParametro(),
					password.get().getValParametro(),
					request.getClass().getPackage().getName()
			);
			@SuppressWarnings("unchecked")
			E response = (E) getConfiguredWebServiceTemplate()
				.marshalSendAndReceive(
						url,
						request,
						new SoapActionCallback(packageBaseUrl
								.concat(request.getClass().getPackage().getName()
										.replace(packageBasePath, ""))
								.concat("/")
								.concat(request.getClass().getSimpleName()))
					);
			result.addEntity(response);
		} catch(Exception e) {
			logger.error("Erro durante processo comunicação com o SAP.");
			logger.error(e);			
			result.setError();
			result.setMessage("Erro de comunicação com o SAP");
		}
		return result;
	}
}
