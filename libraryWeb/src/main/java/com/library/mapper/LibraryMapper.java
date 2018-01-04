package com.library.mapper;

import com.library.entity.*;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import javax.annotation.security.PermitAll;
import javax.management.Query;
import java.util.List;

@Mapper
@Component
public interface LibraryMapper {

    List<Position> getPositionList();

    int addBookGroup(@Param("info") AddBookGroupParam info);

    int addBookSKUS(@Param("bookIds") List<String> bookIds, @Param("groupSysNo") int groupSysNo);

    int addPosition(@Param("info") Position info);

    int checkIsHavePosition(@Param("value") String value);

    int checkIsHaveBook(@Param("id") String bookId);

    List<BookGroupInfo> queryBookGroups(@Param("info") QueryBookParam param);

    int queryBookGroupsTotalCount(@Param("info") QueryBookParam param);

    int borrowBook(@Param("bookSysNo") int bookSysNo,@Param("inUser") int inUser);

    int returnBook(@Param("bookSysNo") int bookSysNo,@Param("inUser") int inUser);

    BookSKUInfo getBookSku(@Param("bookSysNo") int bookSysNo);

    int queryBookSKUTotalCount(@Param("info") QueryBookParam param);

    List<BookSKUInfo> queryBookSKU(@Param("info") QueryBookParam param);

    int updateBookSkuStatus(@Param("sysNo") int sysNo,@Param("status") int status);

    int deletePosition(@Param("sysNo")int sysNo);
}
