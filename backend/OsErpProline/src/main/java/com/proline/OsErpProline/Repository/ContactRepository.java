package com.proline.OsErpProline.Repository;

import com.proline.OsErpProline.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
