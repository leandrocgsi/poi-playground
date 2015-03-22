package br.com.semeru.poi.structure;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class SheetStructure {
	public LinkedHashMap<String, String> headerColumns = new LinkedHashMap<String, String>();
	public List<? extends Object> source = new ArrayList<Object>();
	public String tabLabel = "";
}