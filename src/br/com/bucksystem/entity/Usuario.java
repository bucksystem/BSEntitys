package br.com.bucksystem.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the Usuarios database table.
 * 
 */
@Entity
@Table(name="Usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="USUA_ChpUsuario")
	private int id;

	@Column(name="USUA_ChaUsuario")
	private String usuario;

	@Column(name="USUA_DsaEmail")
	private String email;

	@Column(name="USUA_DsaPassWord")
	private String senha;

	@Version
	private Timestamp versao;

	//bi-directional one-to-one association to Empresa
	@OneToOne(mappedBy="usuario", fetch=FetchType.LAZY)
	private Empresa empresa1;

	//bi-directional many-to-one association to Empresa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USUA_ChpEmpresa")
	private Empresa empresa2;

	//bi-directional many-to-one association to UsuariosTipo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USUA_ChpUsuarioTipo")
	private UsuarioTipo usuariosTipo;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Timestamp getVersao() {
		return this.versao;
	}

	public void setVersao(Timestamp versao) {
		this.versao = versao;
	}

	public Empresa getEmpresa1() {
		return this.empresa1;
	}

	public void setEmpresa1(Empresa empresa1) {
		this.empresa1 = empresa1;
	}

	public Empresa getEmpresa2() {
		return this.empresa2;
	}

	public void setEmpresa2(Empresa empresa2) {
		this.empresa2 = empresa2;
	}

	public UsuarioTipo getUsuariosTipo() {
		return this.usuariosTipo;
	}

	public void setUsuariosTipo(UsuarioTipo usuariosTipo) {
		this.usuariosTipo = usuariosTipo;
	}

}