package com.example.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {
    public String getUserText() {
        return userText;
    }

    public void setUserText(String userText) {
        this.userText = userText;
    }

    public String getPasswordText() {
        return passwordText;
    }

    public void setPasswordText(String passwordText) {
        this.passwordText = passwordText;
    }

    private String userText;
    private String passwordText;
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("dianji");
        String btnstr= e.getActionCommand();
        System.out.println(btnstr);
        System.out.println(e.paramString());
        System.out.println(e.getSource());

        System.out.println("1111111111111111111111111111111");
        System.out.println(userText);
        System.out.println(e.getSource().toString());
        System.out.println(passwordText);
    }
}
