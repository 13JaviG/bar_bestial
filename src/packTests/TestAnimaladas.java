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
		ColaDelBar.getColaDelBar().vaciar();
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("\n\n");
	}

	@Test
	void testLeon() throws Exception {
		System.out.println("leon");
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(4,jugarColor,CartaFactory.getCartaFactory().crearCarta(4)));
		Carta leon=new Carta(12,jugarColor,CartaFactory.getCartaFactory().crearCarta(12));
		ColaDelBar.getColaDelBar().addCarta(leon);
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		leon.hacerAnimalada();
		System.out.println("hace animalada");
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
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		foca.hacerAnimalada();
		System.out.println("hace animalada");
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
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		serpiente.hacerAnimalada();
		System.out.println("hace animalada");
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
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		System.out.println("hace animalada");
		ColaDelBar.getColaDelBar().addCarta(camaleon);
		camaleon.hacerAnimalada();
		System.out.println("what=?");
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
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
		System.out.println("Estado del bar después del salto");
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
	}

	@Test
	void testJirafaPuedePasar() throws Exception {
		System.out.println("\nJirafa: pudiendo pasar");
		Carta jirafa = new Carta(8,jugarColor,CartaFactory.getCartaFactory().crearCarta(8));
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(jirafa);
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		jirafa.hacerAnimalada();
		System.out.println("hace animalada");
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(jirafa,ColaDelBar.getColaDelBar().getCarta(1));
	}

	@Test
	void testJirafaNoPuedePasar() throws Exception {
		System.out.println("\nJirafa: sin poder pasar");
		Carta jirafa = new Carta(8,jugarColor,CartaFactory.getCartaFactory().crearCarta(8));
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(8,jugarColor, CartaFactory.getCartaFactory().crearCarta(8)));
		ColaDelBar.getColaDelBar().addCarta(jirafa);
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		System.out.println("hace animalada");
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
		System.out.println("Estado del bar después del salto");
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(mono,ColaDelBar.getColaDelBar().getCarta(0));
		assertEquals(monoCPU,ColaDelBar.getColaDelBar().getCarta(1));
		assertEquals(mofeta,ColaDelBar.getColaDelBar().getCarta(2));
	}
	
	@Test
	void testHipopotamoPuedePasar() throws Exception {
		System.out.println("\nHipop�tamo: pudiendo pasar");
		Carta hipopotamo = new Carta(11,jugarColor,CartaFactory.getCartaFactory().crearCarta(11));
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(hipopotamo);
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		hipopotamo.hacerAnimalada();
		System.out.println("hace animalada");
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(hipopotamo,ColaDelBar.getColaDelBar().getCarta(0));
	}

	@Test
	void testHipopotamoNoPuedePasar() throws Exception {
		System.out.println("\nHipop�tamo: sin poder pasar");
		Carta hipopotamo = new Carta(11,jugarColor,CartaFactory.getCartaFactory().crearCarta(11));
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(7,jugarColor, CartaFactory.getCartaFactory().crearCarta(7)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(hipopotamo);
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		hipopotamo.hacerAnimalada();
		System.out.println("hace animalada");
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
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		cocodrilo.hacerAnimalada();
		System.out.println("hace animalada");
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
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		cocodrilo.hacerAnimalada();
		System.out.println("hace animalada");
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
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		mofeta.hacerAnimalada();
		System.out.println("hace animalada");
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
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		System.out.println("hace animalada");
		mofeta.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(0,ColaDelBar.getColaDelBar().cuantasHay());
	}
	
	@Test
	void testMofetaSinAltas() throws Exception {
		System.out.println("\nMofeta: ");
		Carta mofeta = new Carta(1,jugarColor,CartaFactory.getCartaFactory().crearCarta(1));
		ColaDelBar.getColaDelBar().addCarta(mofeta);
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		System.out.println("hace animalada");
		mofeta.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
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
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		System.out.println("hace animalada");
		loro.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(valorAnt,ColaDelBar.getColaDelBar().cuantasHay());
	}
}
