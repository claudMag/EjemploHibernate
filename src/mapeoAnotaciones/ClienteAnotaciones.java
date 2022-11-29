package mapeoAnotaciones;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity //de entidad
@Table(name = "clientes") //de tabla

public class ClienteAnotaciones implements Serializable {

    @Id
    @Column(name = "id")
    private Integer identificador;

    @Column(name = "razonsocial")
    private String razon;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "limite_credito")
    private Float limite;

    public ClienteAnotaciones() {
        identificador = 0;
        razon = "";
        provincia = "";
        limite = 0.0f;
    }

    public ClienteAnotaciones(Integer identificador, String razon, String provincia, Float limite) {
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
