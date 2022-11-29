package mapeoAnotaciones;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "proveedores")
public class Proveedor implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "razon_social")
    String razonSocial;
    @Column(name = "credito")
    Float credito;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL) //indicamos el atributo de telefono que representa a un proveedor
    private List<Telefono> telefonos;

    public Proveedor() {
    }

    public Proveedor(Integer id, String razonSocial, Float credito) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.credito = credito;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Float getCredito() {
        return credito;
    }

    public void setCredito(Float credito) {
        this.credito = credito;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", razonSocial='" + razonSocial + '\'' +
                ", credito=" + credito +
                '}';
    }
}
