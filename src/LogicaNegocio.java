import mapeo.Cliente;
import org.hibernate.Session;


import java.util.List;
import java.util.Scanner;

public class LogicaNegocio {

    private HibernateUtil utilitario;
    private Session session;
    private Scanner sc;

    public LogicaNegocio(){
        utilitario = new HibernateUtil();
        session = utilitario.getSessionFactory().openSession();
    }

    public void iniciarAplicacion(){
        int opcion;
        sc = new Scanner(System.in);

        do{
            System.out.println("Menu");
            System.out.println("1. Insertar cliente");
            System.out.println("2. Consultar por su id ");
            System.out.println("3. Eliminar");
            System.out.println("4. Actualizar datos cliente");
            System.out.println("5. Consultar todos los clientes");

            opcion = sc.nextInt();

            switch (opcion){
                case 1-> insertarCliente();//con operador flecha no hace falta break
                case 2-> consultarClienteId();
                case 3-> eliminarCliente();
                case 4->actualizarCliente();
                case 5->consultarClientes();
            }
        }while (opcion!=0);
    }

    private void consultarClientes() {
       session.beginTransaction();
        //from ---> nombre de la clase, no se refiere al nombre de la tabla
        List<Cliente> clienteList =session.createQuery("from Cliente").list();
        for (Cliente c: clienteList) {
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    private void actualizarCliente() {
        String razonSocialActualizada, provinciactualizada;
        float limiteActualizado;
        int id;

        System.out.println("id del cliente a actualizar?");
        id = sc.nextInt();
        sc.nextLine();

        session.beginTransaction();
        Cliente cliente = session.get(Cliente.class, id);

        if (cliente!= null){
            System.out.println("razonsocial actualizada?");
            razonSocialActualizada = sc.nextLine();
            System.out.println("provincia actualizada?");
            provinciactualizada = sc.nextLine();
            System.out.println("limite actualizado?");
            limiteActualizado = sc.nextFloat();

            cliente.setRazon(razonSocialActualizada);
            cliente.setProvincia(provinciactualizada);
            cliente.setLimite(limiteActualizado);

            session.update(cliente);
            System.out.println("Se ha actualizado el cliente con el id "+id);
        }
        session.getTransaction().commit();
    }

    private void eliminarCliente() {
        int id;
        System.out.println("id del cliente a eliminar?");
        id = sc.nextInt();

        session.beginTransaction();
        Cliente cliente = session.get(Cliente.class, id);
        if (cliente != null) {
            session.delete(cliente);
            System.out.println("El cliente con el identificador "+id+" se ha borrado correctamente");
        } else {
            System.out.println("No existe en la base de datos el cliente con el id "+id);
        }
        session.getTransaction().commit();
    }

    private void consultarClienteId() {
        int id;
        System.out.println("id?");
        id = sc.nextInt();

        session.beginTransaction();
        Cliente cliente = session.get(Cliente.class, id);

        if (cliente!= null){
            System.out.println(cliente);
        }
        else{
            System.out.println("No existe ningún cliente con el id indicado");
        }

        session.getTransaction().commit();
    }

    private void insertarCliente() {
        String razonSocial, provincia;
        float limite;
        int id;

        System.out.println("id?");
        id = sc.nextInt();
        sc.nextLine();
        System.out.println("razonsocial?");
        razonSocial = sc.nextLine();
        System.out.println("provincia?");
        provincia = sc.nextLine();
        System.out.println("limite?");
        limite = sc.nextFloat();

        session.beginTransaction();
        Cliente cliente = new Cliente(id, razonSocial, provincia, limite);
        session.save(cliente);
        session.getTransaction().commit();

   }

}
