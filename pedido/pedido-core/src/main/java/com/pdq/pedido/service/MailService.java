package com.pdq.pedido.service;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.Future;

import javax.activation.DataSource;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

/**
 *
 * @author dcampos
 */
@Service("mailService")
public class MailService {
    
	private static final String MIMETYPE_PDF = "application/pdf";
    private static final String MIMETYPE_XLSX = "application/xlsx";
    
    @Autowired
    JavaMailSender mailSender;
    
    @Autowired
    ParametroService parametroService;
    
    final static Logger LOG = LoggerFactory.getLogger(MailService.class);
    
    public void initMailService(){
    	
    	JavaMailSenderImpl mailSenderImpl = (JavaMailSenderImpl) mailSender;
    	HashMap<String, String> mapMailParams = parametroService.getMapMailServiceParameters();
    	
    	if(mapMailParams != null){    		
    		mailSenderImpl.setHost(mapMailParams.get(ParametroServiceImpl.PARAMETER_APPLICATION_EMAIL_HOST));
        	mailSenderImpl.setPort(Integer.valueOf(mapMailParams.get(ParametroServiceImpl.PARAMETER_APPLICATION_EMAIL_PORT)));
        	mailSenderImpl.setUsername(mapMailParams.get(ParametroServiceImpl.PARAMETER_APPLICATION_EMAIL_USERNAME));
        	mailSenderImpl.setPassword(mapMailParams.get(ParametroServiceImpl.PARAMETER_APPLICATION_EMAIL_PASSWORD));        	
    	
        	Properties javaMailProperties = new Properties();
        	
        	javaMailProperties.put("mail.smtp.auth", mapMailParams.get(ParametroServiceImpl.PARAMETER_APPLICATION_EMAIL_SMTP_AUTH));
        	javaMailProperties.put("mail.smtp.ssl.enable", mapMailParams.get(ParametroServiceImpl.PARAMETER_APPLICATION_EMAIL_SMTP_SSL_ENABLE));
        	javaMailProperties.put("mail.smtp.starttls.enable", mapMailParams.get(ParametroServiceImpl.PARAMETER_APPLICATION_EMAIL_STARTTLS_ENABLE));
        	javaMailProperties.put("mail.debug", mapMailParams.get(ParametroServiceImpl.PARAMETER_APPLICATION_EMAIL_DEBUG));
        	/**
        	 * Gustavo - 29/08/2014 - Perdia a configuração e dava erro.
        	 */
        	javaMailProperties.put("mail.smtp.ssl.trust", mapMailParams.get(ParametroServiceImpl.PARAMETER_APPLICATION_EMAIL_HOST));
        	
        	mailSenderImpl.setJavaMailProperties(javaMailProperties);
    	}    	
    }
    
    @Async
    public Future<Boolean> send(String from, String[] to, String subject, String text, String fileName, byte[] fileContent, String mimeType) {
    	boolean success = false;
        try {
        	initMailService();        	
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            
            if(from == null || from.trim().length() == 0){            	
            	from = parametroService.getApplicationEmailSender();
            }
            
			helper.setFrom(from, "Compass Minerals");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);                       
            
            if (fileContent != null && fileContent.length > 0) {
                ByteArrayResource content = new ByteArrayResource(fileContent);
                helper.addAttachment(fileName, content, mimeType);
            }
            LOG.debug("Iniciando envio de email " + subject + " para lista de emails " + Arrays.toString(to));
            mailSender.send(message);
            LOG.debug("Finalizado envio de email " + subject);
            success = true;
        } catch (MailException e) {
        	LOG.error("Erro no envio do email " + subject + " para " + Arrays.toString(to) , e);
        	success = false;
        } catch (MessagingException ex) {
        	LOG.error("Erro no envio do email " + subject + " para " + Arrays.toString(to), ex);
        	success = false;
        } catch (UnsupportedEncodingException ex) {
        	LOG.error("Erro no envio do email " + subject + " para " + Arrays.toString(to), ex);
        	success = false;
		} catch (Exception ex) {
			LOG.error("Erro no envio do email " + subject + " para " + to, ex);
			success = false;
		}
        return new AsyncResult<>(success);
    }
    
    @Async
    public void sendDataSource(String from, String[] to, String subject, String text, String fileName, DataSource fds, String mimeType) {
        try {        	
        	initMailService();        	
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            
            if(from == null || from.trim().length() == 0){            	
            	from = parametroService.getApplicationEmailSender();
            }
            
			helper.setFrom(from, "Compass Minerals");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);                                   
            helper.addAttachment( fileName, fds );
            
            LOG.debug("Iniciando envio de email " + subject + " para lista de emails " + to);
            mailSender.send(message);
            LOG.debug("Finalizado envio de email " + subject);
        } catch (MailException e) {
        	LOG.error("Erro no envio do email " + subject + "para " + to, e);
        } catch (MessagingException ex) {
        	LOG.error("Erro no envio do email " + subject + "para " + to, ex);
        } catch (UnsupportedEncodingException ex) {
        	LOG.error("Erro no envio do email " + subject + "para " + to, ex);
		} catch (Exception ex) {
			LOG.error("Erro no envio do email " + subject + "para " + to, ex);
		}
        
    }
    
    
    @Async
    public void senGdPDF(String from, String[] to, String subject, String text, String fileName, byte[] fileContent) {
        send(from, to, subject, text, fileName, fileContent, MIMETYPE_PDF);
    }

    @Async
    public void sendPDF(String from, String to, String subject, String text, String fileName, byte[] fileContent) {
        String[] _to = {to};
        send(from, _to, subject, text, fileName, fileContent, MIMETYPE_PDF);
    }

    @Async
    public void sendXLSX( String from, String to, String subject, String text, String fileName, DataSource fds ) {
        String[] _to = {to};
        sendDataSource(from, _to, subject, text, fileName, fds,  MIMETYPE_XLSX);
    }
    
    @Async
    public void send(String from, String[] to, String subject, String text) {
        send(from, to, subject, text, null, null, null);
    }
    
    @Async
    public void send(String from, String to, String subject, String text) {
        String[] _to = {to};
        send(from, _to, subject, text, null, null, null);
    }
    @Async
    public Future<Boolean> send(String to, String subject, String text) {
        String[] _to = {to};
        return send(null, _to, subject, text, null, null, null);
    }
}