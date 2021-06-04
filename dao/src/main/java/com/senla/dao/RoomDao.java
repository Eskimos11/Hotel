package com.senla.dao;




import com.senla.api.dao.IRoomDao;
import com.senla.model.Guest;
import com.senla.model.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoomDao extends AbstractDao<Room> implements IRoomDao {


    @Override
    public void saveAll(List<Room> entity) {

    }

    @Override
    protected Class<Room> getClazz() {
        return Room.class;
    }
}















