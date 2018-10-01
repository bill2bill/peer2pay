package com.peer2pay.peer2pay.helperClasses.validation;

import android.support.design.widget.TextInputLayout;

public class IsExpireFieldValid extends BaseValidator {
    private static final String EXPIRE = "[0-9]{2}";
    public IsExpireFieldValid(TextInputLayout errorContainer) {
        super(errorContainer);
        mErrorMessage = "Invalid Expiry date";
        mEmptyMessage = "Missing Expiry date";
    }

    @Override
    protected boolean isValid(String input) {
        return matches(input, EXPIRE);
    }
}
