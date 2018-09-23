/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HEROS
 */
@Entity
@Table(name = "CUSTREG")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "CustomerRegistration.findAll", query = "SELECT c FROM CustomerRegistration c")
    , @NamedQuery(name = "CustomerRegistration.findByName", query = "SELECT c FROM CustomerRegistration c WHERE c.name = :name")
    , @NamedQuery(name = "CustomerRegistration.findByPassword", query = "SELECT c FROM CustomerRegistration c WHERE c.password = :password")
    , @NamedQuery(name = "CustomerRegistration.findByEmail", query = "SELECT c FROM CustomerRegistration c WHERE c.email = :email")
})
public class CustomerRegistration implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Id
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "STATUS")
    private boolean Status;

    public void setStatus(boolean Status)
    {
        this.Status = Status;
    }

    public boolean getStatus()
    {
        return Status;
    }
    public CustomerRegistration()
    {
    }

    public CustomerRegistration(String email)
    {
        this.email = email;
    }

    public CustomerRegistration(String email, String name, String password)
    {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerRegistration))
        {
            return false;
        }
        CustomerRegistration other = (CustomerRegistration) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "DAo.CustomerRegistration[ email=" + email + " ]";
    }
    
}
