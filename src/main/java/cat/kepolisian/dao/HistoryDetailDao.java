package cat.kepolisian.dao;

import cat.kepolisian.entity.HistoryDetail;

import java.util.List;

public interface HistoryDetailDao {
    public List<HistoryDetail> getAll() throws Exception;
    public HistoryDetail getById(String id) throws Exception;
    public HistoryDetail save(HistoryDetail data) throws Exception;
}
