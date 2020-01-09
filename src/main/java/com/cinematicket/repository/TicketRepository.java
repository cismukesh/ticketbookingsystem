package com.cinematicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinematicket.entities.Ticket;

/**
 * @author cis
 */

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
