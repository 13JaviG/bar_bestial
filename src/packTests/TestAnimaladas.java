package packTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import packControlador.Juego;
import packModelo.Carta;
import packModelo.CartaFactory;
import packModelo.ColaDelBar;
import packModelo.EnumColor;

class TestAnimaladas {
	EnumColor jugarColor = Juego.jugadorColor;
	EnumColor cpuColor = Juego.cpuColor;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		ColaDelBar.getColaDelBar().vaciar();
	}

	@Test
	void testLeon() throws Exception {
		System.out.println("leon");
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(4,jugarColor,CartaFactory.getCartaFactory().crearCarta(4)));
		Carta leon=new Carta(12,jugarColor,CartaFactory.getCartaFactory().crearCarta(12));
		ColaDelBar.getColaDelBar().addCarta(leon);
		leon.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(leon,ColaDelBar.getColaDelBar().getCarta(0));
	}
	@Test
	void testFoca() throws Exception {
		System.out.println("foca");
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(4,jugarColor,CartaFactory.getCartaFactory().crearCarta(4)));
		Carta foca=new Carta(6,jugarColor,CartaFactory.getCartaFactory().crearCarta(6));
		ColaDelBar.getColaDelBar().addCarta(foca);
		foca.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(foca,ColaDelBar.getColaDelBar().getCarta(0));
	}
	@Test
	void testSerpiente() throws Exception {
		System.out.println("Serpiente");
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(4,jugarColor,CartaFactory.getCartaFactory().crearCarta(4)));
		Carta serpiente=new Carta(9,jugarColor,CartaFactory.getCartaFactory().crearCarta(9));
		ColaDelBar.getColaDelBar().addCarta(serpiente);
		serpiente.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(serpiente,ColaDelBar.getColaDelBar().getCarta(0));
	}
	@Test
	void testCamaleon() throws Exception {
		System.out.println("Camaleon");
		Carta pruebaCSerp=new Carta(9,jugarColor,CartaFactory.getCartaFactory().crearCarta(9));
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(pruebaCSerp);
		Carta camaleon=new Carta(5,jugarColor,CartaFactory.getCartaFactory().crearCarta(5));
		ColaDelBar.getColaDelBar().addCarta(camaleon);
		camaleon.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(pruebaCSerp,ColaDelBar.getColaDelBar().getCarta(0));
	}

	@Test
	void testCanguro() throws Exception {
		System.out.println("\nCanguro");
		Carta canguro = new Carta(3,jugarColor,CartaFactory.getCartaFactory().crearCarta(3));
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(canguro);
		System.out.println("Estado del bar antes del salto");
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		canguro.hacerAnimalada();
		System.out.println("Estado del bar despuÃ©s del salto");
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
	}

	@Test
	void testJirafaPuedePasar() throws Exception {
		System.out.println("\nJirafa: pudiendo pasar");
		Carta jirafa = new Carta(8,jugarColor,CartaFactory.getCartaFactory().crearCarta(8));
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(jirafa);
		jirafa.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(jirafa,ColaDelBar.getColaDelBar().getCarta(1));
	}

	@Test
	void testJirafaNoPuedePasar() throws Exception {
		System.out.println("\nJirafa: sin poder pasar");
		Carta jirafa = new Carta(3,jugarColor,CartaFactory.getCartaFactory().crearCarta(3));
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(8,jugarColor, CartaFactory.getCartaFactory().crearCarta(8)));
		ColaDelBar.getColaDelBar().addCarta(jirafa);
		jirafa.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(jirafa,ColaDelBar.getColaDelBar().getCarta(3));
	}

	@Test
	void testMono() throws Exception {
		System.out.println("\nMono");
		Carta mono = new Carta(4,jugarColor,CartaFactory.getCartaFactory().crearCarta(4));
		Carta mofeta = new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1));
		ColaDelBar.getColaDelBar().addCarta(mofeta);
		Carta monoCPU = new Carta(4,cpuColor, CartaFactory.getCartaFactory().crearCarta(4));
		ColaDelBar.getColaDelBar().addCarta(monoCPU);
		ColaDelBar.getColaDelBar().addCarta(new Carta(10,jugarColor, CartaFactory.getCartaFactory().crearCarta(10)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(11,jugarColor, CartaFactory.getCartaFactory().crearCarta(11)));
		ColaDelBar.getColaDelBar().addCarta(mono);
		System.out.println("Estado del bar antes del salto");
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		mono.hacerAnimalada();
		System.out.println("Estado del bar despuÃ©s del salto");
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(mono,ColaDelBar.getColaDelBar().getCarta(0));
		assertEquals(monoCPU,ColaDelBar.getColaDelBar().getCarta(1));
		assertEquals(mofeta,ColaDelBar.getColaDelBar().getCarta(2));
	}
	
	@Test
	void testHipopotamoPuedePasar() throws Exception {
		System.out.println("\nHipopótamo: pudiendo pasar");
		Carta hipopotamo = new Carta(11,jugarColor,CartaFactory.getCartaFactory().crearCarta(11));
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(hipopotamo);
		hipopotamo.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(hipopotamo,ColaDelBar.getColaDelBar().getCarta(0));
	}

	@Test
	void testHipopotamoNoPuedePasar() throws Exception {
		System.out.println("\nHipopótamo: sin poder pasar");
		Carta hipopotamo = new Carta(11,jugarColor,CartaFactory.getCartaFactory().crearCarta(11));
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(7,jugarColor, CartaFactory.getCartaFactory().crearCarta(7)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(hipopotamo);
		hipopotamo.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(hipopotamo,ColaDelBar.getColaDelBar().getCarta(2));
	}
	
	@Test
	void testCocodriloPuedePasar() throws Exception {
		System.out.println("\nCocodrilo: pudiendo pasar");
		Carta cocodrilo = new Carta(10,jugarColor,CartaFactory.getCartaFactory().crearCarta(10));
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(5,jugarColor, CartaFactory.getCartaFactory().crearCarta(5)));
		ColaDelBar.getColaDelBar().addCarta(cocodrilo);
		cocodrilo.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(cocodrilo,ColaDelBar.getColaDelBar().getCarta(0));
		assertEquals(1,ColaDelBar.getColaDelBar().cuantasHay());
	}

	@Test
	void testCocodriloNoPuedePasar() throws Exception {
		System.out.println("\nCocodrilo: sin poder pasar");
		Carta cocodrilo = new Carta(10,jugarColor,CartaFactory.getCartaFactory().crearCarta(10));
		ColaDelBar.getColaDelBar().addCarta(new Carta(11,jugarColor, CartaFactory.getCartaFactory().crearCarta(11)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(9,jugarColor, CartaFactory.getCartaFactory().crearCarta(9)));
		ColaDelBar.getColaDelBar().addCarta(cocodrilo);
		cocodrilo.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(cocodrilo,ColaDelBar.getColaDelBar().getCarta(1));
		assertEquals(2,ColaDelBar.getColaDelBar().cuantasHay());
	}
	
	@Test
	void testMofetaDosAltas() throws Exception {
		System.out.println("\nMofeta: ");
		Carta mofeta = new Carta(1,jugarColor,CartaFactory.getCartaFactory().crearCarta(1));
		ColaDelBar.getColaDelBar().addCarta(new Carta(11,jugarColor, CartaFactory.getCartaFactory().crearCarta(11)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(9,jugarColor, CartaFactory.getCartaFactory().crearCarta(9)));
		ColaDelBar.getColaDelBar().addCarta(mofeta);
		mofeta.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(mofeta,ColaDelBar.getColaDelBar().getCarta(1));
		assertEquals(2,ColaDelBar.getColaDelBar().cuantasHay());
	}
	
	@Test
	void testMofetaUnaAlta() throws Exception {
		System.out.println("\nMofeta: ");
		Carta mofeta = new Carta(1,jugarColor,CartaFactory.getCartaFactory().crearCarta(1));
		ColaDelBar.getColaDelBar().addCarta(new Carta(11,jugarColor, CartaFactory.getCartaFactory().crearCarta(11)));
		ColaDelBar.getColaDelBar().addCarta(mofeta);
		mofeta.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(null,ColaDelBar.getColaDelBar().getCarta(0));
		assertEquals(0,ColaDelBar.getColaDelBar().cuantasHay());
	}
	
	@Test
	void testMofetaSinAltas() throws Exception {
		System.out.println("\nMofeta: ");
		Carta mofeta = new Carta(1,jugarColor,CartaFactory.getCartaFactory().crearCarta(1));
		ColaDelBar.getColaDelBar().addCarta(mofeta);
		mofeta.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(null,ColaDelBar.getColaDelBar().getCarta(0));
		assertEquals(0,ColaDelBar.getColaDelBar().cuantasHay());
	}
	
	@Test
	void testLoro() throws Exception {
		System.out.println("\nLoro: ");
		Carta loro = new Carta(2,jugarColor,CartaFactory.getCartaFactory().crearCarta(2));
		ColaDelBar.getColaDelBar().addCarta(new Carta(11,jugarColor, CartaFactory.getCartaFactory().crearCarta(11)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(8,jugarColor, CartaFactory.getCartaFactory().crearCarta(8)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(9,jugarColor, CartaFactory.getCartaFactory().crearCarta(9)));
		int valorAnt = ColaDelBar.getColaDelBar().cuantasHay();
		ColaDelBar.getColaDelBar().addCarta(loro);
		loro.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(valorAnt,ColaDelBar.getColaDelBar().cuantasHay());
	}
}
