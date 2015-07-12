package com.business.service;

import java.util.List;

import com.business.persistence.vo.School;
import com.business.web.vo.GradeVO;
import com.business.web.vo.ProfileInfo;
import com.business.web.vo.StudentExcelVO;
import com.business.web.vo.TeacherExcelVO;

public interface IPersisteManager {

	abstract Object getStaticBean(String name);
	abstract boolean saveProfileInfo(ProfileInfo pi);
	abstract boolean saveSubjectInfo(School school, List<GradeVO> gradeList);
	abstract boolean saveTeacherInfo(List<TeacherExcelVO> teData);
	abstract boolean saveStudentInfo(List<StudentExcelVO> stData);
	
}
