package br.com.bradseg.pocc.poccobol.funcao.cics;

import br.com.bradseg.bsad.framework.ctg.programapi.annotation.CicsGateway;
import br.com.bradseg.bsad.framework.ctg.programapi.field.FieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.StringFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.program.CommonAreaMetaData;
import br.com.bradseg.bsad.framework.ctg.programapi.program.InputSet;
import br.com.bradseg.bsad.framework.ctg.programapi.program.ResultSet;

@CicsGateway
public class NASA0000F10 extends NASAHEADER{

	public static final String PROG_NAME = "NASA000";
	public static final String TRAN_NAME = "NA00";
	
	private static final CommonAreaMetaData COMMON_AREA = new CommonAreaMetaData(
			HEADER,
			new FieldType[] {
					new StringFieldType("AREA",650)
			}
			);


	/**
	 * Construtor
	 * @param pPgmName
	 * @param pTranName
	 * @param pCommonAreoraSize
	 * @param pInputCommonAreaMetaData
	 * @param pOutputCommonAreaMetaData
	 */
	public NASA0000F10() {
		super(PROG_NAME, TRAN_NAME, COMMON_AREA.getStreamSize(), COMMON_AREA, COMMON_AREA);
	}

	public void executaCics() {
		InputSet is = this.getInputSet();
		NASAHEADER.setHeader(is, "Header", 10);
		setaDados(is, "    0000   ");
		ResultSet rs = this.execute();
		System.out.println(obtemDados(rs));
	}
	
	private void setaDados(InputSet is, String dados) {
		is.setString("AREA", dados);
	}
	
	private String obtemDados(ResultSet rs) {
		return rs.getString("AREA");
	}
}
