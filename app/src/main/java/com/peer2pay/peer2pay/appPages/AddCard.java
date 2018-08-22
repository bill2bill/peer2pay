package com.peer2pay.peer2pay.appPages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.peer2pay.peer2pay.helperClasses.fileManagement.CardFileManagement;
import com.peer2pay.peer2pay.helperClasses.validation.InputValidator;
import com.peer2pay.peer2pay.R;

public class AddCard extends AppCompatActivity {
    CardFileManagement cardFileManagement;
    private boolean isValidPostcode;
    private boolean isValidExpire;
    private boolean isValid_Account_number;
    private boolean isValidSortcode;
    private boolean isValidCvc;
    private boolean isValid_Card_number;
    private boolean isValidKey;

    private EditText postcode;
    private EditText expire;
    private EditText account_number;
    private EditText sortcode;
    private EditText cvc;
    private EditText card_number;
    private EditText key;

    private TextView validView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        postcode = findViewById(R.id.postcode);
        expire = findViewById(R.id.expire);
        account_number = findViewById(R.id.account_number);
        sortcode = findViewById(R.id.sortcode);
        cvc = findViewById(R.id.cvc);
        card_number = findViewById(R.id.card_number);
        key = findViewById(R.id.key);

        validView = findViewById(R.id.valid);

        cardFileManagement = new CardFileManagement(getApplicationContext());

        validateFields();
    }

    public void submit(View view){
        validateFields();
        if (isValidForm()){
            cardFileManagement.newCard(getKey(), getCardNumber(), "", getExpire(), getCvc(), getPostCode(), getSortcode(), getAccount_Number());
            setContentView(R.layout.activity_cards);
        }
        validView.setText(R.string.Incomplete);
    }

    //helper methods
    boolean isValidForm(){
        validateFields();
        return isValidPostcode && isValidExpire && isValid_Account_number && isValidSortcode && isValidCvc && isValid_Card_number;
    }

    void validateFields(){
        validatePostcode(postcode, "[a-zA-Z0-9]{6}");
        validateExpire(expire, "\\d{2}/\\d{2}");
        validateAcountNumber(account_number, "\\d{8}");
        validateSortcode(sortcode, "\\d{6}");
        validateCvc(cvc, "\\d{3}");
        validateCardNumber(card_number, "\\d{16}");
    }

    String getKey(){
        return key.getText().toString();
    }

    String getPostCode(){
        return postcode.getText().toString();
    }

    String getExpire(){
        return expire.getText().toString();
    }

    String getAccount_Number(){
        return account_number.getText().toString();
    }

    String getSortcode(){
        return sortcode.getText().toString();
    }

    String getCvc(){
        return cvc.getText().toString();
    }

    String getCardNumber(){
        return card_number.getText().toString();
    }

    void validatePostcode(EditText id, final String regex){
        id.addTextChangedListener(new InputValidator(id) {
            @Override public void validate(TextView textView, String text) {
                isValidPostcode = matches(text, regex);
            }
        });
    }

    void validateExpire(EditText id, final String regex){
        id.addTextChangedListener(new InputValidator(id) {
            @Override public void validate(TextView textView, String text) {
                isValidExpire = matches(text, regex);
            }
        });
    }

    void validateAcountNumber(EditText id, final String regex){
        id.addTextChangedListener(new InputValidator(id) {
            @Override public void validate(TextView textView, String text) {
                isValid_Account_number = matches(text, regex);
            }
        });
    }

    void validateSortcode(EditText id, final String regex){
        id.addTextChangedListener(new InputValidator(id) {
            @Override public void validate(TextView textView, String text) {
                isValidSortcode = matches(text, regex);
            }
        });
    }

    void validateCvc(EditText id, final String regex){
        id.addTextChangedListener(new InputValidator(id) {
            @Override public void validate(TextView textView, String text) {
                isValidCvc = matches(text, regex);
            }
        });
    }

    void validateCardNumber(EditText id, final String regex){
        id.addTextChangedListener(new InputValidator(id) {
            @Override public void validate(TextView textView, String text) {
                isValid_Card_number = matches(text, regex);
            }
        });
    }

    boolean matches(String text, String regex){
        return text.matches(regex);
    }
}
