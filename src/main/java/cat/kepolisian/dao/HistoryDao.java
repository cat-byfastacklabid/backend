package cat.kepolisian.dao;

import cat.kepolisian.entity.History;

import java.util.List;

public interface HistoryDao {
    public List<History> getAll() throws Exception;
    public History getById(String id) throws Exception;
    public History save(History data) throws Exception;
}
