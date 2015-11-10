package br.com.bradseg.pocc.poccobol.funcao.cics;

import br.com.bradseg.bsad.framework.ctg.programapi.annotation.CicsGateway;
import br.com.bradseg.bsad.framework.ctg.programapi.field.Comp3FieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.CompFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.FieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.IntegerFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.field.StringFieldType;
import br.com.bradseg.bsad.framework.ctg.programapi.program.CTGProgramImpl;
import br.com.bradseg.bsad.framework.ctg.programapi.program.CommonAreaMetaData;
import br.com.bradseg.bsad.framework.ctg.programapi.program.InputSet;
import br.com.bradseg.bsad.framework.ctg.programapi.program.ResultSet;

@CicsGateway
public class CRMS0920 extends CTGProgramImpl{
	private static final String PROGRAM_NAME = "CRMS0920";
	private static final String TRANSACTION_NAME = "CP00";
	private static final String EMARCA_INICIO = "EMARCA-INICIO";            
	private static final String ECPO_DISPLAY = "ECPO-DISPLAY";                          
	private static final String FIL01 = "FIL01";
	private static final String ECPO_COMP = "ECPO-COMP";                     
	private static final String FIL02 = "FIL02";                
	private static final String ECPO_COMP_3 = "ECPO-COMP-3";                   
	private static final String SMARCA_INICIO = "SMARCA-INICIO";            
	private static final String SCPO_DISPLAY = "SCPO-DISPLAY";                          
	private static final String FIL03 = "FIL03";                
	private static final String SCPO_COMP = "SCPO-COMP";                     
	private static final String FIL04 = "FIL04";                
	private static final String SCPO_COMP_3 = "SCPO-COMP-3";                   
	private static final String FIL05 = "FIL05";                
	private static final String SMENSAGEM = "SMENSAGEM";                         
	private static final String SMARCA_FIM = "SMARCA-FIM"; 
	
	private static final CommonAreaMetaData COMMON_AREA = new CommonAreaMetaData(
			new FieldType[] {
//					 000039        01  CRMS-AREA-COMUNICACAO.                                       
//					 000040            03  ENTRADA.                                                 
//					 000041                05  EMARCA-INICIO    PIC X(5)  VALUE '*ENT*'.
					new StringFieldType(EMARCA_INICIO,5),
//					 000042                05  ECPO-DISPLAY     PIC 9(04).          
					new IntegerFieldType(ECPO_DISPLAY, 4),
//					 000043                05  FIL01            PIC X     VALUE '*'.
					new StringFieldType(FIL01, 1),
//					 000044                05  ECPO-COMP        PIC S9(4) COMP.    
					new CompFieldType(ECPO_COMP, 2),
//					 000045                05  FIL02            PIC X     VALUE '*'.     
					new StringFieldType(FIL02, 1),
//					 000046                05  ECPO-COMP-3      PIC S9(5) COMP-3.       
					new Comp3FieldType(ECPO_COMP_3, 4),
//					 000047            03  SAIDA.                                                   
//					 000048                05  SMARCA-INICIO    PIC X(5)  VALUE '*SAI*'.
					new StringFieldType(SMARCA_INICIO,5),
//					 000049                05  SCPO-DISPLAY     PIC 9(04).                  
					new IntegerFieldType(SCPO_DISPLAY, 4),
//					 000050                05  FIL03            PIC X     VALUE '*'.
					new StringFieldType(FIL03, 1),
//					 000051                05  SCPO-COMP        PIC S9(4) COMP.
					new CompFieldType(SCPO_COMP, 2),
//					 000052                05  FIL04            PIC X     VALUE '*'.
					new StringFieldType(FIL04, 1),
//					 000053                05  SCPO-COMP-3      PIC S9(5) COMP-3.
					new Comp3FieldType(SCPO_COMP_3, 4),
//					 000054                05  FIL05            PIC X     VALUE '*'.
					new StringFieldType(FIL05,1),
//					 000055                05  SMENSAGEM        PIC X(50) .          
					new StringFieldType(SMENSAGEM, 50),
//					 000056                05  SMARCA-FIM       PIC X(5)  VALUE '*FIM*'.
					new StringFieldType(SMARCA_FIM,5)
				}
			);

	public CRMS0920() {
		super(PROGRAM_NAME, TRANSACTION_NAME, COMMON_AREA.getStreamSize(), COMMON_AREA, COMMON_AREA);
	}

	private void setEntrada(Integer valor) {
		InputSet is = this.getInputSet();
		is.setString(EMARCA_INICIO,"*ENT*");
		is.setInteger(ECPO_DISPLAY, valor);
		is.setString(FIL01, "*");
		is.setInteger(ECPO_COMP, valor);
		is.setString(FIL02 , "*");
		is.setDouble(ECPO_COMP_3, Double.valueOf(valor.toString()));
		is.setString(SMARCA_INICIO, "*SAI*");
		is.setString(FIL03,"*");
		is.setString(FIL04,"*");
		is.setString(FIL05,"*");
		is.setString(SMARCA_FIM,"*FIM*");
	}
	
	private String getSaida(ResultSet rs) {
		StringBuffer sb = new StringBuffer();
		sb.append(SCPO_DISPLAY);
		sb.append('=');
		sb.append(rs.getInteger(SCPO_DISPLAY));
		sb.append("   ");
		sb.append(SCPO_COMP);
		sb.append('=');
		sb.append(rs.getInteger(SCPO_COMP));
		sb.append("   ");
		sb.append(SCPO_COMP_3);
		sb.append('=');
		sb.append(rs.getDouble(SCPO_COMP_3));
		sb.append("   ");
		sb.append(SMENSAGEM);
		sb.append('=');
		sb.append(rs.getString(SMENSAGEM));
		return sb.toString();
	}
	
	public String executaCics(Integer valor) {
		setEntrada(valor);
		ResultSet rs = this.execute();
		return getSaida(rs);
	}
}
