package foc.gustavo.dam.entidad;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;

public final class Cliente implements Parcelable {

    public long id;
    public String nombre;
    public String codigo;

    public Cliente(long id, String nombre, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public Cliente(Cliente b) {
        this(b.id, b.nombre, b.codigo);
    }

    public Cliente(Parcel in) {
        id = in.readLong();
        nombre= in.readString();
        codigo = in.readString();
    }

    public boolean esIgual(Cliente targetCustomer) {
        return nombre.compareTo(targetCustomer.nombre) == 0 &&
                codigo.compareTo(targetCustomer.codigo) == 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nombre);
        dest.writeString(codigo);
    }

    public static final Parcelable.Creator<Cliente> CREATOR = new Parcelable.Creator<Cliente>() {
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

    public static abstract class ClienteEntidad implements BaseColumns {
        public static final String TABLA_NOMBRE = "cliente";
        public static final String COLUMNA_ID = "_id";
        public static final String COLUMNA_NOMBRE = "cliente_nombre";
        public static final String COLUMNA_CODIGO = "cliente_codigo";

        public static String[] getFullprojection() {
            return new String[] { COLUMNA_ID, COLUMNA_NOMBRE, COLUMNA_CODIGO };
        }
    }
    //#endregion
}
