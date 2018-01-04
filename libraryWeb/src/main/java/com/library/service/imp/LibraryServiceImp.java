package com.library.service.imp;

import com.library.entity.*;
import com.library.mapper.LibraryMapper;
import com.library.service.LibraryService;
import com.library.utility.BusinessException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibraryServiceImp implements LibraryService {

    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public List<Position> getPositionList() {
        return libraryMapper.getPositionList();
    }

    @Override
    @Transactional
    public int addBookGroup(AddBookGroupParam param) {
        if(param==null){
            throw  new BusinessException("信息不能为空");
        }
        if(StringUtils.isBlank(param.getName())){
            throw new BusinessException("书籍名称不能为空");
        }
        param.getBookIdList().forEach(item->{
            if(libraryMapper.checkIsHaveBook(item)>0){
                throw new BusinessException(item+"已经存在了");
            }
        });
        if(libraryMapper.addBookGroup(param)==0){
            throw new BusinessException("添加失败");
        }
        if(libraryMapper.addBookSKUS(param.getBookIdList(),param.getSysNo())==0){
            throw new BusinessException("添加失败");
        }
        return param.getSysNo();
    }

    @Override
    public Integer addPosition(Position position) {
        if(position==null || StringUtils.isBlank(position.getValue())){
            throw new BusinessException("位置信息不完整");
        }
        if(libraryMapper.checkIsHavePosition(position.getValue().trim())>0){
            throw new BusinessException("此位置已经存在了");
        }
        libraryMapper.addPosition(position);
        return position.getSysNo();
    }

    @Override
    public PageInfoResult<BookGroupInfo> queryBookGroup(QueryBookParam param) {
        PageInfoResult<BookGroupInfo> result = new PageInfoResult<BookGroupInfo>();
        result.setTotalCount(10);
        List<BookGroupInfo> groupList = libraryMapper.queryBookGroups(param);
        result.setData(groupList);
        return result;
    }

    @Override
    public PageInfoResult<BookSKUInfo> queryBookSku(QueryBookParam param) {
        if(param==null) {
            throw new BusinessException("查询参数不能为空");
        }
        param.pageLimitStart();
        int totalCount = libraryMapper.queryBookSKUTotalCount(param);
        List<BookSKUInfo> curPage = libraryMapper.queryBookSKU(param);
        PageInfoResult<BookSKUInfo> result = new PageInfoResult<>();
        result.setTotalCount(totalCount);
        result.setData(curPage);
        return result;
    }

    @Override
    public void updateBookSkuStatus(int sysNo, int status) {
        if(status!=0 && status!=1){
            throw new BusinessException("未知状态");
        }
        int count = libraryMapper.updateBookSkuStatus(sysNo,status);
        if(count==0){
            throw  new BusinessException("更新失败,书本不存在");
        }
    }

    @Override
    public void deletePosition(int sysNo) {
        if(libraryMapper.deletePosition(sysNo)==0){
            throw new BusinessException("位置不存在或已被删除");
        }
    }
}
