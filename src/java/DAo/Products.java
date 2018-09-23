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
@Table(name = "PRODUCTS")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p")
    , @NamedQuery(name = "Products.findByProductId", query = "SELECT p FROM Products p WHERE p.productId = :productId")
    , @NamedQuery(name = "find Products by proName", query = "SELECT p FROM Products p WHERE p.proName = :proName")
    , @NamedQuery(name = "Products.findByProCategory", query = "SELECT p FROM Products p WHERE p.proCategory = :proCategory")
    , @NamedQuery(name = "Products.findByProPrice", query = "SELECT p FROM Products p WHERE p.proPrice = :proPrice")
    , @NamedQuery(name = "Products.findByProDescription", query = "SELECT p FROM Products p WHERE p.proDescription = :proDescription")
    , @NamedQuery(name = "Products.findByProductquantity", query = "SELECT p FROM Products p WHERE p.productquantity = :productquantity")
   
})
public class Products implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRODUCT_ID")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    @Basic(optional = false)
    @Column(name = "PRO_NAME")
    private String proName;
    @Basic(optional = false)
    @Column(name = "PRO_CATEGORY")
    private String proCategory;
    @Basic(optional = false)
    @Column(name = "PRO_PRICE")
    private double proPrice;
    @Basic(optional = false)
    @Column(name = "PRO_DESCRIPTION")
    private String proDescription;
    @Basic(optional = false)
    @Column(name = "PRODUCTQUANTITY")
    private int productquantity;
    @Basic(optional = false)
    @Column(name = "PRODUCTIMAGE")
    private String productimage;

    public Products()
    {
    }

    public Products(Integer productId)
    {
        this.productId = productId;
    }

    public Products(Integer productId, String proName, String proCategory, double proPrice, String proDescription, int productquantity, String productimage)
    {
        this.productId = productId;
        this.proName = proName;
        this.proCategory = proCategory;
        this.proPrice = proPrice;
        this.proDescription = proDescription;
        this.productquantity = productquantity;
        this.productimage = productimage;
    }

    public Integer getProductId()
    {
        return productId;
    }

    public void setProductId(Integer productId)
    {
        this.productId = productId;
    }

    public String getProName()
    {
        return proName;
    }

    public void setProName(String proName)
    {
        this.proName = proName;
    }

    public String getProCategory()
    {
        return proCategory;
    }

    public void setProCategory(String proCategory)
    {
        this.proCategory = proCategory;
    }

    public double getProPrice()
    {
        return proPrice;
    }

    public void setProPrice(double proPrice)
    {
        this.proPrice = proPrice;
    }

    public String getProDescription()
    {
        return proDescription;
    }

    public void setProDescription(String proDescription)
    {
        this.proDescription = proDescription;
    }

    public int getProductquantity()
    {
        return productquantity;
    }

    public void setProductquantity(int productquantity)
    {
        this.productquantity = productquantity;
    }

    public String getProductimage()
    {
        return productimage;
    }

    public void setProductimage(String productimage)
    {
        this.productimage = productimage;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products))
        {
            return false;
        }
        Products other = (Products) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "DAo.Products[ productId=" + productId + " ]";
    }
    
}
