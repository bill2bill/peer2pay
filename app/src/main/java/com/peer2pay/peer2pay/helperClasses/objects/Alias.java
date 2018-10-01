package com.peer2pay.peer2pay.helperClasses.objects;

import com.peer2pay.peer2pay.helperClasses.enums.Country;
import com.peer2pay.peer2pay.helperClasses.enums.VisaType;

import java.util.Date;

public class Alias {
    //Mandatory
    private String guid;
    private String recipientFirstName;
    private String recipientLastName;
    private Country country;
    private Date consentDateTime;
    private String recipientPrimaryAccountNumber;
    private String issuerName;
    private VisaType cardType;
    private String alias;
    private int aliasType;

    //Optional
    private String recipientMiddleName;
    private String Address1;
    private String Address2;
    private String city;
    private String postCode;
    private String contactPhoneNumber;
    private String contactEmail;
}
