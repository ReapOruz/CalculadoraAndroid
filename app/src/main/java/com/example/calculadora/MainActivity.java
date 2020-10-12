package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.calculadora.OperacionesBasicas.Divison;
import com.example.calculadora.OperacionesBasicas.Multiplicacion;
import com.example.calculadora.OperacionesBasicas.OperacionesBasicas;
import com.example.calculadora.OperacionesBasicas.Resta;
import com.example.calculadora.OperacionesBasicas.Suma;
import com.example.calculadora.OperacionesEspeciales.OperacionesEspeciales;
import com.example.calculadora.OperacionesEspeciales.Tangente;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static final String SUMA = "suma";
    static final String RESTA = "resta";
    static final String MULT = "multiplicacion";
    static final String DIVISION = "division";
    static final String TAN = "tangente";
    static final String SEN = "seno";
    static final String COS = "coseno";
    static final String LOG = "logaritmo";
    static final String SUMA_SIMBOLO = "+";
    static final String RESTA_SIMBOLO = "-";
    static final String MULT_SIMBOLO = "*";
    static final String DIV_SIMBOLO = "/";
    static final String TAN_SIMBOLO = "Tan ";
    static final String SEN_SIMBOLO = "Sin ";
    static final String COS_SIMBOLO = "Cos ";
    static final String LOG_SIMBOLO = "Log ";
    private String pantallaTemporal;
    private String operacionTemporal;
    private String simboloOperacionTemporal;
    private double valor1 = 0;
    private double valor2 = 0;
    private OperacionesBasicas operacion;
    private OperacionesEspeciales operacionEspecial;

    //declaración de botones
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button btnPunto;
    private Button btnIgual;
    private Button btnSuma;
    private Button btnResta;
    private Button btnMultiplicacion;
    private Button btnDivison;
    private Button btnTan;
    private Button btnSen;
    private Button btnCos;
    private Button btnLog;
    private Button btnLimpiar;
    private TextView pantalla;
    private TextView pantallaEntrada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btnPunto = findViewById(R.id.btnPunto);
        btnIgual = findViewById(R.id.btnIgual);
        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnMultiplicacion = findViewById(R.id.btnMult);
        btnDivison = findViewById(R.id.btnDivision);
        btnTan = findViewById(R.id.btnTan);
        btnSen = findViewById(R.id.btnSin);
        btnCos = findViewById(R.id.btnCos);
        btnLog = findViewById(R.id.btnLog);
        pantalla = findViewById(R.id.textPantalla);
        pantallaEntrada = findViewById(R.id.textEntrada);
        btnLimpiar = findViewById(R.id.btnLimpiarPantalla);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnPunto.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
        btnSuma.setOnClickListener(this);
        btnResta.setOnClickListener(this);
        btnMultiplicacion.setOnClickListener(this);
        btnDivison.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnSen.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnLog.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
    }

    public boolean validarCeroInicial(String cadena) {
        boolean ceroInicial = false;
        if (cadena.equalsIgnoreCase("0")) {
            ceroInicial = true;
        }
        return ceroInicial;
    }

    public boolean validarPunto(String cadena) {
        boolean punto = false;
        String ultimoDigito = cadena.substring(cadena.length() - 1);
        if (ultimoDigito.equalsIgnoreCase(".") || cadena.contains(".")
        ) {
            punto = true;
        }
        return punto;
    }

    public void insertarDigito(String digito) {
        if (validarCeroInicial(pantallaTemporal)) {
            pantalla.setText(digito);
        } else if (pantallaTemporal.length() <= 20) pantalla.setText(pantallaTemporal + digito);
    }

    public void limpiarPantalla() {
        pantalla.setText("");
    }

    public void establecerValorDefault() {
        pantalla.setText("0");
        pantallaEntrada.setText("0");
        valor1 = 0;
        valor2 = 0;
        desbloquearBotonesNumericos();
        desbloquearBontesOperacionesBasicas();
        desbloquearBotonesOperacionesEspeciales();
    }

    public double definirOperacionBasica(String tipoOperacion, OperacionesBasicas operacion) {
        double resultado = 0;

        switch (tipoOperacion) {
            case SUMA:
                resultado = operacion.calcular(valor1, valor2);
                break;
            case RESTA:
                resultado = operacion.calcular(valor1, valor2);
                break;
            case MULT:
                resultado = operacion.calcular(valor1, valor2);
                break;
            case DIVISION:
                resultado = operacion.calcular(valor1, valor2);
                break;
        }
        return resultado;
    }

    public double definirOperacionEspecial(String tipoOperacion, OperacionesEspeciales operacionEspecial) {
        double resultado = 0;

        switch (tipoOperacion) {
            case TAN:
                resultado = operacionEspecial.calcular(valor1);
                break;
            case SEN:
                resultado = operacionEspecial.calcular(valor1);
                break;
            case COS:
                resultado = operacionEspecial.calcular(valor1);
                break;
            case LOG:
                resultado = operacionEspecial.calcular(valor1);
                break;
        }
        return resultado;
    }

    public boolean validarEntero(double numero) {
        boolean esEntero = false;
        if (numero % 1 == 0) {
            esEntero = true;
        }
        return esEntero;
    }

    public int convertirAEntero(double numero) {
        int converted = (int) numero;
        return converted;
    }

    public String validarConversion(double numero) {
        String valorConvertido;
        if (validarEntero(numero)) {
            valorConvertido = String.valueOf(convertirAEntero(numero));
        } else {
            valorConvertido = String.valueOf(numero);
        }
        return valorConvertido;
    }

    public void bloquearBotonesNumericos() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
        btn0.setEnabled(false);
        btnPunto.setEnabled(false);
        btnIgual.setEnabled(false);
    }

    public void desbloquearBotonesNumericos() {
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btn0.setEnabled(true);
        btnPunto.setEnabled(true);
        btnIgual.setEnabled(true);
    }

    public void bloquearBontesOperacionesBasicas() {
        btnSuma.setEnabled(false);
        btnResta.setEnabled(false);
        btnMultiplicacion.setEnabled(false);
        btnDivison.setEnabled(false);
    }

    public void desbloquearBontesOperacionesBasicas() {
        btnSuma.setEnabled(true);
        btnResta.setEnabled(true);
        btnMultiplicacion.setEnabled(true);
        btnDivison.setEnabled(true);
    }

    public void bloquearBotonesOperacionesEspeciales() {
        btnTan.setEnabled(false);
        btnSen.setEnabled(false);
        btnCos.setEnabled(false);
        btnLog.setEnabled(false);
    }

    public void desbloquearBotonesOperacionesEspeciales() {
        btnTan.setEnabled(true);
        btnSen.setEnabled(true);
        btnCos.setEnabled(true);
        btnLog.setEnabled(true);
    }

    @Override
    public void onClick(View view) {

        pantallaTemporal = pantalla.getText().toString().trim();
        String ultimoValorCadena;

        switch (view.getId()) {
            case R.id.btn1:
                insertarDigito("1");
                break;

            case R.id.btn2:
                insertarDigito("2");
                break;

            case R.id.btn3:
                insertarDigito("3");
                break;

            case R.id.btn4:
                insertarDigito("4");
                break;

            case R.id.btn5:
                insertarDigito("5");
                break;

            case R.id.btn6:
                insertarDigito("6");
                break;

            case R.id.btn7:
                insertarDigito("7");
                break;

            case R.id.btn8:
                insertarDigito("8");
                break;

            case R.id.btn9:
                insertarDigito("9");
                break;

            case R.id.btn0:
                insertarDigito("0");
                break;

            case R.id.btnPunto:
                if (!pantallaTemporal.equalsIgnoreCase("")) {
                    if (validarPunto(pantallaTemporal)) {
                        pantalla.setText(pantallaTemporal);
                    } else if (pantallaTemporal.equalsIgnoreCase("0")) {
                        insertarDigito("0.");
                    } else {
                        insertarDigito(".");
                    }

                }
                break;

            case R.id.btnLimpiarPantalla:
                establecerValorDefault();
                break;

            case R.id.btnSuma:
                if (!pantallaTemporal.equalsIgnoreCase("")) {
                    if (!pantallaEntrada.getText().toString().substring(pantallaEntrada.getText().toString().trim().length() - 1).equalsIgnoreCase(SUMA_SIMBOLO)) {
                        operacion = new Suma();
                        operacionTemporal = SUMA;
                        simboloOperacionTemporal = SUMA_SIMBOLO;
                        valor1 = Double.parseDouble(pantallaTemporal);
                        pantallaEntrada.setText(pantallaTemporal + simboloOperacionTemporal);
                        limpiarPantalla();
                        desbloquearBotonesNumericos();
                        bloquearBontesOperacionesBasicas();
                    }
                }
                break;

            case R.id.btnResta:
                if (!pantallaTemporal.equalsIgnoreCase("")) {
                    if (!pantallaEntrada.getText().toString().substring(pantallaEntrada.getText().toString().trim().length() - 1).equalsIgnoreCase(RESTA_SIMBOLO)) {
                        operacion = new Resta();
                        operacionTemporal = RESTA;
                        simboloOperacionTemporal = RESTA_SIMBOLO;
                        valor1 = Double.parseDouble(pantallaTemporal);
                        pantallaEntrada.setText(pantallaTemporal + simboloOperacionTemporal);
                        limpiarPantalla();
                        desbloquearBotonesNumericos();
                        bloquearBontesOperacionesBasicas();
                    }
                }
                break;

            case R.id.btnMult:
                if (!pantallaTemporal.equalsIgnoreCase("")) {
                    if (!pantallaEntrada.getText().toString().substring(pantallaEntrada.getText().toString().trim().length() - 1).equalsIgnoreCase(MULT_SIMBOLO)) {
                        operacion = new Multiplicacion();
                        operacionTemporal = MULT;
                        simboloOperacionTemporal = MULT_SIMBOLO;
                        valor1 = Double.parseDouble(pantallaTemporal);
                        pantallaEntrada.setText(pantallaTemporal + simboloOperacionTemporal);
                        limpiarPantalla();
                        desbloquearBotonesNumericos();
                        bloquearBontesOperacionesBasicas();
                    }
                }
                break;

            case R.id.btnDivision:
                if (!pantallaTemporal.equalsIgnoreCase("")) {
                    if (!pantallaEntrada.getText().toString().substring(pantallaEntrada.getText().toString().trim().length() - 1).equalsIgnoreCase(DIV_SIMBOLO)) {
                        operacion = new Divison();
                        operacionTemporal = DIVISION;
                        simboloOperacionTemporal = DIV_SIMBOLO;
                        valor1 = Double.parseDouble(pantallaTemporal);
                        pantallaEntrada.setText(pantallaTemporal + simboloOperacionTemporal);
                        limpiarPantalla();
                        desbloquearBotonesNumericos();
                        bloquearBontesOperacionesBasicas();
                    }
                }
                break;

            case R.id.btnTan:
                ultimoValorCadena = pantallaEntrada.getText().toString().substring(pantallaEntrada.getText().toString().trim().length() - 1);
                if (!ultimoValorCadena.equalsIgnoreCase(SUMA_SIMBOLO)
                        && !ultimoValorCadena.equalsIgnoreCase(RESTA_SIMBOLO)
                        && !ultimoValorCadena.equalsIgnoreCase(DIV_SIMBOLO)
                        && !ultimoValorCadena.equalsIgnoreCase(MULT_SIMBOLO)) {
                    pantallaEntrada.setText(TAN_SIMBOLO);
                    simboloOperacionTemporal = TAN_SIMBOLO;
                    operacionEspecial = new Tangente();
                    operacionTemporal = TAN;
                    desbloquearBotonesNumericos();
                }
                break;

            case R.id.btnSin:
                ultimoValorCadena = pantallaEntrada.getText().toString().substring(pantallaEntrada.getText().toString().trim().length() - 1);
                if (!ultimoValorCadena.equalsIgnoreCase(SUMA_SIMBOLO)
                        && !ultimoValorCadena.equalsIgnoreCase(RESTA_SIMBOLO)
                        && !ultimoValorCadena.equalsIgnoreCase(DIV_SIMBOLO)
                        && !ultimoValorCadena.equalsIgnoreCase(MULT_SIMBOLO)) {
                    pantallaEntrada.setText(SEN_SIMBOLO);
                    simboloOperacionTemporal = SEN_SIMBOLO;
                    operacionEspecial = new Tangente();
                    operacionTemporal = SEN;
                    desbloquearBotonesNumericos();
                }
                break;

            case R.id.btnCos:
                ultimoValorCadena = pantallaEntrada.getText().toString().substring(pantallaEntrada.getText().toString().trim().length() - 1);
                if (!ultimoValorCadena.equalsIgnoreCase(SUMA_SIMBOLO)
                        && !ultimoValorCadena.equalsIgnoreCase(RESTA_SIMBOLO)
                        && !ultimoValorCadena.equalsIgnoreCase(DIV_SIMBOLO)
                        && !ultimoValorCadena.equalsIgnoreCase(MULT_SIMBOLO)) {
                    pantallaEntrada.setText(COS_SIMBOLO);
                    simboloOperacionTemporal = COS_SIMBOLO;
                    operacionEspecial = new Tangente();
                    operacionTemporal = COS;
                    desbloquearBotonesNumericos();
                }
                break;

            case R.id.btnLog:
                ultimoValorCadena = pantallaEntrada.getText().toString().substring(pantallaEntrada.getText().toString().trim().length() - 1);
                if (!ultimoValorCadena.equalsIgnoreCase(SUMA_SIMBOLO)
                        && !ultimoValorCadena.equalsIgnoreCase(RESTA_SIMBOLO)
                        && !ultimoValorCadena.equalsIgnoreCase(DIV_SIMBOLO)
                        && !ultimoValorCadena.equalsIgnoreCase(MULT_SIMBOLO)) {
                    pantallaEntrada.setText(LOG_SIMBOLO);
                    simboloOperacionTemporal = LOG_SIMBOLO;
                    operacionEspecial = new Tangente();
                    operacionTemporal = LOG;
                    desbloquearBotonesNumericos();
                }
                break;

            case R.id.btnIgual:
                if (operacionTemporal.equalsIgnoreCase(TAN)
                        || operacionTemporal.equalsIgnoreCase(SEN)
                        || operacionTemporal.equalsIgnoreCase(COS)
                        || operacionTemporal.equalsIgnoreCase(LOG)) {
                    valor1 = Double.parseDouble(pantallaTemporal);
                    pantalla.setText(String.valueOf(validarConversion(Math.round(definirOperacionEspecial(operacionTemporal, operacionEspecial) * 100) / 100d)));
                    pantallaEntrada.setText(simboloOperacionTemporal + "(" + validarConversion(valor1) + ")");
                    bloquearBotonesNumericos();
                    desbloquearBontesOperacionesBasicas();
                } else {
                    try {
                        valor2 = Double.parseDouble(pantallaTemporal);
                        if (operacionTemporal.equals(DIVISION) && valor2 == 0.0) {
                            pantallaEntrada.setText("División por cero");
                            bloquearBotonesNumericos();
                            bloquearBontesOperacionesBasicas();
                            bloquearBotonesOperacionesEspeciales();
                        } else {
                            pantalla.setText(String.valueOf(validarConversion(Math.round(definirOperacionBasica(operacionTemporal, operacion) * 100) / 100d)));
                            pantallaEntrada.setText(validarConversion(valor1) + simboloOperacionTemporal + validarConversion(valor2));
                            bloquearBotonesNumericos();
                            desbloquearBontesOperacionesBasicas();
                        }
                    } catch (Exception e) {
                        System.out.println("No hay valores para realizar la operación");
                    }
                }

                break;
        }
    }
}