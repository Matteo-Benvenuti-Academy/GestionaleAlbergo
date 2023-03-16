package com.gestionaleAlberghi;

import java.sql.Date;

import com.gestionaleAlberghi.models.Albergo;
import com.gestionaleAlberghi.models.Stanza;
import com.gestionaleAlberghi.utils.MyCurrentDate;
import com.gestionaleAlberghi.view.AlbergoFacade;
import com.gestionaleAlberghi.view.PrenotazioneFacade;
import com.gestionaleAlberghi.view.StanzaFacade;


public class App  {
    public static void main( String[] args ) {
    	
    	Albergo alb = AlbergoFacade.getIstanza().createAlbergo("albero bello", 4);
//    	Albergo alb2 = AlbergoFacade.getIstanza().createAlbergo("albero brutto", 5);
//
    	Stanza sta1 = StanzaFacade.getIstanza().createStanza("1", true, alb);
    	Stanza sta2 = StanzaFacade.getIstanza().createStanza("2", false, alb);
    	
    	alb.getElenco_stanze().add(sta1);
    	alb.getElenco_stanze().add(sta2);
    	
//    	PrenotazioneFacade.getIstanza().createPrenotazione(new Date(122, 10, 10), new Date(122, 10, 12), sta1);
//    	PrenotazioneFacade.getIstanza().createPrenotazione(new Date(122, 10, 10), new Date(122, 10, 12), sta2);
    	
    	AlbergoFacade.getIstanza().exportAlbergo("src/main/java/outputFile", alb);
    	
    }
}
