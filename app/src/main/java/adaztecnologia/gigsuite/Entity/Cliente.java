package adaztecnologia.gigsuite.Entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Cliente implements Parcelable{
    public int id;
    public String nome;
    public String telefone;
    public String atividade;

    public Cliente(int id, String nome, String telefone, String atividade){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.atividade = atividade;
    }

    private Cliente(Parcel from){
        id = from.readInt();
        nome = from.readString();
        telefone = from.readString();
        atividade = from.readString();
    }

    public static final Parcelable.Creator<Cliente> CREATOR = new Parcelable.Creator<Cliente>(){
        public Cliente createFromParcel(Parcel in){
        return new Cliente(in);
    }


    public Cliente[] newArray(int size){
        return new Cliente[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nome);
        dest.writeString(telefone);
        dest.writeString(atividade);
    }
}
