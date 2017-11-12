package foc.gustavo.dam.entidad;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;

public final class Producto implements Parcelable {

    //#region ATTRIBUTES
    public long id;
    public String nombre;
    public String empaquetado;
    public String codigo;
    public String tamano;
    public String tamanoCaja;
    public String pesoUnidad;
    public String cajasPalet;
    //#endregion

    //#region CONSTRUCTORS
    public Producto (long id, String nombre, String empaquetado, String codigo, String tamano, String tamanoCaja, String pesoUnidad, String cajasPalet) {
        this.id = id;
        this.nombre = nombre;
        this.empaquetado = empaquetado;
        this.codigo = codigo;
        this.tamano = tamano;
        this.tamanoCaja = tamanoCaja;
        this.pesoUnidad = pesoUnidad;
        this.cajasPalet = cajasPalet;
    }

    public Producto (Producto p) {
        this(p.id, p.nombre, p.empaquetado, p.codigo, p.tamano, p.tamanoCaja, p.pesoUnidad, p.cajasPalet);
    }

    public Producto (Parcel in) {
        id = in.readLong();
        nombre = in.readString();
        empaquetado = in.readString();
        codigo = in.readString();
        tamano = in.readString();
        tamanoCaja = in.readString();
        pesoUnidad = in.readString();
        cajasPalet = in.readString();
    }

    public boolean esIgual(Producto  targetProduct) {
        return targetProduct != null
                && nombre.compareTo(targetProduct.nombre) == 0
                && empaquetado.compareTo(targetProduct.empaquetado) == 0
                && codigo.compareTo(targetProduct.codigo) == 0
                && tamano.compareTo(targetProduct.tamano) == 0
                && tamanoCaja.compareTo(targetProduct.tamanoCaja) == 0
                && pesoUnidad.compareTo(targetProduct.pesoUnidad) == 0
                && cajasPalet.compareTo(targetProduct.cajasPalet) == 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nombre);
        dest.writeString(empaquetado);
        dest.writeString(codigo);
        dest.writeString(tamano);
        dest.writeString(tamanoCaja);
        dest.writeString(pesoUnidad);
        dest.writeString(cajasPalet);
    }

    public static final Parcelable.Creator<Producto > CREATOR = new Parcelable.Creator<Producto >() {
        public Producto  createFromParcel(Parcel in) {
            return new Producto (in);
        }

        public Producto [] newArray(int size) {
            return new Producto [size];
        }
    };

    public static abstract class ProductoEntidad implements BaseColumns {
        public static final String TABLEA_NOMBRE = "producto";
        public static final String COLUMNA_ID = "_id";
        public static final String COLUMNA_NOMBRE = "producto_nombre";
        public static final String COLUMNA_EMPAQUETADO = "producto_empquetado";
        public static final String COLUMNA_CODIGO = "producto_codigo";
        public static final String COLUMNA_TAMANO = "producto_tamano";
        public static final String COLUMNA_TAMANO_CAJA = "producto_tamano_cajat";
        public static final String COLUMNA_PESO_UNIDAD = "producto_peso_unidad";
        public static final String COLUMNA_CAJAS_PALET = "producto_cajas_palet";

        public static String[] getFullProjection() {
            return new String[] {
                    COLUMNA_ID,
                    COLUMNA_NOMBRE,
                    COLUMNA_EMPAQUETADO,
                    COLUMNA_CODIGO,
                    COLUMNA_TAMANO,
                    COLUMNA_TAMANO_CAJA,
                    COLUMNA_PESO_UNIDAD,
                    COLUMNA_CAJAS_PALET
            };
        }
    }
}

