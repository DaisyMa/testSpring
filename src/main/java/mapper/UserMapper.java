package mapper;

import model.AddUserCase;
import model.User;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

public interface UserMapper {
    /**
     *
     * @param name
     * @param status
     * @param createTime
     * @return
     */
    User addUserCheck(@Param("name") String name, @Param("status") Integer status, @Param("createTime") String createTime);

    /**
     *
     * @param id
     * @return
     */
    AddUserCase addUserCase(@Param("id") Integer id);

}
