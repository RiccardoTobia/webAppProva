package com.zefiro.provaMaven.model;

public class Libro {
	private int id;
	private String titolo;
	private String autore;
	private String genere;
	private String anno;
	private int isLibroOrCd;
	private int quantita;
	
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

	public int getIsLibroOrCd() {
		return isLibroOrCd;
	}
	public void setIsLibroOrCd(int isLibroOrCd) {
		this.isLibroOrCd = isLibroOrCd;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Articolo: ");
		sb.append(getTitolo());
		sb.append(" by ");
		sb.append(getAutore());
		sb.append(". Quantità: ");
		sb.append(getQuantita());
		return sb.toString();
 	}
	
	
	
}
