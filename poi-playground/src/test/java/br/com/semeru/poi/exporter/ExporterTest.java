package br.com.semeru.poi.exporter;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.semeru.poi.file.utils.IOUtils;
import br.com.semeru.poi.mocks.database.FakeData;
import br.com.semeru.poi.structure.DocumentStructure;
import br.com.semeru.poi.structure.SheetStructure;

public class ExporterTest {

	PoiExporter exporter = new PoiExporter(); 
    FakeData fakeData = new FakeData();
    IOUtils ioUtils = new IOUtils(); 
    DocumentStructure documentStructure = new DocumentStructure();
		
	@Before
	public void setup() {
		documentStructure = mockDocumentStructure();	
	}

	@Test
	public void exportTestWithDocumentStructure() {
		ByteArrayOutputStream byteArrayOutputStream = exporter.export(documentStructure);
        ioUtils.fileWriter(byteArrayOutputStream.toByteArray(), System.getProperty("user.dir") + "\\target\\", "MyFirstXLSXWithPOIAndDocumentStructure.xlsx");
	}
	
	private LinkedHashMap<String, String> getHeaderColumns(){
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("idPerson", "PERSON ID");
		map.put("name", "NAME");
		map.put("age", "AGE");
		map.put("gender", "GENDER");
		map.put("rgNumber", "RG NUMBER");
		map.put("cpfNumber", "CPF NUMBER");
		map.put("birthDate", "BIRTH DATE");
		map.put("address", "ADDRESS");
		map.put("phoneNumber1", "PHONE NUMBER 1");
		map.put("phoneNumber2", "PHONE NUMBER 2");
		map.put("religion", "RELIGION");
		map.put("contact", "CONTACT");
		map.put("father", "FATHER");
		map.put("mother", "MOTHER");
		map.put("birthCity", "BIRTH CITY");
		map.put("workPlace", "WORKPLACE");
		map.put("salary", "SALARY");
		return map;
	}
	
	private DocumentStructure mockDocumentStructure() {
		documentStructure.sheetStructures = mockSheetStructures();
		return documentStructure;
	}

	private List<SheetStructure> mockSheetStructures() {
		List<SheetStructure> sheetStructures = new ArrayList<SheetStructure>();
		SheetStructure sheetStructure1 = new SheetStructure();
		sheetStructure1.headerColumns = getHeaderColumns();
		sheetStructure1.source = fakeData.mockPersonsList();
		sheetStructure1.tabLabel = "PERSONS TAB 1";	
		
		sheetStructures.add(sheetStructure1);
		
		SheetStructure sheetStructure2 = new SheetStructure();
		sheetStructure2.headerColumns = getHeaderColumns();
		sheetStructure2.source = fakeData.mockPersonsList();
		sheetStructure2.tabLabel = "PERSONS TAB 2";		
		
		sheetStructures.add(sheetStructure2);
		
		SheetStructure sheetStructure3 = new SheetStructure();
		sheetStructure3.headerColumns = getHeaderColumns();
		sheetStructure3.source = fakeData.mockPersonsList();
		sheetStructure3.tabLabel = "PERSONS TAB 3";		
		
		sheetStructures.add(sheetStructure3);
		
		SheetStructure sheetStructure4 = new SheetStructure();
		sheetStructure4.headerColumns = getHeaderColumns();
		sheetStructure4.source = fakeData.mockPersonsList();
		sheetStructure4.tabLabel = "PERSONS TAB 4";		
		
		sheetStructures.add(sheetStructure4);
		
		SheetStructure sheetStructure5 = new SheetStructure();
		sheetStructure5.headerColumns = getHeaderColumns();
		sheetStructure5.source = fakeData.mockPersonsList();
		sheetStructure5.tabLabel = "PERSONS TAB 5";		
		
		sheetStructures.add(sheetStructure5);		
		
		return sheetStructures;
	}	
}
