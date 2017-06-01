/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author tiago.lucas
 */
@FacesValidator("dataValidator")
public class DataValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String strInicio = (String)component.getAttributes().get("inicio");
        String strFim=(String)component.getAttributes().get("fim");
        //Date dt = new Date(1987, 1, 22);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy");
        try {
            Date dtEntrada = new Date(formatter.parse(strInicio).getTime());
            Date dtSaida = new Date(formatter.parse(strFim).getTime());
            Calendar c = Calendar.getInstance();
            long l = dtSaida.getTime() - dtEntrada.getTime();
            c.setTimeInMillis(l);
            
        } catch (ParseException ex) {
            Logger.getLogger(DataValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar cl;
        
        if(strInicio.equals("22/01/1987")){
            
        }
    }
    
}
