package com.gestionaleAlberghi.view;

import java.util.List;

import com.gestionaleAlberghi.models.Albergo;
import com.gestionaleAlberghi.models.Dao.AlbergoDao;

public class AlbergoFacade {
	
	public boolean createAlbergo(String nome, Integer numeroStelle) {
		return AlbergoDao.getIstanza().insert(new Albergo(nome,numeroStelle));
	}
	
	public List<Albergo> listaAlberghi(){
		return AlbergoDao.getIstanza().findAll();
	}
}
