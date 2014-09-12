package br.com.bucksystem.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Modulos database table.
 * 
 */
@Entity
@Table(name="Modulos")
@NamedQuery(name="Modulo.findAll", query="SELECT m FROM Modulo m")
public class Modulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="MODU_ChpModulo")
	private int idmodulo;

	@Column(name="MODU_ChaModulo")
	private String modulox;

	@Column(name="MODU_OpbEstrutMensal")
	private byte estrutmensal;

	@Column(name="MODU_OpbSistemas")
	private byte sistemas;

	@Version
	private Timestamp versao;

	//bi-directional many-to-one association to Grupo
	@OneToMany(mappedBy="modulo")
	private List<Grupo> grupos;

	public Modulo() {
	}

	public int getIdmodulo() {
		return this.idmodulo;
	}

	public void setIdmodulo(int idmodulo) {
		this.idmodulo = idmodulo;
	}

	public String getModulox() {
		return this.modulox;
	}

	public void setModulox(String modulo) {
		this.modulox = modulo;
	}

	public byte getEstrutmensal() {
		return this.estrutmensal;
	}

	public void setEstrutmensal(byte estrutmensal) {
		this.estrutmensal = estrutmensal;
	}

	public byte getSistemas() {
		return this.sistemas;
	}

	public void setSistemas(byte sistemas) {
		this.sistemas = sistemas;
	}

	public Timestamp getVersao() {
		return this.versao;
	}

	public void setVersao(Timestamp versao) {
		this.versao = versao;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Grupo addGrupo(Grupo grupo) {
		getGrupos().add(grupo);
		grupo.setModulo(this);

		return grupo;
	}

	public Grupo removeGrupo(Grupo grupo) {
		getGrupos().remove(grupo);
		grupo.setModulo(null);

		return grupo;
	}

}