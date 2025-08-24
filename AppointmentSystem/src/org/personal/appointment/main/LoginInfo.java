/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.personal.appointment.main;

import java.util.HashMap;

public class LoginInfo {
    private HashMap<String, String> loginInfo = new HashMap<>();

    public LoginInfo() {
        // Fixed Admin credentials
        loginInfo.put("suyash", "suyash77");
    }

    public HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }
}

