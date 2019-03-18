package hdir2118MV.Repositories;

import hdir2118MV.Models.Elev;

import java.util.List;

public interface EleviRepository {
	public void addElev(Elev e);
	public List<Elev> getElevi();
	public void readElevi(String fisier);
}
