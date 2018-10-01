package com.peer2pay.peer2pay.helperClasses.validation;

import android.support.design.widget.TextInputLayout;

public class BaseValidator {
    protected TextInputLayout mErrorContainer;
    protected String mErrorMessage = "";
    protected String mEmptyMessage = "This field is required";

    public BaseValidator(TextInputLayout errorContainer) {
        mErrorContainer = errorContainer;
    }

    protected boolean isValid(String input) {
        //other classed shall overide this method and have there custom
        //implementation
        return true;
    }

    public boolean validate(String input) {
        if (mEmptyMessage != null && (input == null || input.length() == 0)) {
            //set Empty error message for any empty field
            mErrorContainer.setError(mEmptyMessage);
            return false;
        } else if (isValid(input)) {
            //custom implementation of the isValid returns true
            mErrorContainer.setError("");
            return true;
        } else {
            //set error for any other case
            mErrorContainer.setError(mErrorMessage);
            return false;
        }
    }


    boolean matches(String text, String regex){
        return text.matches(regex);
    }
}
