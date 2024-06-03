package fr.gaspezia.calculatrice;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Double firstNumber = null;
    private String currentOperator = null;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.display);

        findViewById(R.id.button0).setOnClickListener(v -> resultTextView.setText(resultTextView.getText() + "0"));
        findViewById(R.id.button1).setOnClickListener(v -> resultTextView.setText(resultTextView.getText() + "1"));
        findViewById(R.id.button2).setOnClickListener(v -> resultTextView.setText(resultTextView.getText() + "2"));
        findViewById(R.id.button3).setOnClickListener(v -> resultTextView.setText(resultTextView.getText() + "3"));
        findViewById(R.id.button4).setOnClickListener(v -> resultTextView.setText(resultTextView.getText() + "4"));
        findViewById(R.id.button5).setOnClickListener(v -> resultTextView.setText(resultTextView.getText() + "5"));
        findViewById(R.id.button6).setOnClickListener(v -> resultTextView.setText(resultTextView.getText() + "6"));
        findViewById(R.id.button7).setOnClickListener(v -> resultTextView.setText(resultTextView.getText() + "7"));
        findViewById(R.id.button8).setOnClickListener(v -> resultTextView.setText(resultTextView.getText() + "8"));
        findViewById(R.id.button9).setOnClickListener(v -> resultTextView.setText(resultTextView.getText() + "9"));
        findViewById(R.id.ce).setOnClickListener(v -> {
            firstNumber = null;
            currentOperator = null;
            resultTextView.setText("");
        });
        findViewById(R.id.dot).setOnClickListener(v -> {
            if (!resultTextView.getText().toString().contains(".")) {
                resultTextView.setText(resultTextView.getText() + ".");
            }
        });

        findViewById(R.id.minus).setOnClickListener(v -> {
            firstNumber = Double.valueOf(resultTextView.getText().toString());
            currentOperator = "-";
            resultTextView.setText("");
        });

        findViewById(R.id.plus).setOnClickListener(v -> {
            firstNumber = Double.valueOf(resultTextView.getText().toString());
            currentOperator = "+";
            resultTextView.setText("");
        });

        findViewById(R.id.asterisk).setOnClickListener(v -> {
            firstNumber = Double.valueOf(resultTextView.getText().toString());
            currentOperator = "*";
            resultTextView.setText("");
        });

        findViewById(R.id.slash).setOnClickListener(v -> {
            firstNumber = Double.valueOf(resultTextView.getText().toString());
            currentOperator = "/";
            resultTextView.setText("");
        });

        findViewById(R.id.equal).setOnClickListener(v -> {
            if (firstNumber != null && currentOperator != null) {
                double secondNumber = Double.parseDouble(resultTextView.getText().toString());
                if (currentOperator.equals("+")) {
                    double result = firstNumber + secondNumber;
                    resultTextView.setText(String.valueOf(result));
                }
                if (currentOperator.equals("*")) {
                    double result = firstNumber * secondNumber;
                    resultTextView.setText(String.valueOf(result));
                }
                if (currentOperator.equals("-")) {
                    double result = firstNumber - secondNumber;
                    resultTextView.setText(String.valueOf(result));
                }
                if (currentOperator.equals("/")) {
                    double result = firstNumber / secondNumber;
                    resultTextView.setText(String.valueOf(result));
                }
                firstNumber = null;
                currentOperator = null;
            }
        });
    }
}