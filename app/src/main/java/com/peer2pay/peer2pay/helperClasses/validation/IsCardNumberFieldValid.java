package com.peer2pay.peer2pay.helperClasses.validation;

import android.support.design.widget.TextInputLayout;

public class IsCardNumberFieldValid extends BaseValidator {
    private static final String CARD_NUMBER_REGEX = "[0-9]{16}";
    public IsCardNumberFieldValid(TextInputLayout errorContainer) {
        super(errorContainer);
        mErrorMessage = "Invalid Card Number";
        mEmptyMessage = "Missing Card Number";
    }

    @Override
    protected boolean isValid(String input) {
        return matches(input, CARD_NUMBER_REGEX);
    }
}
