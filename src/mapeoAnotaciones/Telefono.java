package mapeoAnotaciones;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "telefonos_proveedor")
public class Telefono implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero")
    private String numero;
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    public Telefono() {
    }

    public Telefono(Integer id, String numero, Proveedor proveedor) {
        this.id = id;
        this.numero = numero;
        this.proveedor = proveedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", proveedor=" + proveedor +
                '}';
    }
}
