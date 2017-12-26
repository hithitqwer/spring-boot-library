package com.library.mapper;

import com.library.entity.AddBookGroupParam;
import com.library.entity.Position;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import javax.annotation.security.PermitAll;
import java.util.List;

@Mapper
public interface LibraryMapper {

    List<Position> getPositionList();

    int addBookGroup(@Param("info") AddBookGroupParam info);

    int addBookSKU(@Param("bookIds") List<String> bookIds, @Param("groupSysNo") int groupSysNo);

    int addPosition(@Param("info") Position info);

    int checkIsHavePosition(@Param("value") String value);

    int checkIsHaveBook(String bookId);
}
