package com.peer2pay.peer2pay.helperClasses.validation;

import android.support.design.widget.TextInputLayout;

public class IsEmailFieldValid extends BaseValidator {
    private static final String EMAIL_REGEX = "[^@]+@[^\\.]+\\..+";
    public IsEmailFieldValid(TextInputLayout errorContainer) {
        super(errorContainer);
        mErrorMessage = "Invalid Email Address";
        mEmptyMessage = "Missing Email Address";
    }

    @Override
    protected boolean isValid(String input) {
        return matches(input, EMAIL_REGEX);
    }
}
