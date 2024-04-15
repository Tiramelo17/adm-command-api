package com.adm.command.appService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.adm.command.Handler.BusinessException;
import com.adm.command.models.Produto;
import com.adm.command.rest.RestUtil;
import com.adm.command.utils.UtilEndPoints;

@Component
public class ProdutosFornecedorAppService {

		@Autowired
		RestUtil restUtil;
		
		
	
		public List<Produto> obterProdutosFornecedor() {
			try {
				return restUtil.getRestTemplate(UtilEndPoints.getFORNECEDORAPI(), Produto.class);
			} catch (Exception e) {
				e.printStackTrace();
				throw new BusinessException(e.getMessage());
			}
			
		}
}
