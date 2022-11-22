import mapeo.Cliente;
import org.hibernate.Session;

import java.util.List;

public class LogicaNegocio {

    private HibernateUtil utilitario;
    private Session session;

    public LogicaNegocio(){
        utilitario = new HibernateUtil();
        session = utilitario.getSessionFactory().openSession();
    }
    public void ejecutarAccionesPrototipo(){
        //ejemplo de inserción de un registro
       /* session.beginTransaction();
        Cliente cliente = new Cliente(1, "Papelaria Pepito", "Valencia", 500.5f);
        session.save(cliente);
        session.getTransaction().commit();*/

        //ejemplo de consulta
        session.beginTransaction();
        //from ---> nombre de la clase, da igual el nombre de la tabla
        List<Cliente> clienteList = session.createQuery("from Cliente").list();
        for (Cliente c: clienteList) {
            System.out.println(c.toString());
        }
        session.getTransaction().commit();

    }
}
