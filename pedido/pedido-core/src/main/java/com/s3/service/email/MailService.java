package com.s3.service.email;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.Future;

import javax.activation.DataSource;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import com.s3.helper.ParametroHelper;
import com.s3.repository.ParametroRepository;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 23-04-2019 11:09:50
 *
 */
@Component
public class MailService {
    
	private final static Logger LOG = LoggerFactory.getLogger(MailService.class);
	private static final String MIMETYPE_PDF = "application/pdf";
    
    @Autowired private JavaMailSender mailSender;
    @Autowired private ParametroRepository parametroRepository;    
    
    private void initMailService(){

    	JavaMailSenderImpl javaMailSenderImpl = (JavaMailSenderImpl) mailSender;
    	javaMailSenderImpl.setHost(parametroRepository.findById(ParametroHelper.EMAIL_HOST).get().getValParametro());
    	javaMailSenderImpl.setPort(Integer.parseInt(parametroRepository.findById(ParametroHelper.EMAIL_PORT).get().getValParametro()));
    	javaMailSenderImpl.setUsername(parametroRepository.findById(ParametroHelper.EMAIL_USERNAME).get().getValParametro());
    	javaMailSenderImpl.setPassword(parametroRepository.findById(ParametroHelper.EMAIL_PASSWORD).get().getValParametro());        	
	
    	Properties properties = new Properties();
    	
    	properties.put("mail.smtp.auth", parametroRepository.findById(ParametroHelper.EMAIL_SMTP_AUTH).get().getValParametro());
    	properties.put("mail.smtp.ssl.enable", parametroRepository.findById(ParametroHelper.EMAIL_SMTP_SSL_ENABLE).get().getValParametro());
    	properties.put("mail.smtp.starttls.enable", parametroRepository.findById(ParametroHelper.EMAIL_STARTTLS_ENABLE).get().getValParametro());
    	properties.put("mail.debug", parametroRepository.findById(ParametroHelper.EMAIL_DEBUG).get().getValParametro());
    	properties.put("mail.smtp.ssl.trust", parametroRepository.findById(ParametroHelper.EMAIL_HOST).get().getValParametro());
    	
    	javaMailSenderImpl.setJavaMailProperties(properties);
    }
    
    @Async
    private Future<Boolean> send(String from, String[] to, String subject, String text, String fileName, Object fileContent) {
    	boolean success = false;
        try {
        	initMailService();
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            
            if(from == null || from.trim().length() == 0)
            	from = parametroRepository.findById(ParametroHelper.EMAIL_SENDER).get().getValParametro();
            
			helper.setFrom(from, "Compass Minerals");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);                       
            
            if(fileContent != null) {
            	// XLSX file
            	if(fileContent instanceof DataSource) {
            		helper.addAttachment(fileName, (DataSource) fileContent);	
        		// PDF file
            	} else if (fileContent instanceof byte[]) {
            		if(((byte[])fileContent).length > 0) {
	            		ByteArrayResource content = new ByteArrayResource((byte[])fileContent);
	            		helper.addAttachment(fileName, content, MIMETYPE_PDF);
            		} else
            			LOG.warn("Arquivo: ".concat(fileName).concat(" não possui conteúdo."));
            	} else
                    LOG.warn("Arquivo: ".concat(fileName).concat(" de tipo: ").concat(fileContent.getClass().getName()).concat(" não pode ser enviado."));
            }
            LOG.debug("Iniciando envio de email " + subject + " para lista de emails " + Arrays.toString(to));
            mailSender.send(message);
            LOG.debug("Finalizado envio de email " + subject);
            success = true;
        } catch (Exception e) {
        	LOG.error("Erro no envio do email " + subject + " para " + Arrays.toString(to) , e);
			success = false;
		}
        return new AsyncResult<>(success);
    }
    /**
     * 
     * @author José Wesley Silva
     * 23-04-2019 13:23:51
     *
     * @param from - email sending address
     * @param to - address that receives email
     * @param subject - email subject
     * @param text - email body
     * @param fileName - attached file name
     * @param fileContent - file content can be of types XLSX or PDF, no other files can be handled by the class.
     * If other type of file are passed to the method it will ignore it and log a warning message
     * @return returns Future<Boolean> to asynchronous manipulation
     */
    @Async
    public Future<Boolean> sendWithAttachment(String from, String[] to, String subject, String text, String fileName, Object fileContent) {
        return send(from, to, subject, text, fileName, fileContent);
    }
    /**
     * 
     * @author José Wesley Silva
     * 23-04-2019 13:23:40
     *
     * @param from - email sending address
     * @param to - address that receives email
     * @param subject - email subject
     * @param text - email body
     * @param fileName - attached file name
     * @param fileContent - file content can be of types XLSX or PDF, no other files can be handled by the class.
     * If other type of file are passed to the method it will ignore it and log a warning message
     * @return returns Future<Boolean> to asynchronous manipulation
     */
    @Async
    public Future<Boolean> sendWithAttachment(String[] to, String subject, String text, String fileName, Object fileContent) {
        return send(null, to, subject, text, fileName, fileContent);
    }
    /**
     * 
     * @author José Wesley Silva
     * 23-04-2019 13:12:17
     *
     * @param from - email sending address
     * @param to - address that receives email
     * @param subject - email subject
     * @param text - email body
     * @return returns Future<Boolean> to asynchronous manipulation
     */
    @Async
    public Future<Boolean> send(String from, String[] to, String subject, String text) {
        return send(from, to, subject, text, null, null);
    }
    /**
     * 
     * @author José Wesley Silva
     * 23-04-2019 13:10:22
     *
     * @param to - address that receives email
     * @param subject - email subject
     * @param text - email body
     * @return returns Future<Boolean> to asynchronous manipulation
     */
    @Async
    public Future<Boolean> send(String[] to, String subject, String text) {
        return send(null, to, subject, text, null, null);
    }
}