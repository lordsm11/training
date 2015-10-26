package tn.med.persistance;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import org.springframework.stereotype.Service;
import tn.med.model.business.ImpotInfo;
import tn.med.model.dto.ImpotForm;

import java.math.BigDecimal;

@Service
public class ImpotsDao {

    public void saveObject(ImpotForm impotForm, ImpotInfo impotInfo, BigDecimal impot) {

        Entity simulationImpot = new Entity("Simulation_impots");
        simulationImpot.setProperty("Impots", impot.doubleValue());
        simulationImpot.setProperty("deductions", impotForm.getDeductions());
        simulationImpot.setProperty("montant1", impotForm.getAmount1());
        simulationImpot.setProperty("montant2", impotForm.getAmount2());
        simulationImpot.setProperty("nbChildren", impotForm.getNbChildren());
        simulationImpot.setProperty("nbParts", impotInfo.getNbParts().doubleValue());
        simulationImpot.setProperty("onePart", impotForm.isOnePart());

        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(simulationImpot);

    }
}
