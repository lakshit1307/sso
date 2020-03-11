package com.healthedge.sso.service.impl;

import com.healthedge.sso.dto.LoginRequest;
import com.healthedge.sso.dto.LoginResponse;
import com.healthedge.sso.service.LoginService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        LOGGER.trace("Login Request received for " + loginRequest.getUsername());
        String url = "https://healthedge-poc.okta.com/api/v1/authn";
        String response=restTemplate.postForObject(url, loginRequest, String.class);

        LoginResponse loginResponse=new LoginResponse();
        loginResponse.setStatus(getResponse(response));
        LOGGER.trace("Login Request processed for " + loginRequest.getUsername());
        return loginResponse;
    }

    private String getResponse(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
            if(jsonObject.has("status")){
                return "Success";
            }
        }
        catch (Exception e){
            LOGGER.error("Authentication error", e);
        }
        return "Failure";
    }


}
