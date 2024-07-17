package com.giasuonline.paging;

public interface Pageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}