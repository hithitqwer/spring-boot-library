package com.library.controller;

import com.library.entity.*;
import com.library.service.LibraryService;
import com.library.utility.*;
import com.sun.org.apache.bcel.internal.generic.RET;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "LibraryController", description = "图书相关接口")
@EnableAutoConfiguration
@RequestMapping(value = "/api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @ApiOperation(value = "添加新书",notes = "create by 张聪", httpMethod = "POST")
    @RequestMapping(value = "/addbookgroup",method = RequestMethod.POST)
    @Auth(role = "admin")
    public ApiResult<Integer> addBookGroup(AddBookGroupParam param){
        return new ApiResult<Integer>(libraryService.addBookGroup(param));
    }

    @ApiOperation(value = "分页获取书籍列表",notes = "create by 张聪", httpMethod = "GET")
    @RequestMapping(value = "/querybook",method = RequestMethod.GET)
    public ApiResult<PageInfoResult<BookGroupResult>> queryBooks(QueryBookParam param){
        return new ApiResult<PageInfoResult<BookGroupResult>>(libraryService.queryBookGroup(param));
    }

    @ApiOperation(value = "获取书籍地址列表",notes = "create by 张聪", httpMethod = "GET")
    @RequestMapping(value = "/getpositionlist",method = RequestMethod.GET)
    public ApiResult<List<Position>> getPositionList(){
        return new ApiResult<List<Position>>(libraryService.getPositionList());
    }

    @ApiOperation(value = "添加书籍地址列表,返回值是添加的编号",notes = "create by 张聪", httpMethod = "GET")
    @RequestMapping(value = "/addposition",method = RequestMethod.GET)
    public ApiResult<Integer> addPosition(Position param){
        return new ApiResult<Integer>(libraryService.addPosition(param));
    }

    @ApiOperation(value = "借书",notes = "create by 张聪", httpMethod = "GET")
    @RequestMapping(value = "/borrowbook",method = RequestMethod.GET)
    public ApiResult<Integer> borrowBook(int sysNo){
        return null;
    }

    @ApiOperation(value = "还书",notes = "create by 张聪", httpMethod = "GET")
    @RequestMapping(value = "/returnbook",method = RequestMethod.GET)
    public ApiResult returnBook(int sysNo){
        return null;
    }
}
