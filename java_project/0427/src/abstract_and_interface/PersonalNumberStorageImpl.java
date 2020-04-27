package abstract_and_interface;

//public class PersonalNumberStorageImpl extends PersonalNumberStroage {
	public class PersonalNumberStorageImpl implements  PersonalNumber {

	PersonalNumberInfo[] perArr;
	int numOfPersonalInfo;

	PersonalNumberStorageImpl(int num) {
		perArr = new PersonalNumberInfo[num];
		numOfPersonalInfo = 0;
	}

	@Override
	public void addPersonalInfo(String perNum, String name) {
		perArr[numOfPersonalInfo] = new PersonalNumberInfo(name, perNum);
		numOfPersonalInfo++;
	}

	@Override
	public String searchName(String perNum) {
		for (int i = 0; i < numOfPersonalInfo; i++) {
			if(perArr[i].getNumber().equals(perNum)) {
				return  perArr[i].getName();
				
			}
		}
		return null;
	}

}
