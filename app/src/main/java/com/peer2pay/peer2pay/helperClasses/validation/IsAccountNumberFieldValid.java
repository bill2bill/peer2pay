package com.peer2pay.peer2pay.helperClasses.validation;

import android.support.design.widget.TextInputLayout;

public class IsAccountNumberFieldValid extends BaseValidator {
    private static final String ACCOUNT_NUMBER_REGEX = "[0-9]{8}";
    public IsAccountNumberFieldValid(TextInputLayout errorContainer) {
        super(errorContainer);
        mErrorMessage = "Invalid Account Number";
        mEmptyMessage = "Missing Account Number";
    }

    @Override
    protected boolean isValid(String input) {
        return matches(input, ACCOUNT_NUMBER_REGEX);
    }
}
