package cat.kepolisian.dao.impl;

import cat.kepolisian.core.BaseDaoImpl;
import cat.kepolisian.dao.HistoryDetailDao;
import cat.kepolisian.entity.HistoryDetail;
import cat.kepolisian.repository.HistoryDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("JpaHQL")
@Repository
public class HistoryDetailDaoImpl extends BaseDaoImpl implements HistoryDetailDao {
    HistoryDetailRepository historyDetailRepository;

    @Autowired
    public void setHistoryDetailRepository(HistoryDetailRepository historyDetailRepository){
        this.historyDetailRepository = historyDetailRepository;
    }
    @Override
    public List<HistoryDetail> getAll() throws Exception {
        return historyDetailRepository.findAll();
    }

    @Override
    public HistoryDetail getById(String id) throws Exception {
        return historyDetailRepository.getById(id);
    }

    @Override
    public HistoryDetail save(HistoryDetail data) throws Exception {
        return historyDetailRepository.saveAndFlush(data);
    }
}
