package com.gestionaleAlberghi.view;

import java.util.List;

import com.gestionaleAlberghi.models.Albergo;
import com.gestionaleAlberghi.models.Stanza;
import com.gestionaleAlberghi.models.Dao.AlbergoDao;
import com.gestionaleAlberghi.utils.MyCurrentDate;
import com.gestionaleAlberghi.utils.MyFileWriter;

public class AlbergoFacade {

	private static AlbergoFacade ogg;

	public static AlbergoFacade getIstanza() {
		if (ogg == null)
			ogg = new AlbergoFacade();

		return ogg;
	}

	public AlbergoFacade() {

	}

	public Albergo createAlbergo(String nome, Integer numeroStelle) {
		Albergo temp = new Albergo(nome, numeroStelle);
	    AlbergoDao.getIstanza().insert(temp);
	    return temp;
	}

	public List<Albergo> listaAlberghi() {
		return AlbergoDao.getIstanza().findAll();
	}
	
	public boolean exportAlbergo(String path, Albergo alb) {
		
		List<Stanza> listaStanze= alb.getElenco_stanze();
		
		StringBuilder exportText = new StringBuilder();
		for(Stanza s:listaStanze) {
			exportText.append(s.getNumero());
			exportText.append(",");
			exportText.append(s.getStato()== true ? "Occupata" : "Libera");
			exportText.append("\n");
			
		}
		String fileName = "Esportazione_"+MyCurrentDate.getCurrentDateString()+".txt";
		
		MyFileWriter fw = new MyFileWriter(path);
		String s = exportText.toString();
		return fw.write(fileName , exportText.toString());
	}
}
