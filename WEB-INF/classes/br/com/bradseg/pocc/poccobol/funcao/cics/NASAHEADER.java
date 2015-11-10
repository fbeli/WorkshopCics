package br.com.bradseg.pocc.poccobol.funcao.cics;

import br.com.bradseg.bsad.framework.ctg.programapi.field.FieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.IntegerFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.StringFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.program.CTGProgramImpl;
import br.com.bradseg.bsad.framework.ctg.programapi.program.CommonAreaMetaData;
import br.com.bradseg.bsad.framework.ctg.programapi.program.InputSet;

public abstract class NASAHEADER extends CTGProgramImpl{
	public static final FieldType[] HEADER = new FieldType[] {
		new StringFieldType("HEADER",10),
		new IntegerFieldType("FUNCAO",2)
	};

	public NASAHEADER(String pPgmName, String pTranName, int pCommonAreaSize,
			CommonAreaMetaData pInputCommonAreaMetaData, CommonAreaMetaData pOutputCommonAreaMetaData) {
		super(pPgmName, pTranName, pCommonAreaSize, pInputCommonAreaMetaData, pOutputCommonAreaMetaData);
	}

	public static FieldType[] getNasaHeader() {
		return new FieldType[] {
				new StringFieldType("HEADER",10),
				new IntegerFieldType("FUNCAO",2)
			};
	}

	public static void setHeader(InputSet is, String header, Integer funcao) {
		is.setString("HEADER", header);
		is.setInteger("FUNCAO", funcao);
	}
}
