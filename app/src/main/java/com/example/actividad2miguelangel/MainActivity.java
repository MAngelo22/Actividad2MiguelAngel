package com.example.actividad2miguelangel;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.content.DialogInterface;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.widget.ArrayAdapter;
import android.database.Cursor;
import android.widget.ListView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import com.example.actividad2miguelangel.TaskTable.TaskContract;
import com.example.actividad2miguelangel.TaskTable.TaskDbHelper;

public class MainActivity extends AppCompatActivity {
    private TaskDbHelper mHelper;
    private ListView mTaskListView;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelper = new TaskDbHelper(this);
        mTaskListView = (ListView) findViewById(R.id.list_todo);

        updateUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Funcion añadir tarea
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
            case R.id.action_add_task:
                final EditText taskEditText = new EditText(this);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Añade una tarea");
                builder.setMessage("¿Que quieres hacer?");
                builder.setView(taskEditText);
                builder.setPositiveButton("Añadir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String task = String.valueOf(taskEditText.getText());
                        SQLiteDatabase db = mHelper.getWritableDatabase();
                        ContentValues values = new ContentValues();
                        values.put(TaskContract.TaskEntry.TITULO_TAREA, task);
                        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE,
                                null,
                                values,
                                SQLiteDatabase.CONFLICT_REPLACE);

                        LayoutInflater inflater = getLayoutInflater();
                        View view2 = inflater.inflate(R.layout.toastcreartarea, null);
                        Toast toastcrear = new Toast (getApplicationContext());
                        toastcrear.setDuration(Toast.LENGTH_LONG);
                        toastcrear.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 0);
                        toastcrear.setView(view2);

                        MediaPlayer Sonido1 = MediaPlayer.create(getApplicationContext(), R.raw.sonidoshenron);

                        toastcrear.show();

                        Sonido1.start();

                        db.close();
                        updateUI();

                    }
                }).setNegativeButton("Cancelar", null);
                AlertDialog dialog = builder
                        .create();
                dialog.show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
//Funcion para actualizar la lista, y modificar mediante la view, a la tarea.
    public void updateTask(View view) {
        View parent = (View) view.getParent();
        TextView taskTextView = (TextView) parent.findViewById(R.id.task_title);
        final String task = String.valueOf(taskTextView.getText());
        final EditText nombreTareaEditado = new EditText(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Modifica la tarea");
        builder.setMessage("¿Que quieres hacer?");
        builder.setView(nombreTareaEditado);
        builder.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nuevoNombreTarea = String.valueOf(nombreTareaEditado.getText());
                SQLiteDatabase db = mHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(TaskContract.TaskEntry.TITULO_TAREA, nuevoNombreTarea);
                db.update(TaskContract.TaskEntry.TABLE,
                        values,
                        TaskContract.TaskEntry.TITULO_TAREA + " = ?",
                        new String[]{task});
                db.close();
                updateUI();

            }
        }).setNegativeButton("Cancelar", null);
        AlertDialog dialog = builder
                .create();
        dialog.show();
    }

    //Funcion de actualizar lista y acabar tarea
    public void deleteTask(View view) {
        View parent = (View) view.getParent();
        TextView taskTextView = (TextView) parent.findViewById(R.id.task_title);
        String task = String.valueOf(taskTextView.getText());
        SQLiteDatabase db = mHelper.getWritableDatabase();
        db.delete(TaskContract.TaskEntry.TABLE,
                TaskContract.TaskEntry.TITULO_TAREA + " = ?",
                new String[]{task});

        //Toast cuando acabas una tarea.
        LayoutInflater inflater = getLayoutInflater();
        View view2 = inflater.inflate(R.layout.toastacabar, null);
        Toast toastacabar = new Toast (this);
        toastacabar.setDuration(Toast.LENGTH_LONG);
        toastacabar.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 0);
        toastacabar.setView(view2);
        toastacabar.show();

        MediaPlayer Sonido2 = MediaPlayer.create(this, R.raw.fin);
        Sonido2.start();

        db.close();
        updateUI();
    }

    //Actualiza la base de datos
    private void updateUI() {
        ArrayList<String> taskList = new ArrayList<>();
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.query(TaskContract.TaskEntry.TABLE,
                new String[]{TaskContract.TaskEntry._ID, TaskContract.TaskEntry.TITULO_TAREA},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            int idx = cursor.getColumnIndex(TaskContract.TaskEntry.TITULO_TAREA);
            taskList.add(cursor.getString(idx));
        }

        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<>(this,
                    R.layout.item_todo,
                    R.id.task_title,
                    taskList);
            mTaskListView.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(taskList);
            mAdapter.notifyDataSetChanged();
        }

        cursor.close();
        db.close();
    }

}