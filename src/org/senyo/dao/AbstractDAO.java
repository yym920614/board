package org.senyo.dao;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface AbstractDAO {

	public void create(BoardVO vo) throws Exception;

	public BoardVO read(Integer bno) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(BoardVO vo) throws Exception;
	
	public List<BoardVO> listPage(int page)throws Exception;

}
