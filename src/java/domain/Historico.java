/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "historico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historico.findAll", query = "SELECT h FROM Historico h")
    , @NamedQuery(name = "Historico.findByIdhistorico", query = "SELECT h FROM Historico h WHERE h.idhistorico = :idhistorico")
    , @NamedQuery(name = "Historico.findByOpera\u00e7ao", query = "SELECT h FROM Historico h WHERE h.opera\u00e7ao = :opera\u00e7ao")
    , @NamedQuery(name = "Historico.findByTipoMovimento", query = "SELECT h FROM Historico h WHERE h.tipoMovimento = :tipoMovimento")
    , @NamedQuery(name = "Historico.findByDataHora", query = "SELECT h FROM Historico h WHERE h.dataHora = :dataHora")
    , @NamedQuery(name = "Historico.findByValor", query = "SELECT h FROM Historico h WHERE h.valor = :valor")
    , @NamedQuery(name = "Historico.findByObservacao", query = "SELECT h FROM Historico h WHERE h.observacao = :observacao")})
public class Historico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhistorico")
    private Integer idhistorico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "opera\u00e7ao")
    private String operaçao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoMovimento")
    private String tipoMovimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "conta_id", referencedColumnName = "idconta")
    @ManyToOne(optional = false)
    private Conta contaId;

    public Historico() {
    }

    public Historico(Integer idhistorico) {
        this.idhistorico = idhistorico;
    }

    public Historico(Integer idhistorico, String operaçao, String tipoMovimento, Date dataHora, double valor, String observacao) {
        this.idhistorico = idhistorico;
        this.operaçao = operaçao;
        this.tipoMovimento = tipoMovimento;
        this.dataHora = dataHora;
        this.valor = valor;
        this.observacao = observacao;
    }

    public Integer getIdhistorico() {
        return idhistorico;
    }

    public void setIdhistorico(Integer idhistorico) {
        this.idhistorico = idhistorico;
    }

    public String getOperaçao() {
        return operaçao;
    }

    public void setOperaçao(String operaçao) {
        this.operaçao = operaçao;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Conta getContaId() {
        return contaId;
    }

    public void setContaId(Conta contaId) {
        this.contaId = contaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhistorico != null ? idhistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historico)) {
            return false;
        }
        Historico other = (Historico) object;
        if ((this.idhistorico == null && other.idhistorico != null) || (this.idhistorico != null && !this.idhistorico.equals(other.idhistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Historico[ idhistorico=" + idhistorico + " ]";
    }
    
}
