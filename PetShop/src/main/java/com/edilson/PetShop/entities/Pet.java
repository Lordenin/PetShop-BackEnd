package com.edilson.PetShop.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomePet;
	
	private String nomeTutor;
	
	private String procedimento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date agendamento;

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pet(Long id, String nomePet, String nomeTutor, String procedimento, Date agendamento) {
		super();
		this.id = id;
		this.nomePet = nomePet;
		this.nomeTutor = nomeTutor;
		this.procedimento = procedimento;
		this.agendamento = agendamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePet() {
		return nomePet;
	}

	public void setNomePet(String nomePet) {
		this.nomePet = nomePet;
	}

	public String getNomeTutor() {
		return nomeTutor;
	}

	public void setNomeTutor(String nomeTutor) {
		this.nomeTutor = nomeTutor;
	}

	public String getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(String procedimento) {
		this.procedimento = procedimento;
	}

	public Date getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Date agendamento) {
		this.agendamento = agendamento;
	}
	
	
	
	
}
