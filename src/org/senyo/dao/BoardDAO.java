package org.senyo.dao;

import java.util.ArrayList;
import java.util.List;

import org.zerock.domain.BoardVO;

public enum BoardDAO implements AbstractDAO {

	INSTANCE;

	@Override
	public void create(BoardVO vo) throws Exception {

		String sql = "insert into tbl_board(title, content, writer) values(?,?,?)";

		new ConnectDAO() {

			@Override
			public void doExecute() throws Exception {

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getWriter());
				int result = pstmt.executeUpdate();
				System.out.println(result);
			}

		}.execute();

	}

	@Override
	public BoardVO read(Integer bno) throws Exception {

		String sql = "select * from tbl_board where bno = ?";
		List<BoardVO> resultArr = new ArrayList<>();

		new ConnectDAO() {

			@Override
			public void doExecute() throws Exception {

				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bno);
				rs = pstmt.executeQuery();

				if (rs.next()) {

					BoardVO vo = new BoardVO();
					vo.setBno(rs.getInt("bno"));
					vo.setTitle(rs.getString("title"));
					vo.setContent(rs.getString("content"));
					vo.setWriter(rs.getString("writer"));
					vo.setRegdate(rs.getDate("regdate"));
					vo.setUpdatedate(rs.getDate("updatedate"));

					resultArr.add(vo);

				}

				System.out.println(resultArr.toString());

			}

		}.execute();
		return resultArr.get(0);

	}

	@Override
	public void update(BoardVO vo) throws Exception {

		String sql = "update tbl_board" + " set title = ?, content = ?, writer = ? where bno = ?";

		new ConnectDAO() {

			@Override
			public void doExecute() throws Exception {

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getWriter());
				pstmt.setInt(4, vo.getBno());
				pstmt.executeUpdate();

			}

		}.execute();

	}

	@Override
	public void delete(BoardVO vo) throws Exception {

		String sql = "delete from tbl_board where bno = ?";

		new ConnectDAO() {

			@Override
			public void doExecute() throws Exception {

				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, vo.getBno());
				pstmt.executeUpdate();
			
			}

		}.execute();

	}

}
