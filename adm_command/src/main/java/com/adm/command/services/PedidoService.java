package com.adm.command.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adm.command.Handler.BusinessException;
import com.adm.command.appService.PedidoAppService;
import com.adm.command.appService.UserAppService;
import com.adm.command.models.Pedido;
import com.adm.command.repositories.PedidoRepository;

import jakarta.transaction.Transactional;

@Component
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	
	
	
	@Transactional
	public Pedido createPedido(Pedido pedido) {
			return pedidoRepository.save(pedido);			
	}
	
	public Pedido findPedidoById(Integer id) {
		return pedidoRepository.findById(id).get();
	}
	
	public boolean findPedidoByNumMesa(int numMesa) {
		return pedidoRepository.findPedidoByNumMesaAndPedidoAtivo(numMesa) != null  ? true:false;
	}
}
