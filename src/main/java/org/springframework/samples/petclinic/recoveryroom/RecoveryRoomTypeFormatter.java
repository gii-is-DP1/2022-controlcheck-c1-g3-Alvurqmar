package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

	private final RecoveryRoomService recoveryRoomService;
	
	@Autowired
	public RecoveryRoomTypeFormatter(RecoveryRoomService recoveryRoomService) {
	 this.recoveryRoomService = recoveryRoomService;
	}
	
    @Override
    public String print(RecoveryRoomType object, Locale locale) {
        String nombre= object.getName();
    	return nombre;
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
    	RecoveryRoomType findProductType = this.recoveryRoomService.getRecoveryRoomType(text);
        if(findProductType != null){
            return findProductType;
        }
        throw new ParseException("Product type not found: " + text, 0);
    }
    
}
