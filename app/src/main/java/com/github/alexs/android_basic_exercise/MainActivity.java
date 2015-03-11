package com.github.alexs.android_basic_exercise;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    double EURO2USD = 1.399;
    double PESO2USD = 0.07434;

    Button btnConvertir;
    Button btnLimpiar;
    EditText txtDolares;
    EditText txtEuros;
    EditText txtPesos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDolares = (EditText)findViewById(R.id.txtUSDollars);
        txtDolares.setHint("Cantidad en dolares");
        txtEuros = (EditText)findViewById(R.id.editText1);
        txtEuros.setHint("Cantidad en Euros");
        txtPesos = (EditText)findViewById(R.id.editText2);
        txtPesos.setHint("Cantidad en Pesos MX");

        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnLimpiar.setOnClickListener(new OnClickListener(){
            // @Override
            public void onClick(View v){
                txtDolares.setText("");
                txtEuros.setText("");
                txtPesos.setText("");
            }
        });

        btnConvertir = (Button) findViewById(R.id.btnConvertir);
        btnConvertir.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                String usdStr = txtDolares.getText().toString();
                if (usdStr.matches("")) {
                    Toast.makeText(v.getContext(),
                            "Debes ingresar dólares, esta app solo convierte de dolares a las demás divisas",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                else{
                    try{

                        double usd = Double.parseDouble(usdStr);

                        String euros = String.format("%.2f",(usd/EURO2USD));
                        String pesos = String.format("%.2f",(usd/PESO2USD));

                        txtEuros.setText(euros);
                        txtPesos.setText(pesos);
                    }
                    catch(Exception e){
                        Toast.makeText(v.getContext(), e.toString(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
