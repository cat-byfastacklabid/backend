package cat.kepolisian.dao.impl;

import cat.kepolisian.core.BaseDaoImpl;
import cat.kepolisian.dao.HistoryDao;
import cat.kepolisian.entity.History;
import cat.kepolisian.repository.HistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("JpaHQL")
@Repository
public class HistoryDaoImpl extends BaseDaoImpl implements HistoryDao {
    HistoryRepository historyRepository;

    @Autowired
    public void setHistoryRepository(HistoryRepository historyRepository){
        this.historyRepository = historyRepository;
    }
    @Override
    public List<History> getAll() throws Exception {
        return historyRepository.findAll();
    }

    @Override
    public History getById(String id) throws Exception {
        return historyRepository.getById(id);
    }

    @Override
    public History save(History data) throws Exception {
        return historyRepository.saveAndFlush(data);
    }
}
