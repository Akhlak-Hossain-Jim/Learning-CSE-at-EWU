package dev.akhlak.java.cse405_a1_calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

public class MainActivity extends AppCompatActivity {

    private TextView tvExpression;
    private TextView tvResult;

    private StringBuilder expression = new StringBuilder();
    private boolean justEvaluated = false;
    private String lastResult = "";
    private String historyText = "";

    private final Function sinDeg = new Function("sin", 1) {
        @Override
        public double apply(double... args) {
            return Math.sin(Math.toRadians(args[0]));
        }
    };
    private final Function cosDeg = new Function("cos", 1) {
        @Override
        public double apply(double... args) {
            return Math.cos(Math.toRadians(args[0]));
        }
    };
    private final Function tanDeg = new Function("tan", 1) {
        @Override
        public double apply(double... args) {
            return Math.tan(Math.toRadians(args[0]));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        bindButtons();
    }

    private void initViews() {
        tvExpression = findViewById(R.id.tvExpression);
        tvResult = findViewById(R.id.tvResult);
    }

    private void bindButtons() {
        int[] digitIds = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
        String[] digitTokens = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < digitIds.length; i++) {
            final String token = digitTokens[i];
            ((Button) findViewById(digitIds[i])).setOnClickListener(v -> onDigitPressed(token));
        }
        ((Button) findViewById(R.id.btnDot)).setOnClickListener(v -> onDotPressed());

        ((Button) findViewById(R.id.btnAdd)).setOnClickListener(v -> onOperatorPressed("+"));
        ((Button) findViewById(R.id.btnSub)).setOnClickListener(v -> onOperatorPressed("−"));
        ((Button) findViewById(R.id.btnMul)).setOnClickListener(v -> onOperatorPressed("×"));
        ((Button) findViewById(R.id.btnDiv)).setOnClickListener(v -> onOperatorPressed("÷"));

        ((Button) findViewById(R.id.btnSin)).setOnClickListener(v -> onFunctionPressed("sin("));
        ((Button) findViewById(R.id.btnCos)).setOnClickListener(v -> onFunctionPressed("cos("));
        ((Button) findViewById(R.id.btnTan)).setOnClickListener(v -> onFunctionPressed("tan("));
        ((Button) findViewById(R.id.btnLog)).setOnClickListener(v -> onFunctionPressed("log10("));
        ((Button) findViewById(R.id.btnLn)).setOnClickListener(v -> onFunctionPressed("log("));
        ((Button) findViewById(R.id.btnSqrt)).setOnClickListener(v -> onFunctionPressed("sqrt("));

        ((Button) findViewById(R.id.btnPower)).setOnClickListener(v -> onAppend("^"));
        ((Button) findViewById(R.id.btnParenOpen)).setOnClickListener(v -> onAppend("("));
        ((Button) findViewById(R.id.btnParenClose)).setOnClickListener(v -> onAppend(")"));
        ((Button) findViewById(R.id.btnPercent)).setOnClickListener(v -> onAppend("%"));
        ((Button) findViewById(R.id.btnPi)).setOnClickListener(v -> onAppend("π"));
        ((Button) findViewById(R.id.btnE)).setOnClickListener(v -> onAppend("e"));

        ((Button) findViewById(R.id.btnSquare)).setOnClickListener(v -> onSquarePressed());

        ((Button) findViewById(R.id.btnAC)).setOnClickListener(v -> onAC());
        ((Button) findViewById(R.id.btnDel)).setOnClickListener(v -> onDel());
        ((Button) findViewById(R.id.btnEquals)).setOnClickListener(v -> onEquals());
    }

    private void onDigitPressed(String token) {
        if (justEvaluated) {
            expression.setLength(0);
            historyText = "";
            justEvaluated = false;
        }
        expression.append(token);
        updateDisplays();
    }

