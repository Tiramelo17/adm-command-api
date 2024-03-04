package com.adm.command.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adm.command.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	@Query("Select p from Pedido p where p.numMesa = :numMesa and p.pedidoAtivo = true")
	Pedido findPedidoByNumMesaAndPedidoAtivo(@Param("numMesa") int numMesa);
}
