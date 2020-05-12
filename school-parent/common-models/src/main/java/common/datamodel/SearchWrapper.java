package common.datamodel;

import java.util.ArrayList;
import java.util.List;

public class SearchWrapper {

	SearchStudent searchStudent;
	List<StudentDO> studentsList = new ArrayList<StudentDO>();
	public SearchStudent getSearchStudent() {
		return searchStudent;
	}

	public void setSearchStudent(SearchStudent searchStudent) {
		this.searchStudent = searchStudent;
	}

	public List<StudentDO> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(List<StudentDO> studentsList) {
		this.studentsList = studentsList;
	}
	
}
