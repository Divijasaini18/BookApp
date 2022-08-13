package com.example.login.Service;

import java.util.Map;

import com.example.login.Model.User;

public interface SecurityTokenGenerator {

  Map<String,String> generateToken(User user);
}
