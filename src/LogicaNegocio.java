import mapeo.Cliente;
import org.hibernate.Session;

import org.hibernate.mapping.List;
public class LogicaNegocio {

    private HibernateUtil utilitario;
    private Session session;

    public LogicaNegocio(){
        utilitario = new HibernateUtil();
        session = utilitario.getSessionFactory().openSession();
    }
    public void ejecutarAccionesPrototipo() {
        //EJEMPLO de INSERCIÓN de un registro
        /* session.beginTransaction();
        Cliente cliente = new Cliente(1, "Papelaria Pepito", "Valencia", 500.5f);
        session.save(cliente);
        session.getTransaction().commit();*/

        //EJEMPLO de CONSULTA de todos los clientes
       /* session.beginTransaction();
        //from ---> nombre de la clase, da igual el nombre de la tabla
        List<Cliente> clienteList = session.createQuery("from Cliente").list();
        for (Cliente c: clienteList) {
            System.out.println(c.toString());
        }
        session.getTransaction().commit();*/

        //EJEMPLO DE CONSULTA de 1 cliente
       /* session.beginTransaction();
        int identificadorAConsultar = 2;
        Cliente cliente = (Cliente) session.get(Cliente.class, identificadorAConsultar);

        if (cliente!= null){
            System.out.println(cliente);
        }
        else{
            System.out.println("No existe ningún cliente con el id indicado");
        }

        session.getTransaction().commit();;*/


        //EJEMPLO DE ACTUALIZACION;

       /* session.beginTransaction();
        Cliente cliente = session.get(Cliente.class, 2);
        session.getTransaction().commit();

        if (cliente!= null){
            session.beginTransaction();
            cliente.setRazon("Consum actualizado");
            cliente.setProvincia("Valencia actualizada");
            cliente.setLimite(32f);
            session.update(cliente);
            System.out.println("Se ha actualizado el registro");
            session.getTransaction().commit();
        }*/

        //en borrar la consulta primero es obligatorio
        //interactuamos con el usuario y nos proporciona el id 2 para ser borrado.
        //las acciones hay que hacerlas en dos begin distontos
        session.beginTransaction();
        Cliente cliente = (Cliente) session.get(Cliente.class, 2);
        session.getTransaction().commit();

        if (cliente != null) {
           session.beginTransaction();
            session.delete(cliente);
            session.getTransaction().commit();
        } else {
            System.out.println("No existe en la base de datos el registro indicado por lo que no se ha podido borrar");
        }
    }
}