    private void onDotPressed() {
        if (justEvaluated) {
            expression.setLength(0);
            historyText = "";
            justEvaluated = false;
        }
        String expr = expression.toString();
        int lastOpIndex = -1;
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            if (c == '+' || c == '−' || c == '×' || c == '÷' || c == '(' || c == '^') {
                lastOpIndex = i;
                break;
            }
        }
        String currentToken = expr.substring(lastOpIndex + 1);
        if (currentToken.contains(".")) return;

        if (currentToken.isEmpty() || currentToken.equals("-")) {
            expression.append("0");
        }
        expression.append(".");
        updateDisplays();
    }

    private void onOperatorPressed(String token) {
        if (expression.length() == 0 && lastResult.isEmpty()) return;

        if (justEvaluated) {
            expression = new StringBuilder(lastResult);
            justEvaluated = false;
        }

        if (expression.length() > 0) {
            char last = expression.charAt(expression.length() - 1);
            if (last == '+' || last == '−' || last == '×' || last == '÷') {
                expression.deleteCharAt(expression.length() - 1);
            }
        }
        expression.append(token);
        updateDisplays();
    }

    private void onFunctionPressed(String funcToken) {
        if (justEvaluated) {
            expression.setLength(0);
            historyText = "";
            justEvaluated = false;
        }
        expression.append(funcToken);
        updateDisplays();
    }

    private void onAppend(String token) {
        if (justEvaluated && (token.equals("^") || token.equals("%"))) {
            expression = new StringBuilder(lastResult);
            justEvaluated = false;
        } else if (justEvaluated) {
            expression.setLength(0);
            historyText = "";
            justEvaluated = false;
        }
        expression.append(token);
        updateDisplays();
    }

    private void onSquarePressed() {
        if (expression.length() == 0) return;
        char last = expression.charAt(expression.length() - 1);
        if (Character.isDigit(last) || last == ')' || last == 'π' || last == 'e') {
            expression.append("^2");
            updateDisplays();
        }
    }

    private void onAC() {
        expression.setLength(0);
        justEvaluated = false;
        lastResult = "";
        historyText = "";
        tvExpression.setText("");
        tvResult.setText("");
    }

    private void onDel() {
        if (expression.length() == 0) return;
        expression.deleteCharAt(expression.length() - 1);
        updateDisplays();
    }

    private void onEquals() {
        String expr = expression.toString();
        if (expr.isEmpty()) return;

        String result = evaluate(expr);
        historyText = expr + " = " + result;
        tvExpression.setText(historyText);
        tvResult.setText(result);

        if (!result.equals("Error")) {
            lastResult = result;
            justEvaluated = true;
            expression = new StringBuilder(result);
        }
    }

    private void updateDisplays() {
        tvExpression.setText(historyText);
        tvResult.setText(expression.toString());
    }

    private String evaluate(String raw) {
        try {
            String preprocessed = preprocessExpression(raw);
            Expression exp = new ExpressionBuilder(preprocessed)
                    .functions(sinDeg, cosDeg, tanDeg)
                    .build();
            double result = exp.evaluate();
            return formatResult(result);
        } catch (Exception e) {
            return "Error";
        }
    }

    private String preprocessExpression(String raw) {
        String s = raw;

        s = s.replace("×", "*");
        s = s.replace("÷", "/");
        s = s.replace("−", "-");

        s = s.replace("π", String.valueOf(Math.PI));

        s = s.replaceAll("(?<![0-9])e(?![0-9])", String.valueOf(Math.E));

        s = s.replace("%", "*0.01");

        s = s.replaceAll("([0-9.])([(])", "$1*$2");
        s = s.replaceAll("[)]([(0-9.])", ")*$1");

        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else if (c == ')') open--;
        }
        if (open > 0) {
            s = s + ")".repeat(open);
        }

        return s;
    }

    private String formatResult(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) return "Error";

        if (value == Math.floor(value) && Math.abs(value) < 1e15) {
            return String.valueOf((long) value);
        }

        String formatted = String.format("%.10g", value);
        if (formatted.contains(".") && !formatted.contains("e")) {
            formatted = formatted.replaceAll("0+$", "").replaceAll("\\.$", "");
        }
        return formatted;
    }
}
