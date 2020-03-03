package com.example.class3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.class3.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText expenseInput;
    private EditText valueInput;
    private List<Expense> expenses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.expenseInput = findViewById(R.id.expenseInput);
        this.valueInput = findViewById(R.id.valueInput);

        Button addButton = findViewById(R.id.addButton);
        Button listButton = findViewById(R.id.listButton);
        Button totalButton = findViewById(R.id.totalButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { addButtonClick(); }
        });
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { listButtonClick(); }
        });
        totalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { totalButtonClick(); }
        });
    }

    private void listButtonClick() {
        Toast.makeText(MainActivity.this, buildExpenseList(), Toast.LENGTH_LONG).show();
    }

    private void totalButtonClick() {
        Double total = 0.0;

        for (Expense expense : expenses) {
            total += expense.getValue();
        }

        Toast.makeText(MainActivity.this, total.toString(), Toast.LENGTH_SHORT).show();
    }

    private void addButtonClick() {
        Expense expense = new Expense();
        expense.setDescription(expenseInput.getText().toString());
        expense.setValue(Double.valueOf(valueInput.getText().toString()));

        expenses.add(expense);

        cleanUpFields();

        Toast.makeText(this, "Added successfully", Toast.LENGTH_SHORT).show();
    }

    private void cleanUpFields() {
        this.expenseInput.getText().clear();
        this.valueInput.getText().clear();
    }

    private String buildExpenseList() {
        System.out.println(expenses);
        return expenses.toString();
    }


}
