package com.apartment.management.mapper;

import com.apartment.management.model.BookRoom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookRoomMapper {
    @Insert("insert into book_room (user_name,id_card,room_nummber,in_time,out_time,deposit) values (#{user_name},#{id_card},#{room_nummber},#{in_time},#{out_time},#{deposit})")
    void insert(BookRoom bookRoom);

    @Select("select * from book_room")
    List<BookRoom> selectAllBookRoom();
}
