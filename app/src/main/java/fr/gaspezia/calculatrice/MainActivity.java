package fr.gaspezia.calculatrice;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Double firstNumber = null;
    private String currentOperator = null;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.display);

        setNumberButtonListeners();
        setOperatorButtonListeners();
        setEqualButtonListener();
    }

    private void setNumberButtonListeners() {
        for (int i = 0; i <= 9; i++) {
            final int number = i;
            int id = getResources().getIdentifier("button" + number, "id", getPackageName());
            findViewById(id).setOnClickListener(v -> resultTextView.append(String.valueOf(number)));
        }
        findViewById(R.id.dot).setOnClickListener(v -> {
            if (!resultTextView.getText().toString().contains(".")) {
                resultTextView.append(".");
            }
        });
        findViewById(R.id.ce).setOnClickListener(v -> {
            firstNumber = null;
            currentOperator = null;
            resultTextView.setText("");
        });
    }

    private void setOperatorButtonListeners() {
        int[] operatorIds = {R.id.plus, R.id.minus, R.id.asterisk, R.id.slash};
        for (int id : operatorIds) {
            findViewById(id).setOnClickListener(v -> {
                firstNumber = Double.valueOf(resultTextView.getText().toString());
                currentOperator = ((TextView) v).getText().toString();
                resultTextView.setText("");
            });
        }
    }

    private void setEqualButtonListener() {
        findViewById(R.id.equal).setOnClickListener(v -> {
            if (firstNumber != null && currentOperator != null) {
                double secondNumber = Double.parseDouble(resultTextView.getText().toString());
                double result = calculateResult(secondNumber);
                resultTextView.setText(String.valueOf(result));
                firstNumber = null;
                currentOperator = null;
            }
        });
    }

    private double calculateResult(double secondNumber) {
        switch (currentOperator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                return firstNumber / secondNumber;
            default:
                return 0;
        }
    }
}