package com.gustavoakira.reunionroom.dto;

import java.sql.Time;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDTO {
	private Long id;
	private String name;
	private LocalDate date;
	private Time startHour;
	private Time endHour;
}
