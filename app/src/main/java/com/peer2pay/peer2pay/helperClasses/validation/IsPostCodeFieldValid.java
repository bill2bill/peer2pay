package com.peer2pay.peer2pay.helperClasses.validation;

import android.support.design.widget.TextInputLayout;

public class IsPostCodeFieldValid extends BaseValidator {
    private static final String POST_CODE_REGEX = "[A-Z]{1,2}[0-9][0-9A-Z]?\\s?[0-9][A-Z][A-Z]";
    public IsPostCodeFieldValid(TextInputLayout errorContainer) {
        super(errorContainer);
        mErrorMessage = "Invalid post code";
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
        return matches(input, POST_CODE_REGEX);
    }
}
