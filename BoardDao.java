package springweb1.a03_mvc.a03_repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import springweb1.a03_mvc.a04_vo.Board;


@Repository
public interface BoardDao {
	// empMapper.xml과 연결
	// EmpRep ==> namespace명
	// ArrayList<Emp> ==> ResultMap
	// empList ==> id
	// Emp ==> parameterType
	public ArrayList<Board> boardList(Board sch);
	
	public void insertBoard(Board sch);
}
