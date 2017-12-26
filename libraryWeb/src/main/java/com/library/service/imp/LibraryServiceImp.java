package com.library.service.imp;

import com.library.entity.*;
import com.library.mapper.LibraryMapper;
import com.library.service.LibraryService;
import com.library.utility.BusinessException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int addBookGroup(AddBookGroupParam param) {
        param.setSysNo(0);
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
        if(libraryMapper.addBookSKU(param.getBookIdList(),param.getSysNo())==0){
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
    public PageInfoResult<BookGroupResult> queryBookGroup(QueryBookParam param) {
        return null;
    }
}
