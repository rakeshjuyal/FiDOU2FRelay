package com.rplusj.fidoUTD.controller;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.rplusj.fidoUTD.model.UTD;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	static{
		// Well we are not going to check if your FSUT have correct certificate or not.
		try {
			final SSLContext sc = SSLContext.getInstance("SSL");
			sc.init( null, new TrustManager[]{
			        new X509TrustManager() {
			            public java.security.cert.X509Certificate[] getAcceptedIssuers(){
			                return null;
			            }
			            public void checkClientTrusted( X509Certificate[] certs, String authType ){}
			            public void checkServerTrusted( X509Certificate[] certs, String authType ){}
			        }
			    }, null );
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			
			//Always verify hostName.
			HttpsURLConnection.setDefaultHostnameVerifier(new  HostnameVerifier() {
				@Override
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			});
		} catch (KeyManagementException e) {
			
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is as {}.", locale);
		UTD utd = new UTD();
		utd.setFsutURL("https://localhost:8443");
		utd.setUthsURL("http:/u2fconformance.fidoalliance.org/uths/u2fservertest/v2");
		utd.setAuthSecret("some-auth-secret");
		utd.setNumberOfTests(4);
			
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		model.put("utd", utd );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String startTests(UTD utd, BindingResult result, ModelMap model) {
		logger.info("starting tests");

		if ( result.hasErrors() ){
			//Error URL may be?
			return "home";
		}
		
		model.put("utd", utd );
		logger.info("model: " +  model );
		logger.info("model: " +  ToStringBuilder.reflectionToString(utd, ToStringStyle.MULTI_LINE_STYLE) );
	
		
		startRegister( utd.getFsutURL() );
		
		return "home";
	}
	
	
	public String startRegister( String fsutURL ){
		RestTemplate restTemplate = new RestTemplate();
        String fsutResponse = null;
		try {
			fsutResponse = restTemplate.getForObject( fsutURL + "/startRegistrationREST?username=abc", String.class);
		} catch (RestClientException e) {
			logger.error("Unable to connect to FSUT. Make sure it is up and running.");
			throw e;
		}
        
        
        logger.info("s: " + fsutResponse );
		
		return fsutResponse;
	}
	
	
}
