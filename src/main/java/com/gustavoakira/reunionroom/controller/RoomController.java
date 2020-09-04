package com.gustavoakira.reunionroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavoakira.reunionroom.dto.RoomDTO;
import com.gustavoakira.reunionroom.exception.ResourceNotFoundException;
import com.gustavoakira.reunionroom.model.Room;
import com.gustavoakira.reunionroom.service.RoomService;

@RestController
@RequestMapping("api/v1")
public class RoomController {
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/rooms")
	public List<RoomDTO> getRooms() {
		return roomService.getRooms();
	}
	
	@PostMapping("/room")
	public RoomDTO saveRoom(@RequestBody RoomDTO roomDTO) {
		return roomService.saveRoom(roomDTO);
	}
	
	@PutMapping("/room/{id}")
	public RoomDTO updateRoom(@RequestBody RoomDTO roomDTO,@PathVariable Long id) throws ResourceNotFoundException {
		return roomService.updateRoom(roomDTO, id);
	}
	
	@DeleteMapping("/room/{id}")
	public String deleteRoom(@PathVariable Long id) throws ResourceNotFoundException {
		return roomService.deleteRoom(id);
	}
}
