package foc.gustavo.dam.entidad;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;

public final class Proveedor implements Parcelable {

    public long id;
    public String nombre;

    public Proveedor(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Proveedor(Proveedor b) {
        this(b.id, b.nombre);
    }

    public Proveedor(Parcel in) {
        id = in.readLong();
        nombre= in.readString();
    }

    public boolean esIgual(Proveedor proveedor) {
        return nombre.compareTo(proveedor.nombre) == 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nombre);
    }

    public static final Parcelable.Creator<Proveedor> CREATOR = new Parcelable.Creator<Proveedor>() {
        public Proveedor createFromParcel(Parcel in) {
            return new Proveedor(in);
        }

        public Proveedor[] newArray(int size) {
            return new Proveedor[size];
        }
    };

    public static abstract class ProveedorEntidad implements BaseColumns {
        public static final String TABLE_NOMBRE = "proveedor";
        public static final String COLUMNA_ID = "_id";
        public static final String COLUMNA_NOMBRE = "proveedor_nombre";
    }
}

