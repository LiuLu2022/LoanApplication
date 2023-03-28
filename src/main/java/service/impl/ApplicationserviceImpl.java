package service.impl;

import common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.ApplicationMapper;
import pojo.Application;
import service.IApplicationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

@Service("iApplicationService")
public class ApplicationserviceImpl implements IApplicationService {
    @Autowired
    private ApplicationMapper applicationMapper;

    public ServerResponse<String> addApplication(Application application){
        int resultCount = applicationMapper.insert(application);
        if(resultCount == 0){
            return ServerResponse.createByErrorMessage("申请失败");
        }
        return ServerResponse.createBySuccessMessage("申请成功");
    }

    public ServerResponse<PageInfo> getApplicationList(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Application> applicationList = applicationMapper.selectApplication();
        PageInfo pageResult = new PageInfo(applicationList);

        return ServerResponse.createBySuccess(pageResult);
    }

}
