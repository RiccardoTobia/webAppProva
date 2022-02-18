package com.zefiro.provaMaven.model;

public class Libro {
	private int id;
	private String titolo;
	private String autore;
	private String genere;
	private String anno;
	private int pagine;
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	public int getPagine() {
		return pagine;
	}
	public void setPagine(int pagine) {
		this.pagine = pagine;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Libro [id= " + id + ", titolo= " + titolo +", autore= " + autore + "]";
 	}
	
	
	
}
