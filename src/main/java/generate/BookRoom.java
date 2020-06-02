package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * book_room
 * @author 
 */
@Data
public class BookRoom implements Serializable {
    private Integer id;

    /**
     * 入住用户姓名

     */
    private String userName;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 入住房间号

     */
    private Integer roomNummber;

    /**
     * 入住时间

     */
    private Date inTime;

    /**
     * 离开时间

     */
    private Date outTime;

    /**
     * 定金

     */
    private Integer deposit;

    private static final long serialVersionUID = 1L;
}