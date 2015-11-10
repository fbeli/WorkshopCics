package br.com.bradseg.pocc.poccobol.funcao.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bradseg.pocc.poccobol.funcao.facade.InicioServiceFacade;
import br.com.bradseg.bsad.framework.core.exception.BusinessException;
import br.com.bradseg.bsad.framework.core.exception.IntegrationException;

/**
 * Documentação da classe que representa um WebService da funcionalidade
 * 
 * @author Bradesco Seguros
 */
@WebService
@Service
public class InicioWebService {

	@Autowired
	private InicioServiceFacade inicioService;

	/**
	 * Documentação do método
	 * 
	 * @param nome do argumento
	 * @return String
	 */
	@WebMethod
	public String consultarSaudacao(String nome) throws IntegrationException, BusinessException {
		// Sempre declarar no método as possíveis exceptions para que o CXF possa serializa-las no WSDL gerado.

		return inicioService.consultarSaudacao(nome);
	}

	@WebMethod(exclude = true)
	public void setInicioService(InicioServiceFacade obj) {
		this.inicioService = obj;
	}

}
