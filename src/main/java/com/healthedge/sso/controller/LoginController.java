package com.healthedge.sso.controller;

import com.healthedge.sso.dto.LoginRequest;
import com.healthedge.sso.dto.LoginResponse;
import com.healthedge.sso.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Api(value = "Login", description = "Rest endpoints for login management")
@Controller
@RequestMapping(value = "v1.0")
public class LoginController {

    @Autowired
    public LoginService loginService;

    @ApiOperation(value = "This api is used for login")
    @PostMapping(value = "/login")
    @ResponseBody
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse=loginService.login(loginRequest);
        return new ResponseEntity(loginResponse, HttpStatus.OK);
    }

    @GetMapping("/vendor/login")
    public ResponseEntity<LoginResponse> vendorLogin(Principal principal) {

        LoginResponse loginResponse=new LoginResponse();
        loginResponse.setMessage("You are logged in");
        loginResponse.setStatus("Hell Yeah!!!");
        return new ResponseEntity(loginResponse, HttpStatus.OK);
    }

}
