package com.v4lo.appuser;

public enum AppUserRole {
   USER(1,"user" ),
   ADMIN(2,"admin");

   private final Integer id;
   private final String value;

   AppUserRole(Integer id, String value){
       this.id = id;
       this.value = value;
   }

    public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
