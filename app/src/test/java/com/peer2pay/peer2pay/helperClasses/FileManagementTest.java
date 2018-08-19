package com.peer2pay.peer2pay.helperClasses;

import android.content.Context;

import com.peer2pay.peer2pay.helperClasses.management.FileManagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FileManagementTest {
    private Context context;
    @SuppressWarnings("ConstantConditions")
    private final FileManagement fileManagement = new FileManagement(context);

    @BeforeEach
    void setUp() {
        context = Mockito.mock(Context.class);
    }

    @Test
    void deleteCard() {
    }

    @Test
    void getAllCards() {
    }

    @Test
    void getCard() {
    }

    @Test
    void newCard() {
    }

    @Test
    void newTransaction() {
    }
}