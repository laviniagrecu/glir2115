package hdir2118MV.Controllers;

import hdir2118MV.Models.*;
import hdir2118MV.Repositories.*;
import hdir2118MV.utils.ClasaException;

import java.util.HashMap;
import java.util.List;

public class NoteController {
	private INoteRepository note;
	private IClasaRepository clasa;
	private IEleviRepository elevi;

	public NoteController() {
		note = new NoteRepository();
		clasa = new ClasaRepository();
		elevi = new EleviRepository();
	}
	
	public void addNota(Nota nota) throws ClasaException {
		note.addNota(nota);
	}
	
	public void addElev(Elev elev) {
		elevi.addElev(elev);
	}
	
	public void creeazaClasa(List<Elev> elevi, List<Nota> note) {
		clasa.creazaClasa(elevi, note);
	}
	
	public List<Medie> calculeazaMedii() throws ClasaException {
			return clasa.calculeazaMedii();
	}
	
	public List<Nota> getNote() {
		return note.getNote();
	}
	
	public List<Elev> getElevi() {
		return elevi.getElevi();
	}
	
	public HashMap<Elev, HashMap<String, List<Double>>> getClasa() {
		return clasa.getClasa();
	}
	
	public void afiseazaClasa() {
		clasa.afiseazaClasa();
	}
	
	public void readElevi(String fisier) {
		elevi.readElevi(fisier);
	}
	
	public void readNote(String fisier) {
		note.readNote(fisier);
	}
	
	public List<Corigent> getCorigenti() {
		return clasa.getCorigenti();
	}
}
