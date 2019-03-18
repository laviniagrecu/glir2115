package hdir2118MV.test;

import hdir2118MV.Models.*;
import hdir2118MV.utils.*;
import hdir2118MV.Controllers.NoteController;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculeazaMediiTest {

private NoteController ctrl;
	
	@Before
	public void init(){
		ctrl = new NoteController();
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void test1() throws ClasaException{
		Elev e1 = new Elev(1, "Elev1");
		Elev e2 = new Elev(2, "Elev2");
		ctrl.addElev(e1);
		ctrl.addElev(e2);
		Nota n1 = new Nota(1,"Materie1", 10);
		Nota n2 = new Nota(1,"Materie1", 7);
		Nota n3 = new Nota(1,"Materie2", 10);
		Nota n4 = new Nota(1,"Materie2", 10);
		Nota n5 = new Nota(2,"Materie2", 4);
		Nota n6 = new Nota(2,"Materie2", 3);
		Nota n7 = new Nota(2,"Materie2", 6);
		Nota n8 = new Nota(2,"Materie1", 7);
		ctrl.addNota(n1);
		ctrl.addNota(n2);
		ctrl.addNota(n3);
		ctrl.addNota(n4);
		ctrl.addNota(n5);
		ctrl.addNota(n6);
		ctrl.addNota(n7);
		ctrl.addNota(n8);
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		//ctrl.afiseazaClasa();
		List<Medie> rezultate = ctrl.calculeazaMedii();
		assertEquals(rezultate.size(),2);
	}
	
	@Test
	public void test2() throws ClasaException {
		expectedEx.expect(ClasaException.class);
		expectedEx.expectMessage(Constants.emptyRepository);
		ctrl.calculeazaMedii();
	}
	
	@Test
	public void test3() throws ClasaException {
		Elev e1 = new Elev(1, "Elev1");
		Elev e2 = new Elev(2, "Elev2");
		ctrl.addElev(e1);
		ctrl.addElev(e2);
		Nota n1 = new Nota(1,"Materie1", 10);
		ctrl.addNota(n1);
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Medie> rezultate = ctrl.calculeazaMedii();
		for(Medie m : rezultate)
			if(m.getElev().getNrmatricol() == 2)
				assertEquals(m.getMedie(),0,0.0001);
	}
	
}
