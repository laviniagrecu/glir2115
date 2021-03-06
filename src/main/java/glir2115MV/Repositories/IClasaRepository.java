package glir2115MV.Repositories;

import glir2115MV.Models.*;
import glir2115MV.utils.ClasaException;

import java.util.HashMap;
import java.util.List;

public interface IClasaRepository {
	
	public void creazaClasa(List<Elev> elevi, List<Nota> note);
	public HashMap<Elev, HashMap<String, List<Double>>> getClasa();
	public List<Medie> calculeazaMedii() throws ClasaException;
	public void afiseazaClasa();
	public List<Corigent> getCorigenti();
}
