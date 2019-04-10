package com.s3.ws.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.s3.sap.z_sap_alt_cli.TABLEOFZSDEERROWEBS;
import com.s3.sap.z_sap_alt_cli.ZBCALTCLIENTEARTWEBS;
import com.s3.sap.z_sap_alt_cli.ZBCALTCLIENTEARTWEBSResponse;
import com.s3.sap.z_sap_alt_cli.ZMMEALTCLIENTEWEBS;

public class AlterarClienteClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(AlterarClienteClient.class);
	private String testUri = "http://wsq1.produquimica.com.br:8002/sap/bc/srt/rfc/sap/z_alt_cad_s3/500/z_alt_cad_s3/z_alt_cad_s3";
	
	public Object getTeste(String teste) {

		ZMMEALTCLIENTEWEBS zmmAlterarCliente = new ZMMEALTCLIENTEWEBS();
		TABLEOFZSDEERROWEBS tableOfErrorWebs = new TABLEOFZSDEERROWEBS();
		ZBCALTCLIENTEARTWEBS request = new ZBCALTCLIENTEARTWEBS();
		
		request.setICHACESSO("U8PAE6tLek2o2St");
		request.setIALTCADASTRO(zmmAlterarCliente);
		request.setTABERRO(tableOfErrorWebs);
		
		log.info("Requesting for " + teste);
		
		ZBCALTCLIENTEARTWEBSResponse response = 
				(ZBCALTCLIENTEARTWEBSResponse) getWebServiceTemplate()
				.marshalSendAndReceive(
					testUri, 
					request,
					new SoapActionCallback("http://s3.com/sap/z_pre_alt_cli/ZBCALTCLIENTEARTWEBS")
				);

		return response;
	}

}
