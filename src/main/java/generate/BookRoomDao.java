package generate;

import generate.BookRoom;

public interface BookRoomDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BookRoom record);

    int insertSelective(BookRoom record);

    BookRoom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookRoom record);

    int updateByPrimaryKey(BookRoom record);
}