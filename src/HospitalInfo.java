import java.util.ArrayList;

public class HospitalInfo {
	int status;
	String statusInfo;
	HospitalObj data;
	int t;
}

class HospitalObj{
	ArrayList<HospitalMinObj> hospitalList;
	int total;
	String currentArea;
	int isDepartmentPage;
}

class HospitalMinObj{
	String name;
	String logo;
	String address;
	String level;
	int insurance;
	String routeLink;
	String link;
	String desc;
	String descCut;
	String phone;
	int doctorNum;
	int serviceNum;
	boolean serviceGuahao;
	boolean serviceTixing;
	int serveNum;
	int commentNum;
	String commentHref;
	String grade;
	String treatLevel;
	int diseaseDocNum;
	String departmentLevel;
	int departmentDocNum;
	String serviceConsult;
	String serviceOrder;
}
