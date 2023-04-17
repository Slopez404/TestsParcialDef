package com.example.testsparcial.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.testsparcial.entidades.Productos;

import java.util.ArrayList;

public class DbProductos extends BaseHelper {

    Context context;
    public DbProductos(@Nullable Context context) {

        super(context);
        this.context = context;

    }

    public long insertarProducto(String nombre, String cantidad){ //Recibe parametros para la tabla
        long id = 0;
        try {
            BaseHelper baseHelper = new BaseHelper(context);
            SQLiteDatabase db = baseHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("cantidad", cantidad);

            id = db.insert(TABLE_PRODUCTO, null, values);//insertar registro a la tabla

        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }
    //----------------------------------------
    public ArrayList<Productos> mostrarFutbolistas(){//se traerán los datos de la tabla

        BaseHelper baseHelper = new BaseHelper(context);
        SQLiteDatabase db = baseHelper.getWritableDatabase();

        ArrayList<Productos> listaFutbolistas = new ArrayList<>();
        Productos futbolistas = null;
        Cursor cursorProductos = null;

        cursorProductos = db.rawQuery("SELECT * FROM " + TABLE_PRODUCTO, null);//consulta a la tabla

        if(cursorProductos.moveToFirst()){ //validación
            do{
                Productos productos;
                productos = new Productos();
                productos.setId(cursorProductos.getInt(0));
                futbolistas.setNombre(cursorProductos.getString(1));
                futbolistas.setCantidad(cursorProductos.getString(2));

            } while (cursorProductos.moveToNext());//envia al siguiente registro
        }

        cursorProductos.close();
        return listaFutbolistas;
    }

}
