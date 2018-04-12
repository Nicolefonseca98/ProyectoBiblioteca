
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyectobiblioteca.Logica;

public class TestLogica {

    private static Logica testLogica;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        testLogica = new Logica();
    }

    @Before
    public void setUp() throws Exception {
    }

    /*
    * Valida si existe un usuario con el nombre que entra como parámetro.
    * El valor de prueba es un espacio en blanco.
     */
    @Test
    public void testExisteUsuario() {
        Boolean valorPrueba = false;
        Boolean retorno = testLogica.existeUsuario(" ");
        assertEquals(valorPrueba, retorno);
    }

    /*
    * Valida si existe una obra con el nombre que entra como parámetro.
    * El valor de prueba es un espacio en blanco.
     */
    @Test
    public void testExisteObra() {
        Boolean valorPrueba = false;
        Boolean retorno = testLogica.existeObra(" ");
        assertEquals(valorPrueba, retorno);
    }

    /*
    * Valida si un usuario está moroso.
    * El valor de prueba es un usuario que no se encuentra moroso.
     */
    @Test
    public void testBorrarMoroso() {
        Boolean valorPrueba = false;
        Boolean retorno = testLogica.borrarMoroso("María");
        assertEquals(valorPrueba, retorno);
    }

    /*
    * Verifica que los datos de la lista de usuarios coincidan 
    * con los datos que se ingresan en el login.
    * El valor de prueba es un usuario que aún no se encuentra registrado.
     */
    @Test
    public void testVerificaUsuario() {
        Boolean valorPrueba = false;
        Boolean retorno = testLogica.verificaUsuario("María", "123", "Usuario");
        assertEquals(valorPrueba, retorno);
    }

    /*
    * Busca la obra que entra como parámetro en la lista de obras.
    * El valor de prueba es un obra que no se encuentra en la lista.
     */
    @Test
    public void testBuscarObra() {
        Boolean valorPrueba = false;
        Boolean retorno = testLogica.buscarObra("JavaFX8");
        assertEquals(valorPrueba, retorno);
    }

}
