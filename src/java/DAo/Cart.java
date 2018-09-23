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
@Table(name = "CART")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c")
    , @NamedQuery(name = "Cart.findById", query = "SELECT c FROM Cart c WHERE c.id = :id")
    , @NamedQuery(name = "Cart.findByEmailid", query = "SELECT c FROM Cart c WHERE c.emailid = :emailid")
    , @NamedQuery(name = "Cart.findByProductcode", query = "SELECT c FROM Cart c WHERE c.productcode = :productcode")
    , @NamedQuery(name = "Cart.findByQuantity", query = "SELECT c FROM Cart c WHERE c.quantity = :quantity")
    , @NamedQuery(name = "Cart.findByCartmodifieddate", query = "SELECT c FROM Cart c WHERE c.cartmodifieddate = :cartmodifieddate")
})
public class Cart implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "EMAILID")
    private String emailid;
    @Basic(optional = false)
    @Column(name = "PRODUCTCODE")
    private int productcode;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "CARTMODIFIEDDATE")
    private String cartmodifieddate;

    public Cart()
    {
    }

    public Cart(Integer id)
    {
        this.id = id;
    }

    public Cart(Integer id, String emailid, int productcode)
    {
        this.id = id;
        this.emailid = emailid;
        this.productcode = productcode;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getEmailid()
    {
        return emailid;
    }

    public void setEmailid(String emailid)
    {
        this.emailid = emailid;
    }

    public int getProductcode()
    {
        return productcode;
    }

    public void setProductcode(int productcode)
    {
        this.productcode = productcode;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public String getCartmodifieddate()
    {
        return cartmodifieddate;
    }

    public void setCartmodifieddate(String cartmodifieddate)
    {
        this.cartmodifieddate = cartmodifieddate;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart))
        {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "DAo.Cart[ id=" + id + " ]";
    }
    
}
