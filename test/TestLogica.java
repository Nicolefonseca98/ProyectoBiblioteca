
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
    
    @Test
    public void testExisteUsuario() {
        Boolean valorPrueba= false;
	Boolean retorno = testLogica.existeUsuario(" ");
	assertEquals(valorPrueba, retorno);
    }
   
    @Test
    public void testExisteObra() {
        Boolean valorPrueba= false;
	Boolean retorno = testLogica.existeObra(" ");
	assertEquals(valorPrueba, retorno);
    }
    
    @Test
    public void testBorrarMoroso() {
        Boolean valorPrueba= false;
	Boolean retorno = testLogica.borrarMoroso("María");
	assertEquals(valorPrueba, retorno);
    }
    
   @Test
    public void testVerificaUsuario() {
        Boolean valorPrueba= false;
	Boolean retorno = testLogica.verificaUsuario("María", "123", "Usuario");
	assertEquals(valorPrueba, retorno);
    }
    
    @Test
    public void testBuscarObra() {
        Boolean valorPrueba= false;
	Boolean retorno = testLogica.buscarObra("JavaFX8");
	assertEquals(valorPrueba, retorno);
    }
    
}
