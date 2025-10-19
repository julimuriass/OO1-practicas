package ejercicio19.src.main.java.com.ejemplo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Oobn {
    private List<Usuario> usuarios;
    private List<Inmueble> inmuebles;
    

    public Oobn() {
        this.inmuebles = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }
    


    //dada una propiedad, una fecha inicial y una fecha final, se debe determinar si la propiedad está disponible el período indicado.
    public boolean consultarDisponibilidad(LocalDate from, LocalDate to, String nombrePropiedad) {
        //Encuentro la propiedad.
        Inmueble propiedad = this.inmuebles.stream().filter(inm -> inm.getNombre().equals(nombrePropiedad)).findAny().orElse(null); //?????okay el get  del nombre?? o rompe la heurística envidia??

        if (propiedad == null) return false;

        //Delego la responsabilidad a la propiedad.
        return propiedad.consultarDisponibilidad(to, from);
    }

    public boolean crearReserva(Usuario usuario, Inmueble propiedad, LocalDate from, LocalDate to) {
        //Verifico que existan el usuario y la propiedad.
        Inmueble prop = this.inmuebles.stream().filter(inm -> inm.getNombre().equals(propiedad.getNombre())).findAny().orElse(null); //?????okay el get  del nombre?? o rompe la heurística envidia??
        Usuario user = this.usuarios.stream().filter(usr -> usr.getDni() == usuario.getDni()).findAny().orElse(null);

        if ((prop == null) || (user == null)) return false;

        //Consulto disponibilidad.
        if (!this.consultarDisponibilidad(from, to, prop.getNombre())) return false;

        //Crear reserva.
        Reserva reserva = new Reserva(user, prop, from, to);


        //Tendría que llamar desde user o usuario??? (same 4 prop)
        user.agregarReserva(reserva);
        prop.agregarReserva(reserva);

        return true;
    }

    public double calcularPrecio(Reserva reserva) {
        //Buscar reserva en inmueble. (me quedo con el inmueble que tenga la reserva)
        Inmueble prop = this.inmuebles.stream().
                                        filter(inm -> inm.getNombre().equals(reserva.getInmueble().getNombre())).
                                        findAny().orElse(null); //Okay??? 

        if (prop == null) return 0.0;

        return prop.calcularPrecio(reserva);
    }

    public boolean cancelarReserva(Reserva reserva) {
        //Buscar reserva en inmueble. (me quedo con el inmueble que tenga la reserva)
        if (reserva.includesDate(LocalDate.now())) return false;

        Inmueble prop = this.inmuebles.stream().
                                        filter(inm -> inm.getNombre().equals(reserva.getInmueble().getNombre())).
                                        findAny().orElse(null); //Okay??? 

        Usuario user = this.usuarios.stream().
                                        filter(usr -> usr.getDni() == reserva.getUsuario().getDni()).
                                        findAny().orElse(null); //Okay????

        if ((prop == null) || (user == null)) return false;

        user.eliminarReserva(reserva);
        prop.eliminarReserva(reserva);

        return true;
    }

    public double calcularIngresoPropietario(Usuario usuario, LocalDate from, LocalDate to) {
        //Verifico que exista el usuario.
        Usuario user = this.usuarios.stream().filter(usr -> usr.getDni() == usuario.getDni()).findAny().orElse(null);

        if (user == null) return 0.0;

        return user.calcularIngresoPropietario(from, to);
    }
}
