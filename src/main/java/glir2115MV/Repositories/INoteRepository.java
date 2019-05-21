package hdir2118MV.Repositories;

import hdir2118MV.Models.Nota;
import hdir2118MV.utils.ClasaException;

import java.util.List;

public interface INoteRepository {
	
	public void addNota(Nota nota) throws ClasaException;
	public List<Nota> getNote();
	public void readNote(String fisier);
	
}
