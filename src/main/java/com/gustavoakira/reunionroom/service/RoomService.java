package com.gustavoakira.reunionroom.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavoakira.reunionroom.dto.RoomDTO;
import com.gustavoakira.reunionroom.exception.ResourceNotFoundException;
import com.gustavoakira.reunionroom.model.Room;
import com.gustavoakira.reunionroom.repository.RoomRepository;
import com.gustavoakira.reunionroom.service.helpers.TransformHelper;

@Service
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;
	
	
	public List<RoomDTO> getRooms() {
		List<Room> rooms = roomRepository.findAll();
		return rooms.stream().map(x -> TransformHelper.toRoomDTO(x)).collect(Collectors.toList());
	}
	
	public Room getRoom(Long id) throws ResourceNotFoundException {
		return roomExist(id);
	}
	
	public RoomDTO saveRoom(RoomDTO roomDTO) {
		Room room = TransformHelper.toRoom(roomDTO);
		return TransformHelper.toRoomDTO(roomRepository.save(room));
	}
	
	public RoomDTO updateRoom(RoomDTO roomDTO, Long id) throws ResourceNotFoundException {
		roomExist(id);
		roomDTO.setId(id);
		Room room = TransformHelper.toRoom(roomDTO);
		return TransformHelper.toRoomDTO(roomRepository.save(room));
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
