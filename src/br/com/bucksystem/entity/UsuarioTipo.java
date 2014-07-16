package br.com.bucksystem.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;


/**
 * The persistent class for the UsuariosTipos database table.
 * 
 */
@Entity
@Table(name="UsuariosTipos")
@NamedQuery(name="UsuariosTipos.findAll", query="SELECT u FROM UsuarioTipo u")
public class UsuarioTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="USUT_ChpUsuarioTipo")
	private short idusuariotipo;

	@Column(name="USUT_ChaUsuarioTipo")
	private String usuariotipo;

	@Column(name="USUT_OpbMaster")
	private byte master;

	@Version
	private Timestamp versao;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="usuariosTipo")
	private List<Usuario> usuarios;

	public UsuarioTipo() {
	}

	public short getIdusuariotipo() {
		return this.idusuariotipo;
	}

	public void setIdusuariotipo(short idusuariotipo) {
		this.idusuariotipo = idusuariotipo;
	}

	public String getUsuariotipo() {
		return this.usuariotipo;
	}

	public void setUsuariotipo(String usuariotipo) {
		this.usuariotipo = usuariotipo;
	}

	public byte getMaster() {
		return this.master;
	}

	public void setMaster(byte master) {
		this.master = master;
	}

	public Timestamp getVersao() {
		return this.versao;
	}

	public void setVersao(Timestamp versao) {
		this.versao = versao;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setUsuariosTipo(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setUsuariosTipo(null);

		return usuario;
	}

}