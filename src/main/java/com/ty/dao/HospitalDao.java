
package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.ArrayList;

import com.ty.dto.Address;
import com.ty.dto.Branch;
import com.ty.dto.Encounter;
import com.ty.dto.Hospital;
import com.ty.dto.Item;
import com.ty.dto.MedOraders;
import com.ty.dto.Person;

public class HospitalDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveHospitalDeatils(Hospital hospital) {
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
	}

	public void UpdateHospital(Hospital hospital) {
		entityTransaction.begin();
		entityManager.merge(hospital);
		entityTransaction.commit();
	}

	public Hospital findHospitalById(int id) {
		return entityManager.find(Hospital.class, id);
	}

	public void saveBranch(List<Branch> branch) {
		Hospital hospital = entityManager.find(Hospital.class, 1);
		if (hospital != null) {
			entityTransaction.begin();
			for (Branch ele : branch) {
				entityManager.persist(ele);
				ele.setHospital(hospital);
			}
			hospital.setBranch(branch);
			entityTransaction.commit();
		} else {
			System.out.println("hospital doesnot exist");
		}
	}

	public void UpdateBranch(Branch branch) {
		entityTransaction.begin();
		entityManager.merge(branch);
		entityTransaction.commit();
	}

	public void saveAddress(Address address, Address address2, Address address3) {
		Branch branch = entityManager.find(Branch.class, 2);
		if (branch != null) {
			entityTransaction.begin();
			entityManager.persist(address);
			branch.setAddress(address);
			entityTransaction.commit();
		}
		Branch branch2 = entityManager.find(Branch.class, 3);
		if (branch2 != null) {
			entityTransaction.begin();
			entityManager.persist(address2);
			branch2.setAddress(address2);
			entityTransaction.commit();
		}
		Branch branch3 = entityManager.find(Branch.class, 4);
		if (branch3 != null) {
			entityTransaction.begin();
			entityManager.persist(address3);
			branch3.setAddress(address3);
			entityTransaction.commit();
		}
	}

	public void UpdateAddress(Address address) {
		entityTransaction.begin();
		entityManager.merge(address);
		entityTransaction.commit();
	}

	public Address findAddressById(int id) {
		return entityManager.find(Address.class, id);
	}

	public void saveEncounter(Encounter encounter) {
		entityTransaction.begin();
		entityManager.persist(encounter);
		entityTransaction.commit();

	}

	public void UpdateEncounter(Encounter encounter) {
		entityTransaction.begin();
		entityManager.merge(encounter);
		entityTransaction.commit();
	}

	public Encounter findEncounterById(int id) {
		return entityManager.find(Encounter.class, id);
	}

	public Branch findById(int id) {
		return entityManager.find(Branch.class, id);
	}

	public void savePerson(Person person) {
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public Person findPersonById(int id) {
		return entityManager.find(Person.class, id);
	}

	public void UpdatePerson(Person person) {
		entityTransaction.begin();
		entityManager.merge(person);
		entityTransaction.commit();
	}

	public void saveMedOrder(List<MedOraders> medorders) {
		entityTransaction.begin();
		for (MedOraders ele : medorders) {
			entityManager.persist(ele);
		}
		entityTransaction.commit();
	}

	public void updateMedOrders(MedOraders medorder) {
		entityTransaction.begin();
		entityManager.merge(medorder);
		entityTransaction.commit();
	}

	public MedOraders findMedOrderById(int id) {
		return entityManager.find(MedOraders.class, id);
	}

	public void saveItem(Item item) {
		entityTransaction.begin();
		entityManager.persist(item);
		entityTransaction.commit();
	}

//	public void displayMedOrders() {
//		Query q = entityManager.createQuery("select m from MedOraders m");
//		List<MedOraders> li = q.getResultList();
//		for (MedOraders medOraders : li) {
//			System.out.println(medOraders.getId());
//			System.out.println(medOraders.getPrice());
//			System.out.println(medOraders.getEncounter().getD_name());
//			System.out.println(medOraders.getEncounter().getE_id());
//			System.out.println(medOraders.getEncounter().getBranch().getB_id());
//
//		}

	public void deleteBranch(Branch branch) {
		entityTransaction.begin();
		entityManager.remove(branch);
		entityTransaction.commit();

	}

	public void deleteEncounter(Encounter encounter) {
		entityTransaction.begin();
		entityManager.remove(encounter);
		entityTransaction.commit();

	}

	public void addItem(List<Item> item) {
		entityTransaction.begin();
		for (Item item2 : item) {
			entityManager.persist(item2);
		}
		entityTransaction.commit();
	}

	public Item findItemById(int id) {
		return entityManager.find(Item.class, id);
	}

	public void updateItem(Item item) {
		entityTransaction.begin();
		entityManager.merge(item);
		entityTransaction.commit();
	}

	public void updateMedOrder(MedOraders medOrader) {
		entityTransaction.begin();
//		for (Item item : medOrader.getItem()) {
//			entityManager.merge(item);
//		}
		entityManager.merge(medOrader);
		entityTransaction.commit();

	}

}
