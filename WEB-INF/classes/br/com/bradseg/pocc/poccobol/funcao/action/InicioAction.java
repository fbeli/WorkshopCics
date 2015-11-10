package br.com.bradseg.pocc.poccobol.funcao.action;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.bradseg.pocc.poccobol.funcao.facade.InicioServiceFacade;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Documenta��o da action
 * 
 * @author Bradesco Seguros
 */
@Controller
@Scope("request")
public class InicioAction extends ActionSupport {

	private static final long serialVersionUID = -1161409943678292285L;

	private String nome;

	@Autowired
	private transient InicioServiceFacade inicioServiceFacade;

	/**
	 * Documenta��o do m�todo
	 */
	public String inicio() {
		addActionMessage(getText("msg.sucesso.saudacao.inicio"));
		return SUCCESS;
	}

	/**
	 * Documenta��o do m�todo
	 * @return String
	 */
	public String consultarSaudacao() {
		if (StringUtils.isBlank(nome)) {
                    addActionError(getText("msg.erro.campo.obrigatorio", new String[] { "nome" }));
                    return INPUT;
		}
		String saudacao = inicioServiceFacade.consultarSaudacao(nome);
		addActionMessage(getText("msg.sucesso.saudacao.mensagem", new String[] { saudacao }));
		return SUCCESS;
	}

	/**
	 * Getter
	 * 
	 * @return String
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Setter
	 * 
	 * @param nome do argumento
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setInicioServiceFacade(InicioServiceFacade obj) {
		this.inicioServiceFacade = obj;
	}

}

