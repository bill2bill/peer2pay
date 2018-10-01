package com.peer2pay.peer2pay.helperClasses.validation;

import android.support.design.widget.TextInputLayout;

public class IsPhoneNumberFieldValid extends BaseValidator {
    private static final String PHONE_NUMBER_REGEX = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]{4,20}$";
    public IsPhoneNumberFieldValid(TextInputLayout errorContainer) {
        super(errorContainer);
        mErrorMessage = "Invalid Phone Number";
    }

    @Override
    public boolean validate(String input) {
        if (mEmptyMessage != null && (input == null || input.length() == 0)) {
            return true;
        }
        if (isValid(input)) {
            //custom implementation of the isValid returns true
            mErrorContainer.setError("");
            return true;
        } else {
            //set error for any other case
            mErrorContainer.setError(mErrorMessage);
            return false;
        }
    }

    @Override
    protected boolean isValid(String input) {
        return matches(input, PHONE_NUMBER_REGEX);
    }
}
