package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.model.Purchase;
import com.ejemplos.spring.repository.PurchaseRepository;
import com.ejemplos.spring.service.PurchaseServiceImpl;

@SpringBootTest
public class PurchaseListTest {

	@InjectMocks
	private PurchaseServiceImpl service;

	@Mock
	private PurchaseRepository repo;

	List<Purchase> list = new ArrayList<Purchase>();
	{
		Purchase pur = new Purchase("11111111", "25", 3, (double) 30, "grada", true);
		Purchase pur2 = new Purchase("22222222", "26", 5, (double) 350, "pista", false);
		Purchase pur3 = new Purchase("33333333", "27", 1, (double) 10, "grada", true);

		list.add(pur);
		list.add(pur2);
		list.add(pur3);
	}

	/*
	 * Test para comprobar que el tamaño de la lista coincide con el de la BBDD
	 */
	@Test
	public void getSizePurchaseListTest() {
		when(repo.findAll()).thenReturn(list);
		// test
		List<Purchase> empList = service.findAll();
		assertEquals(3, empList.size());
		verify(repo, times(1)).findAll();
	}

	/*
	 * Test que comprueba si está vacía la lista
	 */
	@Test
	public void purchaseListEmptyTest() {
		assertThat(repo.findAll()).isEmpty();
	}

	/*
	 * Test que comprueba si la lista encontrada es igual a la de la BBDD
	 */
	@Test
	public void returnAllPurchase() {
		when(repo.findAll()).thenReturn(list);
		assertEquals(repo.findAll(), list);
	}

	/*
	 * Test para comprobar que el resultado de la lista no es nulo
	 */
	@Test
	public void allPurchaseNotNullTest() {
		when(repo.findAll()).thenReturn(list);
		assertNotNull(repo.findAll());

	}

	/*
	 * Test que comprueba si se ha guardado el usuario correctamente, comprobando
	 * devuelve el dni del usuario ya guardado
	 */
	@Test
	public void CreatePurchaseTest() {
		Purchase purchi = new Purchase("77777777", "29", 3, (double) 30, "palco", true);
		when(repo.save(purchi)).thenReturn(purchi);
		assertEquals(repo.save(purchi).getDni(), purchi.getDni());
	}

}