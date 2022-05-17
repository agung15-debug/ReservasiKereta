package dao;

import model.Kereta;
import java.util.List;

public interface interfaceKereta {
    public void insert(Kereta kereta1);

    public void update(Kereta kereta1);

    public void delete(int id);

    public List<Kereta> getData();
}
