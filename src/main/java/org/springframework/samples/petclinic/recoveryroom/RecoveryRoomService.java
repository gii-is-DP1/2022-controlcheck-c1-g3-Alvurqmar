package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RecoveryRoomService {
	
	private RecoveryRoomRepository recoveryRoomRepository;
	
	@Autowired
	public RecoveryRoomService(RecoveryRoomRepository recoveryRoomRepository) {
		this.recoveryRoomRepository = recoveryRoomRepository;
	}

    public List<RecoveryRoom> getAll(){
        List<RecoveryRoom> r = recoveryRoomRepository.findAll();
    	return r;
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return null;
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return recoveryRoomRepository.getRecoveryRoomType(typeName);
    }
    
    @Transactional
    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
        return recoveryRoomRepository.save(p);       
    }

    
}
