package com.library.service;

import com.library.entity.AddBookGroupParam;
import com.library.entity.Position;
import java.util.List;

public interface LibraryService {

    List<Position> getPositionList();

    int addBookGroup(AddBookGroupParam param);

}
