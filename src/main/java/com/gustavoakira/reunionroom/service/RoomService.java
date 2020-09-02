package com.gustavoakira.reunionroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavoakira.reunionroom.exception.ResourceNotFoundException;
import com.gustavoakira.reunionroom.model.Room;
import com.gustavoakira.reunionroom.repository.RoomRepository;

@Service
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;
	
	public List<Room> getRooms() {
		return roomRepository.findAll();
	}
	
	public Room getRoom(Long id) throws ResourceNotFoundException {
		return roomExist(id);
	}
	
	public Room saveRoom(Room newRoom) {
		return roomRepository.save(newRoom);
	}
	
	public Room updateRoom(Room updateRoom, Long id) throws ResourceNotFoundException {
		roomExist(id);
		updateRoom.setId(id);
		return roomRepository.save(updateRoom);
	}
	
	public String deleteRoom(Long id) throws ResourceNotFoundException {
		roomExist(id);
		roomRepository.deleteById(id);
		return "Ok";
	}
	
	private Room roomExist(Long id) throws ResourceNotFoundException {
		return roomRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Room Not Found with Id:"+id));
	}
}
