package com.library.service;

import com.library.entity.*;

import java.util.List;

public interface LibraryService {

    List<Position> getPositionList();

    int addBookGroup(AddBookGroupParam param);

    PageInfoResult<BookGroupInfo> queryBookGroup(QueryBookParam param);

    Integer addPosition(Position position);

    PageInfoResult<BookSKUInfo> queryBookSku(QueryBookParam param);

    void updateBookSkuStatus(int sysNo,int status);

    void deletePosition(int sysNo);
}
