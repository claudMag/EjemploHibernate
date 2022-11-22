import mapeo.Cliente;
import org.hibernate.Session;
public class LogicaNegocio {

    private HibernateUtil utilitario;
    private Session session;

    public LogicaNegocio(){
        utilitario = new HibernateUtil();
        session = utilitario.getSessionFactory().openSession();
    }
    public void ejecutarAccionesPrototipo(){
        //ejemplo de inserción de un registro
        session.beginTransaction();
        Cliente cliente = new Cliente(1, "Papelaria Pepito", "Valencia", 500.5f);
        session.save(cliente);
        session.getTransaction().commit();
    }
}
