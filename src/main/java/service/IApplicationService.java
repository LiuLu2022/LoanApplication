package service;

import com.github.pagehelper.PageInfo;
import common.ServerResponse;
import pojo.Application;

public interface IApplicationService {

    ServerResponse<String> addApplication(Application application);

    ServerResponse<PageInfo> getApplicationList(int pageNum, int pageSize);
}
