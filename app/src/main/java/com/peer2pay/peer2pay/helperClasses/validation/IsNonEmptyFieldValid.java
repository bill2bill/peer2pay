package com.peer2pay.peer2pay.helperClasses.validation;

import android.support.design.widget.TextInputLayout;

public class IsNonEmptyFieldValid extends BaseValidator {
    public IsNonEmptyFieldValid(TextInputLayout errorContainer) {
        super(errorContainer);
    }
}
