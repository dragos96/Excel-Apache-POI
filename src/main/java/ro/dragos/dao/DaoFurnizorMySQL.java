package ro.dragos.dao;

import java.util.List;

import ro.dragos.dao.spec.IDao;
import ro.dragos.model.Furnizor;

public class DaoFurnizorMySQL implements IDao<Furnizor> {

	public List<Furnizor> findAll(){
		return null;
	}

	@Override
	public void save(Furnizor obj) {
		throw new UnsupportedOperationException();
		
	}
	
}
