
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Pruebas de  la implementacion propia de listas enlazadas
 * @author Santiago Escobar, Sebastian Giraldo y Luisa Maria Vasquez
 */
public class LinkedListLab4Test {

	
	/**
	 * Test para probar si la funcion insert funciona al principio de la lista, al final de la lista y en la lista vacia.
	 */
    @Test
	public void testInsert() {
		LinkedListLab4 list = new LinkedListLab4();
		list.insert(0, 0); //Insertar en lista vacia
		list.insert(1, 1);
		list.insert(2, 2);
		list.insert(3, 3);
		list.insert(4, 4);
		list.insert(10, 0); // Insertar al principio
		list.insert(33, 3);// Insertar en el medio	
		list.insert(6, 6);// Insertar al final
		
			assertEquals(list.get(0),10);
			assertEquals(list.get(3),33);
			assertEquals(list.get(6),6);
	}

	
	/**
	 * Test para probar si la funcion remove funciona al principio de la lista, al final de la lista y en la lista vacia.
	 */
	@Test
	public void testRemove() {
		LinkedListLab4 list = new LinkedListLab4();
		list.insert(5, 0);
		list.insert(4, 1);
		list.insert(3, 2);
		list.insert(2, 3);
		list.insert(1, 4);
		
		list.remove(4);//Remover al final
		list.remove(2); //Remover en el medio
		list.remove(0); //Remover al principio
		
		LinkedListLab4 list2=new LinkedListLab4();
		list2.remove(0); //Remover de lista vacia
		
		assertFalse(list.contains(1));		
		assertFalse(list.contains(3));
		assertFalse(list.contains(5));
		assertFalse(list2.contains(1));
	}

	/**
	 * Test para probar si la funcion contains funciona al principio de la lista, al final de la lista y en la lista vacia.
	 */
	@Test
	public void testContains() {
		LinkedListLab4 list = new LinkedListLab4();
		list.insert(5, 0);
		list.insert(4, 0);
		list.insert(3, 0);
		list.insert(2, 0);
		list.insert(1, 0);
		LinkedListLab4 list2=new LinkedListLab4();
		assertTrue(list.contains(1));
		assertTrue(list.contains(5)); 
		assertTrue(list.contains(3));
		assertFalse(list2.contains(3));
		
	}

}