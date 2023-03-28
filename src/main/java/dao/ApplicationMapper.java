package dao;

import pojo.Application;

import java.util.List;

public interface ApplicationMapper {
    int insert(Application record);

    List<Application> selectApplication();
}
