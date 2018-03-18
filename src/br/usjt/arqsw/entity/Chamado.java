package br.usjt.arqsw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Chamado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull(message="O id não pode estar vazio")
	@Min(value=1, message="O id não pode ser nulo")
	private int id_chamado;
	@NotNull
	private String descricao, status; 
	private Date dataAbertura, dataFechamento;
	private Fila fila;
	public int getId_chamado() {
		return id_chamado;
	}
	public void setId_chamado(int id_chamado) {
		this.id_chamado = id_chamado;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Fila getFila() {
		return fila;
	}
	public void setFila(Fila fila) {
		this.fila = fila;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	@Override
	public String toString() {
		return "Chamado [id= " + id_chamado +", nome= " + descricao +", status= " + status + "]";
	}
	
}
