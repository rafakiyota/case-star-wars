package br.com.desafio.star.wars.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.desafio.star.wars.repository.entity.Busca;

public interface BuscaRepo extends JpaRepository<Busca, Long>{

	Optional<Busca> findByDominioAndTermo(String dominio, String termo);
	Page<Busca> findByDominio(String dominio, Pageable pageable);
	
	@Query("SELECT busca FROM Busca busca "
			+ "WHERE busca.dominio = ?1 "
			+ "AND busca.termo like %?2% ")
	Page<Busca> findByDominioLikeTermo(String dominio, String termo, Pageable pageable);
	
	@Query("SELECT busca FROM Busca busca "
			+ "WHERE busca.termo like %?1% ")
	Page<Busca> findByTermo(String termo, Pageable pageable);
}
