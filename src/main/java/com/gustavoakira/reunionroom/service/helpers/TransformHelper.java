package com.gustavoakira.reunionroom.service.helpers;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import com.gustavoakira.reunionroom.dto.RoomDTO;
import com.gustavoakira.reunionroom.model.Room;

public class TransformHelper {
	public static Room toRoom(RoomDTO roomDTO) {
		return Room.builder().name(roomDTO.getName()).id(roomDTO.getId()).date(roomDTO.getDate().toString()).startHour(roomDTO.getStartHour().toLocalTime().toString()).endHour(roomDTO.getEndHour().toLocalTime().toString()).build();
	}
	public static RoomDTO toRoomDTO(Room room) {
		return RoomDTO.builder().name(room.getName()).id(room.getId()).date( LocalDate.parse(room.getDate(),DateTimeFormatter.ofPattern("yyyy-MM-dd"))).startHour(Time.valueOf(room.getStartHour())).endHour(Time.valueOf(room.getEndHour())).build();
	}
}
