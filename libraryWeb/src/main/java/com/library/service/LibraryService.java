package com.library.service;

import com.library.entity.*;

import java.util.List;

public interface LibraryService {

    List<Position> getPositionList();

    int addBookGroup(AddBookGroupParam param);

    PageInfoResult<BookGroupResult> queryBookGroup(QueryBookParam param);

    Integer addPosition(Position position);

}
