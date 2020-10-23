package com.cdc.apihub.mx.pld.client.api;

import okhttp3.OkHttpClient;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdc.apihub.mx.pld.client.ApiClient;
import com.cdc.apihub.mx.pld.client.ApiException;
import com.cdc.apihub.mx.pld.client.api.PldApi;
import com.cdc.apihub.mx.pld.client.model.Peticion;
import com.cdc.apihub.mx.pld.client.model.Respuesta;
import com.cdc.apihub.signer.manager.interceptor.SignerInterceptor;

import static org.junit.Assert.assertTrue;

import org.junit.Before;


public class PldApiTest {

	private Logger logger = LoggerFactory.getLogger(PldApiTest.class.getName());
    private final PldApi api = new PldApi();
    private ApiClient apiClient;

	private String keystoreFile = "your_path_for_your_keystore/keystore.jks";
	private String cdcCertFile = "your_path_for_certificate_of_cdc/cdc_cert_dev.pem";
	private String keystorePassword = "your_super_secure_keystore_password";
	private String keyAlias = "your_key_alias";
	private String keyPassword = "your_super_secure_password";
	
	private String usernameCDC = "your_username_otrorgante";
	private String passwordCDC = "your_password_otorgante";	
	
	private String url = "the_url";
	private String xApiKey = "X_Api_Key";
	
	private SignerInterceptor interceptor;
    
    @Before()
    public void setUp() {
    	interceptor = new SignerInterceptor(this.keystoreFile, this.cdcCertFile, this.keystorePassword, 
    										this.keyAlias, this.keyPassword);
		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath(url);
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
			    .addInterceptor(interceptor)
			    .build();
		apiClient.setHttpClient(okHttpClient);
    }

    @Test
    public void getValidadorTest() throws ApiException {
		Integer statusNotFound = 404;	
        Peticion body = new Peticion();
        
        body.setNombres("JUAN");
        body.setApellidoPaterno("PRUEBA");
        body.setApellidoMaterno("CUATRO");

        try {
            Respuesta response = api.getPLD(xApiKey, this.usernameCDC, this.passwordCDC, body);
            assertTrue(response.getFolioConsulta() != null);
            logger.info(response.toString());
        } catch (ApiException e) {
        	assertTrue(statusNotFound.equals(e.getCode()));
            logger.error(e.getResponseBody());
        }
    }
}
