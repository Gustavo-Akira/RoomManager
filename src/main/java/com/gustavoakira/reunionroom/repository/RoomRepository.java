package com.gustavoakira.reunionroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavoakira.reunionroom.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
