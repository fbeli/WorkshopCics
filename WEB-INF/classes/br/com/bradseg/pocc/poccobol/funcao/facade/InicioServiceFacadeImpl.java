package br.com.bradseg.pocc.poccobol.funcao.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.bradseg.bsad.framework.ctg.programapi.program.CTGProgramProvider;
import br.com.bradseg.pocc.poccobol.funcao.cics.CRMS0920;

/**
 * Descrição do serviço
 * 
 * @author Bradesco Seguros
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class InicioServiceFacadeImpl implements InicioServiceFacade {

	@Autowired
	private CTGProgramProvider ctgProgramProvider;

	/*
	 * (non-Javadoc)
	 */
	public String consultarSaudacao(String saudacao) {

		CRMS0920 program = ctgProgramProvider.get(CRMS0920.class);
		return program.executaCics(Integer.valueOf(saudacao));
	}

	/**
	 * @param ctgProgramProvider o ctgProgramProvider a ser configurado
	 */
	public void setCtgProgramProvider(CTGProgramProvider ctgProgramProvider) {
		this.ctgProgramProvider = ctgProgramProvider;
	}


	
}
