package kalk.com.kalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPlus, btnMin, btnMulti, btnDivide, btnClear;
    TextView txtResult;
    EditText inputOne, inputTwo;

    double result;
    boolean yes = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(this);
        btnMin = (Button) findViewById(R.id.btnMin);
        btnMin.setOnClickListener(this);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnMulti.setOnClickListener(this);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(this);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        txtResult = (TextView) findViewById(R.id.txtResult);

        inputOne = (EditText) findViewById(R.id.inputFoo);
        inputTwo = (EditText) findViewById(R.id.inputFoo1);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPlus:
                checkInput();
                if (yes) {
                    result = getOne() + getTwo();
                    txtResult.setText(String.valueOf(result));
                }
                break;
            case R.id.btnMin:
                checkInput();
                if (yes) {
                    result = getOne() - getTwo();
                    txtResult.setText(String.valueOf(result));
                }
                break;
            case R.id.btnMulti:
                checkInput();
                if (yes) {
                    result = getOne() * getTwo();
                    txtResult.setText(String.valueOf(result));
                }
                break;
            case R.id.btnDivide:
                checkInput();
                if (yes) {
                    result = getOne() / getTwo();
                    txtResult.setText(String.valueOf(result));
                }
                break;
            default:
                clearText();
                break;
        }
    }

    private boolean checkInput() {
        if (inputOne.getText().length() == 0) {
            inputOne.setError(getString(R.string.input_error));
            yes = false;
        }
        else if (inputTwo.getText().length() == 0) {
            inputTwo.setError(getString(R.string.input_error));
            yes = false;
        } else {
            yes = true;
        }

        return yes;
    }

    private void clearText() {
        inputTwo.setText("");
        inputOne.setText("");

        Toast.makeText(getApplicationContext(),"Cleared!", Toast.LENGTH_SHORT).show();
    }

    private double getOne() {
        return Double.parseDouble(inputOne.getText().toString());
    }

    private double getTwo() {
        return Double.parseDouble(inputTwo.getText().toString());
    }
}
