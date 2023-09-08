package com.choongang.concert.dto;

import lombok.Data;

@Data
public class PagingDTO {
	
	//	한 페이지에 보여줄 게시물의 수
    private int rowCount  = 10;
    
    //	페이지 번호를 나타내는 버튼의 수
    private int pageCount = 3;
    
    //	전체 항목의 수
    private int totalCount;
    
    //	현재 페이지 번호
    private int page;
    
    //	현재 페이지 범위의 시작 페이지 번호
    private int startPage = 1;
    
    //	현재 페이지 범위의 마지막 페이지 번호
    private int endPage;
    
    //	전체 페이지의 수
    private int totalPageCount;
    
    private boolean isPrev = false; // 다음 페이지
    private boolean isNext = false; // 이전 페이지
    
    //	데이터베이스에서 조회할 데이터의 시작 위치
    private int offset;

    //	
    public PagingDTO(final int totalCount, final int page) {

        setTotalPageCount(totalCount, this.rowCount);
        setStartPage(this.startPage, page, this.pageCount);
        setEndpage(this.startPage, this.pageCount, this.totalPageCount);
        isPrev(page, this.pageCount);
        isNext(this.endPage, this.totalPageCount);
        setOffset(page, this.rowCount);
    }

    private void setTotalPageCount(final int totalCount, final int rowCount) {
        this.totalPageCount = (int) Math.ceil(totalCount * 1.0 / rowCount);
    }

    private void setStartPage(final int startPage, final int page, final int pageCount) {
        this.startPage = startPage + (((page - startPage) / pageCount) * pageCount);
    }

    private void setEndpage(final int startPage, final int pageCount, final int totalPageCount) {
        this.endPage = ((startPage - 1) + pageCount) < totalPageCount ? (startPage - 1) + pageCount : totalPageCount;
    }

    private void isPrev(final int page, final int pageCount) {
        this.isPrev = 1 < ((page * 1.0) / pageCount);
    }

    private void isNext(final int endPage, final int totalPageCount) {
        this.isNext = endPage < totalPageCount;
    }

    private void setOffset(final int page, final int rowCount) {
        this.offset = (page - 1) * rowCount;
    }
}