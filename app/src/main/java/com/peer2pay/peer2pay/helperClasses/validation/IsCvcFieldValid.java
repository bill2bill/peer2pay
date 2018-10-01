package com.peer2pay.peer2pay.helperClasses.validation;

import android.support.design.widget.TextInputLayout;

public class IsCvcFieldValid extends BaseValidator {
    private static final String CVC_REGEX = "[0-9]{3}";
    public IsCvcFieldValid(TextInputLayout errorContainer) {
        super(errorContainer);
        mErrorMessage = "Invalid CVC Number";
        mEmptyMessage = "Missing CVC Number";
    }

    @Override
    protected boolean isValid(String input) {
        return matches(input, CVC_REGEX);
    }
}
