package com.library.service.imp;

import com.library.entity.AddBookGroupParam;
import com.library.entity.Position;
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
        if(param==null){
            throw  new BusinessException("信息不能为空");
        }
        if(StringUtils.isNotBlank(param.getName())){
            throw new BusinessException("书籍名称不能为空");
        }
        return 0;
    }
}
