package com.senla.dao;





import com.senla.api.dao.IHistoryDao;
import com.senla.model.History;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class HistoryDao extends AbstractDao<History> implements IHistoryDao {

    @Override
    public void saveAll(List<History> entity) {

    }

    @Override
    protected Class<History> getClazz() {
        return History.class;
    }
}

