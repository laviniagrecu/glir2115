package glir2115MV.Repositories;

import glir2115MV.Models.Nota;
import glir2115MV.utils.ClasaException;

import java.util.List;

public interface INoteRepository {
	
	public void addNota(Nota nota) throws ClasaException;
	public List<Nota> getNote();
	public void readNote(String fisier);
	
}
