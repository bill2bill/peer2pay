package com.peer2pay.peer2pay.appPages;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.peer2pay.peer2pay.R;
import com.peer2pay.peer2pay.helperClasses.validation.IsCardNumberFieldValid;
import com.peer2pay.peer2pay.helperClasses.validation.IsEmailFieldValid;
import com.peer2pay.peer2pay.helperClasses.validation.IsNonEmptyFieldValid;
import com.peer2pay.peer2pay.helperClasses.validation.IsPhoneNumberFieldValid;
import com.peer2pay.peer2pay.helperClasses.validation.IsPostCodeFieldValid;

public class AddForm extends AppCompatActivity implements View.OnFocusChangeListener, View.OnClickListener {
    //Validator
    private IsCardNumberFieldValid isCardNumberFieldValid;
    private IsNonEmptyFieldValid isFistNameFieldValid;
    private IsNonEmptyFieldValid isLastNameFieldValid;
    private IsPostCodeFieldValid isPostCodeFieldValid;
    private IsPhoneNumberFieldValid isPhoneNumberFieldValid;
    private IsEmailFieldValid isEmailFieldValid;

    //Form fields
    private TextInputEditText card_number_editor;
    private Spinner issuer_editor;
    private Spinner card_type_editor;
    private TextInputEditText first_name_editor;
    private TextInputEditText middle_name_editor;
    private TextInputEditText last_name_editor;
    private TextInputEditText address_one_editor;
    private Spinner country_editor;
    private TextInputEditText city_editor;
    private TextInputEditText post_code_editor;
    private TextInputEditText phone_editor;
    private TextInputEditText email_editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);

        //Form fields
        TextInputLayout card_number_wrapper = findViewById(R.id.card_number_wrapper);
        card_number_editor = findViewById(R.id.card_number_edit);

        TextInputLayout issuer_wrapper = findViewById(R.id.issuer_name_wrapper);
        issuer_editor = findViewById(R.id.issuer_name_edit);

        TextInputLayout card_type_wrapper = findViewById(R.id.card_type_wrapper);
        card_type_editor = findViewById(R.id.card_type_edit);

        TextInputLayout first_name_wrapper = findViewById(R.id.first_name_wrapper);
        first_name_editor = findViewById(R.id.first_name_edit);

        TextInputLayout middle_name_wrapper = findViewById(R.id.middle_name_wrapper);
        middle_name_editor = findViewById(R.id.middle_name_edit);

        TextInputLayout last_name_wrapper = findViewById(R.id.last_name_wrapper);
        last_name_editor = findViewById(R.id.last_name_edit);

        TextInputLayout address_one_wrapper = findViewById(R.id.address_one_wrapper);
        address_one_editor = findViewById(R.id.address_one_edit);

        TextInputLayout country_wrapper = findViewById(R.id.country_wrapper);
        country_editor = findViewById(R.id.country_edit);

        TextInputLayout city_wrapper = findViewById(R.id.city_wrapper);
        city_editor = findViewById(R.id.city_edit);

        TextInputLayout post_code_wrapper = findViewById(R.id.post_code_wrapper);
        post_code_editor = findViewById(R.id.post_code_edit);

        TextInputLayout phone_wrapper = findViewById(R.id.phone_number_wrapper);
        phone_editor = findViewById(R.id.phone_number_edit);

        TextInputLayout email_wrapper = findViewById(R.id.email_wrapper);
        email_editor = findViewById(R.id.email_edit);


        //set onFocus change Listener to all the EditText Views
        card_number_editor.setOnFocusChangeListener(this);
        first_name_editor.setOnFocusChangeListener(this);
        last_name_editor.setOnFocusChangeListener(this);
        post_code_editor.setOnFocusChangeListener(this);
        phone_editor.setOnFocusChangeListener(this);
        email_editor.setOnFocusChangeListener(this);

        //Init validators
        isCardNumberFieldValid = new IsCardNumberFieldValid(card_number_wrapper);
        isFistNameFieldValid = new IsNonEmptyFieldValid(first_name_wrapper);
        isLastNameFieldValid = new IsNonEmptyFieldValid(last_name_wrapper);
        isPostCodeFieldValid = new IsPostCodeFieldValid(post_code_wrapper);
        isPhoneNumberFieldValid = new IsPhoneNumberFieldValid(phone_wrapper);
        isEmailFieldValid = new IsEmailFieldValid(email_wrapper);

        Button mSignUpButton = (Button) findViewById(R.id.submit);

        //set the submit button onclick Listener
        mSignUpButton.setOnClickListener(this);
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if (hasFocus) {
            return; //we want to validate only fields loosing focus and not fields gaining focus
        }

        int id = view.getId();
        if (id == R.id.card_number_edit) {
            isCardNumberFieldValid.validate(card_number_editor.getText().toString());
        }
        if (id == R.id.first_name_edit) {
            isFistNameFieldValid.validate(first_name_editor.getText().toString());
        }
        if (id == R.id.last_name_edit) {
            isLastNameFieldValid.validate(last_name_editor.getText().toString());
        }
        if (id == R.id.post_code_edit) {
            isPostCodeFieldValid.validate(post_code_editor.getText().toString());
        }
        if (id == R.id.phone_number_edit) {
            isPhoneNumberFieldValid.validate(phone_editor.getText().toString());
        }
        if (id == R.id.email_edit) {
            isEmailFieldValid.validate(email_editor.getText().toString());
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.submit) {
            //required fields
            String card_number = card_number_editor.getText().toString();
            String first_name = first_name_editor.getText().toString();
            String last_name = last_name_editor.getText().toString();
            String country = country_editor.getTransitionName();
            String issuer = issuer_editor.getTransitionName();
            String card_type = card_type_editor.getTransitionName();
            String email = email_editor.getText().toString();

            //not required fields
            String middle_name = middle_name_editor.getText().toString();
            String address_one = address_one_editor.getText().toString();
            String city = city_editor.getText().toString();
            String post_code = post_code_editor.getText().toString();
            String phone_number = phone_editor.getText().toString();


            boolean cardNumberIsValid = isCardNumberFieldValid.validate(card_number);
            boolean firstNameIsValid = isFistNameFieldValid.validate(first_name);
            boolean lastNameIsValid = isLastNameFieldValid.validate(last_name);
            boolean postCodeIsValid = isPostCodeFieldValid.validate(post_code);
            boolean phoneNumberIsValid = isPhoneNumberFieldValid.validate(phone_number);
            boolean emailIsValid = isEmailFieldValid.validate(email);

            if (cardNumberIsValid && firstNameIsValid && lastNameIsValid && postCodeIsValid && phoneNumberIsValid && emailIsValid) {
                //go ahead ans submit the form for all things are fine now
                Toast.makeText(this, "All field Validations passed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
