package com.example.turismmd_final.Model;

public class ErrorRespose {
    //{"code":404,"message":"Not found user with this username","status":"NOT OK"}

   private String code ;
   private String message;
   private String status;


    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
