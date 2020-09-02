package com.gustavoakira.reunionroom.dto;

import java.sql.Time;
import java.time.LocalDate;

import lombok.Data;

@Data
public class RoomDTO {
	private LocalDate date;
	private Time startHour;
	private Time endHour;
}
