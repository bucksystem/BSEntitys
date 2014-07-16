package br.com.bucksystem.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Grupos database table.
 * 
 */
@Entity
@Table(name="Grupos")
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="GRUP_ChpGrupo")
	private int idgrupo;

	@Column(name="GRUP_ChaGrupo")
	private String grupo;

	@Version
	private Timestamp versao;

	//bi-directional many-to-one association to Modulo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GRUP_ChpModulo")
	private Modulo modulo;

	public Grupo() {
	}

	public int getIdgrupo() {
		return this.idgrupo;
	}

	public void setIdgrupo(int idgrupo) {
		this.idgrupo = idgrupo;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Timestamp getVersao() {
		return this.versao;
	}

	public void setVersao(Timestamp versao) {
		this.versao = versao;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

}