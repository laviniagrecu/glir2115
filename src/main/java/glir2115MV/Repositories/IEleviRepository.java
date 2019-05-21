package glir2115MV.Repositories;

import glir2115MV.Models.Elev;

import java.util.List;

public interface IEleviRepository {
	public void addElev(Elev e);
	public List<Elev> getElevi();
	public void readElevi(String fisier);
}
