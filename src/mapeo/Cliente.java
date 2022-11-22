package mapeo;

import java.io.Serializable;

public class Cliente implements Serializable {

    private Integer identificador;
    private String razon;
    private String provincia;
    private Float limite;

    public Cliente() {
        identificador = 0;
        razon = "";
        provincia = "";
        limite = 0.0f;
    }

    public Cliente(Integer identificador, String razon, String provincia, Float limite) {
        this.identificador = identificador;
        this.razon = razon;
        this.provincia = provincia;
        this.limite = limite;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Float getLimite() {
        return limite;
    }

    public void setLimite(Float limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "identificador=" + identificador +
                ", razon='" + razon + '\'' +
                ", provincia='" + provincia + '\'' +
                ", limite=" + limite +
                '}';
    }
}
