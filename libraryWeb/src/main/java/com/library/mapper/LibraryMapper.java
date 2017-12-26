package com.library.mapper;

import com.library.entity.AddBookGroupParam;
import com.library.entity.Position;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface LibraryMapper {

    List<Position> getPositionList();

    void addBookGroup(@Param("info") AddBookGroupParam info);
}
