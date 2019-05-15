package io.apihub.client.api;

import io.apihub.client.ApiClient;
import io.apihub.client.ApiException;
import io.apihub.client.model.Peticion;
import io.apihub.client.model.Respuesta;
import io.apihub.interceptor.SignerInterceptor;
import okhttp3.OkHttpClient;

import org.junit.Test;
import org.junit.Before;

import java.util.concurrent.TimeUnit;


public class PldApiTest {

    private final PldApi api = new PldApi();
    private ApiClient apiClient;
    
    @Before()
    public void setUp() {
    	this.apiClient = api.getApiClient();

    	OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
    			.readTimeout(30, TimeUnit.SECONDS)
    			.addInterceptor(new SignerInterceptor())
    			.build();
    	apiClient.setHttpClient(okHttpClient);
    }

    @Test
    public void getValidadorTest() throws ApiException {
        String xApiKey = "XXXXXXXXXXX";
        String username = "XXXXXXXXXXX";
        String password = "XXXXXXXXXXX";
        Peticion body = new Peticion();
        
        body.setNombres("XXXXXXXXXXX");
        body.setApellidoPaterno("XXXXXXXXXXX");
        body.setApellidoMaterno("XXXXXXXXXXX");

        try {
            Respuesta response = api.getPLD(xApiKey, username, password, body);
            System.out.println(response.toString());
            
        } catch (ApiException e) {
        	
            e.printStackTrace();
            System.out.println(e.getResponseBody());
        }
    }
}
