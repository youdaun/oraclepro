package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PhoneApp {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<PersonVo> pList;
		PhoneDao pDao = new PhoneDao();
		boolean start = true;
		String name, hp, company;

		System.out.println("**************************************");
		System.out.println("*       전화번호 관리 프로그램       *");
		System.out.println("**************************************");

		// 제일 바깥쪽 리스트
		while (start) {
			System.out.println("");
			System.out.println("1.리스트 2.등록 3.수정 4.삭제 5.검색 6.종료");
			System.out.println("---------------------------------");
			System.out.print(">메뉴번호: ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				// 리스트
				System.out.println("<1.리스트>");
				pList = pDao.SelectAll();
				
				for(int i=0; i<pList.size(); i++) {
					PersonVo pvo = pList.get(i);
					System.out.println(pvo.getPerson_id() + ", " + pvo.getName() + ", " + pvo.getHp() + ", " + pvo.getCompany());
				}
				break;

			case 2:
				System.out.println("<2.등록>");
				System.out.print(">이름: ");
				name = sc.nextLine();

				System.out.print(">휴대전화: ");
				hp = sc.nextLine();

				System.out.print(">회사전화: ");
				company = sc.nextLine();
				
				PersonVo pvoIn = new PersonVo(name, hp, company);
				pDao.PersonInsert(pvoIn);

				break;

			case 3:
				System.out.println("<3.수정>");
				System.out.print(">번호 : ");
				int update_num = sc.nextInt();
				sc.nextLine();
				
				System.out.print(">이름: ");
				name = sc.nextLine();

				System.out.print(">휴대전화: ");
				hp = sc.nextLine();

				System.out.print(">회사전화: ");
				company = sc.nextLine();
				
				PersonVo pvoUp = new PersonVo(name, hp, company);
				pDao.PersonUpdate(update_num, pvoUp);

				break;

			case 4:
				System.out.println("<4.삭제>");
				System.out.print(">번호 : ");
				int remove_num = sc.nextInt();
				sc.nextLine();
				
				pDao.PersonDelete(remove_num);
				
				break;
				
			case 5:
				System.out.println("<5.검색>");
				System.out.print(">검색어 : ");
				String keyword = sc.nextLine();
				
				pList = pDao.Search(keyword);
				for(int i=0; i<pList.size(); i++) {
					PersonVo pvo = pList.get(i);
					System.out.println(pvo.getPerson_id() + ", " + pvo.getName() + ", " + pvo.getHp() + ", " + pvo.getCompany());
				}				
				break;

			case 6:
				System.out.println("");
				System.out.println("*********************************");
				System.out.println("*            감사합니다            *");
				System.out.println("*********************************");
				start = false;
				break;

			default:
				System.out.println("[다시 입력해 주세요.]");
				break;

			}

		}
		sc.close();

	}
}
