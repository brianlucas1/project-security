package app.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.PlanilhaBasePG;
import app.model.PlanilhaCTENF;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


@RestController
@RequestMapping("/api")
public class GeradorDePlanilha {

	
	public static void main(String[] args) {
		
		List<PlanilhaCTENF> a =  Arrays.asList(
				new PlanilhaCTENF("1","teste"),
				new PlanilhaCTENF("2","teste"),
				new PlanilhaCTENF("3","teste"),
				new PlanilhaCTENF("5","teste"));
		
		List<PlanilhaBasePG> b = Arrays.asList(
				new PlanilhaBasePG("1","teste"),
				new PlanilhaBasePG("2","teste"),
				new PlanilhaBasePG("3","teste"));
		
		
	}
	
	@GetMapping()
	public void gerarPlanilha() throws BiffException, IOException {
			
		List<PlanilhaCTENF> planilhaCTEList =  processaPlanilhaCTE();
		
		List<PlanilhaBasePG> planilhaPgList = processarListaPg();				
		

		  
			 List<PlanilhaCTENF> result = planilhaCTEList
					 .stream()
					 .filter(a1 -> {
						 return planilhaPgList.stream()
								 .noneMatch(b1 -> a1.getCte().equals(b1.getReferencia())
										 && a1.getData().equals(b1.getDataDocumento()));

								 
					 }).collect(Collectors.toList());    
		
			System.out.println(result);
			 
		}
		

	private List<PlanilhaBasePG> processarListaPg() throws BiffException, IOException {
		
		List<PlanilhaBasePG> planilhaPgList = new ArrayList<PlanilhaBasePG>();
		
		String caminho = "C:/Users/Usuário Qintess/Desktop/Nova pasta (2)/BASE PG GMB.xls";   						

		File arquivoProcessado = new File(caminho);			
		
		Workbook w1 = Workbook.getWorkbook(arquivoProcessado);
	
		Sheet planilha = w1.getSheet(0);			
			
			for (int j = 0; j < planilha.getRows(); j++) {
				
				PlanilhaBasePG pg = new PlanilhaBasePG();
			
				Cell[] cell = planilha.getRow(j);				
			
				if(cell[0].getContents() != null && cell[0].getContents() != "") {	
					pg.setReferencia(cell[0].getContents().toString().trim());
					pg.setDataDocumento(cell[0].getContents().toString().trim());
					planilhaPgList.add(pg);
				}
			}		
		
		return planilhaPgList;
	}


	private List<PlanilhaCTENF> processaPlanilhaCTE() throws BiffException, IOException {		
	
		List<PlanilhaCTENF> planilhaCTEList = new ArrayList<PlanilhaCTENF>();
		
		String caminho = "C:/Users/Usuário Qintess/Desktop/Nova pasta (2)/CTENF.xls";   						

		File arquivoProcessado = new File(caminho);			
		
		Workbook w1 = Workbook.getWorkbook(arquivoProcessado);
	
		Sheet planilha = w1.getSheet(0);			
			
			for (int j = 1; j < planilha.getRows(); j++) {
				
				PlanilhaCTENF planilhaCTE = new PlanilhaCTENF();
			
				Cell[] cell = planilha.getRow(j);				
			
				if(cell[0].getContents() != null && cell[0].getContents() != "") {	
					planilhaCTE.setCte(cell[0].getContents().toString().trim());
					planilhaCTE.setData(cell[1].getContents().toString().trim());
					planilhaCTEList.add(planilhaCTE);
				}
			}
		
		
		return planilhaCTEList;
	}
}
