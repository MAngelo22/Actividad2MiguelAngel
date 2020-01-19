package com.example.actividad2miguelangel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.actividad2miguelangel.TaskTable.TaskContract;
import com.example.actividad2miguelangel.UsersTable.UserDbHelper;
import com.example.actividad2miguelangel.UsersTable.UsersContract;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Login extends AppCompatActivity implements Animation.AnimationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final TextView textName = (TextView) findViewById(R.id.textName);
        final TextView textPassword = (TextView) findViewById(R.id.textPas);

        //Aqui hago un onclick escuchando a la funcion de vaciar
        textName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista) {
                vaciar(textName);
            }
        });
        textPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista) {
                vaciar(textPassword);
            }
        });

        getSupportActionBar().hide();

        TextView titulo2 = (TextView) findViewById(R.id.text2);
    }

    public void crearUsuario(View view) {
        Intent cambioUs = new Intent(this, LoginNew.class);
        startActivity(cambioUs);
    }

    public void vaciar(TextView tv) {
        tv.setText("");
    }

    public void login(View view) {
        //Vacia las cajas de texto
        TextInputEditText usuario = (TextInputEditText) findViewById(R.id.textName);
        TextInputEditText password = (TextInputEditText) findViewById(R.id.textPas);

        UserDbHelper mHelper = new UserDbHelper(this);

        SQLiteDatabase db2 = mHelper.getReadableDatabase();
        String[] args = new String[]{usuario.getText().toString()};
        Cursor cursor = db2.query(UsersContract.TaskEntry.TABLE,
                new String[]{UsersContract.TaskEntry.NOMBRE_USUARIO, UsersContract.TaskEntry.PASSWORD_USUARIO},
                "name=?", args, null, null, null);

        // El metodo moveToNext() entra en funcionamiento cada vez que tu consulta o query, devuelve un resultado
        // Cuando un usuario no esta en la base de datos, no va a hacer nada, ya que la logica de dentro solo actuara
        // Cuando se devuelva algo de tu select

        if (cursor.getCount() == 0) {
            Toast toastUsu = Toast.makeText(this, "Comprueba nombre y contraseña", Toast.LENGTH_LONG);
            toastUsu.show();
            usuario.getText().toString().replace("", "");
            password.getText().toString().replace("", "");
        }
        while (cursor.moveToNext()) {

            String passwordParaHacerMatch = cursor.getString((Integer) cursor.getColumnIndex(UsersContract.TaskEntry.PASSWORD_USUARIO));

            if (password.getText().toString().equals(passwordParaHacerMatch)) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast toastUsu = Toast.makeText(this, "Comprueba nombre y contraseña", Toast.LENGTH_LONG);
                toastUsu.show();
                usuario.getText().toString().replace("", "");
                password.getText().toString().replace("", "");
            }
        }
        cursor.close();
        db2.close();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
