package com.ty.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty.dao.HospitalDao;
import com.ty.dto.Address;
import com.ty.dto.Branch;
import com.ty.dto.Encounter;
import com.ty.dto.Hospital;
import com.ty.dto.Item;
import com.ty.dto.MedOraders;
import com.ty.dto.Person;

public class HospitalDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HospitalDao hospitalDao = new HospitalDao();
		boolean flag = true;
		while (flag) {
			System.out.println("1.saveHospital");
			System.out.println("2.saveBranch");
			System.out.println("3.saveAddress");
			System.out.println("4.savePerson");
			System.out.println("5.encounter");
			System.out.println("6.Medorders");
			System.out.println("7.AddItem");
			System.out.println("8.deletebranch");
			System.out.println("9.deleteEncounter");
			System.out.println("10.updateHospital");
			System.out.println("11.updateBranch");
			System.out.println("12.updateEncounter");
			System.out.println("13.updateAddress");
			System.out.println("14.updatePerson");
			System.out.println("15.addexisted item medorders");
			System.out.println("16.exit");
			System.out.println("enter choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				Hospital hospital = new Hospital();
				hospital.setName("Brundavan");
				hospital.setPhono(9867564759l);
				hospitalDao.saveHospitalDeatils(hospital);
				break;
			case 2:
				Branch branch1 = new Branch();
				branch1.setPhono(9894873327l);

				Branch branch2 = new Branch();
				branch2.setPhono(98997975997l);

				Branch branch3 = new Branch();
				branch3.setPhono(868674693143l);

				List<Branch> branch = new ArrayList<Branch>();
				branch.add(branch1);
				branch.add(branch2);
				branch.add(branch3);
				hospitalDao.saveBranch(branch);
				break;
			case 3:
				Address address = new Address();
				address.setAddress("basavanagudi");

				Address address2 = new Address();
				address2.setAddress("jaynagar");

				Address address3 = new Address();
				address3.setAddress("marathahalli");

				hospitalDao.saveAddress(address, address2, address3);
				break;
			case 4:
				Person person = new Person();
				System.out.println("your name please");
				String P_name = sc.next();
				person.setName(P_name);
				hospitalDao.savePerson(person);
				break;
			case 5:
				System.out.println("1.branch-basavanagudi");
				System.out.println("2.branch-Jaynagar");
				System.out.println("3.branch-marathahalli");
				System.out.println("enter your choice");
				int choice1 = sc.nextInt();
				switch (choice1) {
				case 1:
					Branch branch_1 = hospitalDao.findById(2);
					System.out.println("enter person id");
					int id = sc.nextInt();
					Person person1 = hospitalDao.findPersonById(id);
					if (branch_1 != null && person1 != null) {
						System.out.println("how many encounters");
						int count = sc.nextInt();
						List<Encounter> encounter_1 = null;
						Encounter encounter = new Encounter();
						for (int i = 1; i <= count; i++) {
							System.out.println("disease found please?");
							String name = sc.next();
							encounter.setD_name(name);
							encounter.setBranch(branch_1);
							encounter.setPerson(person1);
							hospitalDao.saveEncounter(encounter);

							encounter_1 = new ArrayList<Encounter>();
							encounter_1.add(encounter);
						}

						branch_1.setEncounter(encounter_1);
						person1.setEncounter(encounter_1);
						hospitalDao.saveEncounter(encounter);
					} else {
						System.out.println("choose other options");
					}
					break;
				case 2:
					Branch branch_2 = hospitalDao.findById(3);
					System.out.println("enter person id");
					int id1 = sc.nextInt();
					Person person2 = hospitalDao.findPersonById(id1);
					if (branch_2 != null && person2 != null) {
						System.out.println("how many encounters");
						int count = sc.nextInt();
						List<Encounter> encounter_1 = null;
						Encounter encounter = new Encounter();
						for (int i = 1; i <= count; i++) {
							System.out.println("disease found please?");
							String name = sc.next();
							encounter.setD_name(name);
							encounter.setBranch(branch_2);
							encounter.setPerson(person2);
							hospitalDao.saveEncounter(encounter);

							encounter_1 = new ArrayList<Encounter>();
							encounter_1.add(encounter);
						}

						branch_2.setEncounter(encounter_1);
						person2.setEncounter(encounter_1);
						hospitalDao.saveEncounter(encounter);

					} else {
						System.out.println("choose other options");
					}
					break;
				case 3:
					Branch branch_3 = hospitalDao.findById(4);
					System.out.println("enter person id");
					int id3 = sc.nextInt();
					Person person3 = hospitalDao.findPersonById(id3);
					if (branch_3 != null && person3 != null) {
						System.out.println("how many encounters");
						int count = sc.nextInt();
						List<Encounter> encounter_1 = null;
						Encounter encounter = new Encounter();
						for (int i = 1; i <= count; i++) {
							System.out.println("disease found please?");
							String name = sc.next();
							encounter.setD_name(name);
							encounter.setBranch(branch_3);
							encounter.setPerson(person3);
							hospitalDao.saveEncounter(encounter);

							encounter_1 = new ArrayList<Encounter>();
							encounter_1.add(encounter);
						}

						branch_3.setEncounter(encounter_1);
						person3.setEncounter(encounter_1);
						hospitalDao.saveEncounter(encounter);
					} else {
						System.out.println("choose other options");
					}
					break;
				}
				break;
			case 6:
				System.out.println("enter encounter id");
				int id = sc.nextInt();
				Encounter encounter = hospitalDao.findEncounterById(id);
				List<MedOraders> order = null;
				MedOraders medorders = new MedOraders();
				if (encounter != null) {
					List<MedOraders> medorder = null;
					if (encounter.getMedorders() == null) {
						medorder = new ArrayList();
					} else {
						medorder = encounter.getMedorders();
					}
					System.out.println("how many medorders");
					int count = sc.nextInt();
					for (int i = 1; i <= count; i++) {
						System.out.println("enter the quantity");
						int quantity = sc.nextInt();
						medorders.setQuantity(quantity);
						System.out.println("enter price");
						double price = sc.nextDouble();
						medorders.setPrice(price);
						medorders.setEncounter(encounter);

						// medorder = new ArrayList<MedOraders>();
						medorder.add(medorders);
					}

					hospitalDao.saveMedOrder(medorder);
					encounter.setMedorders(medorder);
					hospitalDao.UpdateEncounter(encounter);

				}
				break;

			case 7:
				System.out.println("enter medorder id");
				int id2 = sc.nextInt();
				MedOraders medorders1 = hospitalDao.findMedOrderById(id2);

				if (medorders1 != null) {
					List<Item> items = null;
					if (medorders1.getItem() == null) {
						items = new ArrayList<Item>();
					} else {
						items = medorders1.getItem();
					}
					for (int i = 1; i <= medorders1.getQuantity(); i++) {
						Item item = new Item();
						System.out.println("enter item name");
						String name = sc.next();
						item.setName(name);
						// item.setMedorder(medorders1);
						items.add(item);
						hospitalDao.saveItem(item);
					}
					medorders1.setItem(items);
					hospitalDao.updateMedOrders(medorders1);
					break;
				}

			case 8:
				System.out.println("enter branch id which has to be deleted");
				int id4 = sc.nextInt();
				Branch branch5 = hospitalDao.findById(id4);

				hospital = branch5.getHospital();
				List<Branch> branchs = new ArrayList<Branch>();
				for (Branch b : hospital.getBranch()) {
					if (!(b.getB_id() == branch5.getB_id())) {
						branchs.add(b);
					}
				}
				hospital.setBranch(branchs);
				branch5.setHospital(null);
				branch5.setAddress(null);
				List<Encounter> en = branch5.getEncounter();
				for (Encounter encounter2 : en) {
					encounter2.setBranch(null);
				}
				hospitalDao.UpdateHospital(hospital);
				hospitalDao.UpdateBranch(branch5);
				hospitalDao.deleteBranch(branch5);

				break;
			case 9:
				System.out.println("enter id of the encounter");
				int id1 = sc.nextInt();
				Encounter encounter2 = hospitalDao.findEncounterById(id1);
				if (encounter2 != null) {
					List<MedOraders> medorders2 = encounter2.getMedorders();
					for (MedOraders ele : medorders2) {
						ele.setEncounter(null);
					}
					encounter2.setBranch(null);
					encounter2.setPerson(null);
					hospitalDao.UpdateEncounter(encounter2);
					hospitalDao.deleteEncounter(encounter2);

				}
				break;
			case 10:
				System.out.println("enter id of the hospital");
				int id3 = sc.nextInt();
				Hospital hospital2 = hospitalDao.findHospitalById(id3);
				if (hospital2 != null) {
					System.out.println("1.update address");
					System.out.println("enter the choice");
					int choice5 = sc.nextInt();
					switch (choice5) {
					case 1:
						System.out.println("enter new name");
						String newAddress = sc.next();
						hospital2.setName(newAddress);
						hospitalDao.UpdateHospital(hospital2);
						break;
					}
				}
				break;
			case 11:
				System.out.println("enter branch id");
				int id5 = sc.nextInt();
				Branch branch6 = hospitalDao.findById(id5);
				if (branch6 != null) {
					System.out.println("1.update phono");
					System.out.println("enter choice");
					int choice6 = sc.nextInt();
					switch (choice6) {
					case 1:
						System.out.println("enter new number");
						long num = sc.nextLong();
						branch6.setPhono(num);
						hospitalDao.UpdateBranch(branch6);
						break;
					}
				}
				break;
			case 12:
				System.out.println("enter the encounter id");
				int id7 = sc.nextInt();
				Encounter encounter3 = hospitalDao.findEncounterById(id7);
				if (encounter3 != null) {
					System.out.println("enter updated diseas name");
					String name2 = sc.next();
					encounter3.setD_name(name2);
					hospitalDao.UpdateEncounter(encounter3);
				} else {
					System.out.println("no encounter exisit");
				}
				break;

			case 13:
				System.out.println("enter id of an address");
				int id8 = sc.nextInt();
				Address address4 = hospitalDao.findAddressById(id8);
				if (address4 != null) {
					System.out.println("enter new address");
					String newAddr = sc.next();
					address4.setAddress(newAddr);
					hospitalDao.UpdateAddress(address4);
				}
				break;
			case 14:
				System.out.println("enter id of a person");
				int id9 = sc.nextInt();
				Person person3 = hospitalDao.findPersonById(id9);
				if (person3 != null) {
					System.out.println("enter the new name");
					String name = sc.next();
					person3.setName(name);
					hospitalDao.UpdatePerson(person3);
				} else {
					System.out.println("no person found");
				}
				break;
			case 15:
				addItemToMedOrder(sc, hospitalDao);
				/*
				 * System.out.println("enter medorder id"); int id11 = sc.nextInt(); MedOraders
				 * medorders6 = hospitalDao.findMedOrderById(id11);
				 * System.out.println("enter item id"); int id12 = sc.nextInt(); Item item =
				 * hospitalDao.findItemById(id12); List<Item> list = medorders6.getItem(); if
				 * (medorders6 != null && item != null) { list.add(item); } List<MedOraders> med
				 * = item.getMedorder(); medorders6.setItem(list); item.setMedorder(med);
				 * 
				 * for (Item item1 : list) { hospitalDao.updateItem(item1); }
				 * 
				 * for (MedOraders med3 : med) { hospitalDao.updateMedOrders(med3); }
				 */
				break;
			case 16:
				flag = false;
				break;
			}

		}

	}

	private static void addItemToMedOrder(Scanner read, HospitalDao dao) {
		System.out.println("Enter the MedOrder Id:");
		int medId = read.nextInt();
		System.out.println("Enter the Item Id:");
		int itemId = read.nextInt();

		Item item = dao.findItemById(itemId);
		MedOraders medOrader = dao.findMedOrderById(medId);
		if (medOrader != null && item != null) {
			List<Item> items = (medOrader.getItem() == null) ? new ArrayList<Item>() : medOrader.getItem();
			List<MedOraders> medOraders = item.getMedorder() == null ? new ArrayList<MedOraders>() : item.getMedorder();

			items.add(item);
			medOraders.add(medOrader);
			dao.updateMedOrder(medOrader);
		} else {
			System.out.println("Item = " + itemId + " MedOrder " + medId + " Not Existes");
		}

	}
}
