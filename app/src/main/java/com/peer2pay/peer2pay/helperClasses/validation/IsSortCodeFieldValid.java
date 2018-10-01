package com.peer2pay.peer2pay.helperClasses.validation;

import android.support.design.widget.TextInputLayout;

public class IsSortCodeFieldValid extends BaseValidator {
    private static final String SORTCODE_REGEX = "[0-9]{6}";
    public IsSortCodeFieldValid(TextInputLayout errorContainer) {
        super(errorContainer);
        mErrorMessage = "Invalid Sort Number";
        mEmptyMessage = "Missing Sort Number";
    }

    @Override
    protected boolean isValid(String input) {
        return matches(input, SORTCODE_REGEX);
    }
}
